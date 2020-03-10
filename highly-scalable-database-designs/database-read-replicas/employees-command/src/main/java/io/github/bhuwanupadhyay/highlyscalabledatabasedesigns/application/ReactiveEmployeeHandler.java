package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.application;

import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeDomain.*;
import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.domain.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalTime;
import java.util.function.Supplier;

import static io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.application.EmployeeHandler.ServerResource.withErrors;
import static io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.application.EmployeeHandler.ServerResource.withSuccess;
import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
class ReactiveEmployeeHandler implements EmployeeHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ReactiveEmployeeHandler.class);
    private final EmployeeRepository employeeRepository;
    private final ErrorResolver errorResolver;

    public ReactiveEmployeeHandler(EmployeeRepository employeeRepository,
                                   ErrorResolver errorResolver) {
        this.employeeRepository = employeeRepository;
        this.errorResolver = errorResolver;
    }

    @Override
    public Mono<ServerResponse> createEmployee(ServerRequest request) {

        LOG.debug("create employee at: {}", LocalTime.now());

        return request.bodyToMono(EmployeeRequest.class)
                .map(command -> {
                    Employee newEmployee = new Employee(null, new EmployeeName(command.name()));
                    Employee savedEmployee = employeeRepository.save(newEmployee);
                    return new EmployeeResource(savedEmployee.employeeId().id(), savedEmployee.name().name());
                }).flatMap(resource -> ok().bodyValue(resource));

    }

    @Override
    public Mono<ServerResponse> updateEmployee(ServerRequest request) {
        String id = request.pathVariable(EMPLOYEE_ID);

        LOG.debug("update employee id: {}", id);

        return employeeRepository.find(new EmployeeId(id))
                .map(employee -> request.bodyToMono(EmployeeRequest.class)
                        .doOnNext(r -> employee.update(new UpdateEmployeeCommand(r.name())))
                        .map(i -> employeeRepository.save(employee))
                        .map(e -> new EmployeeResource(e.employeeId().id(), e.name().name()))
                        .flatMap(resource -> ok().bodyValue(withSuccess(resource))))
                .orElseGet(employeeNotFound(id));
    }

    @Override
    public Mono<ServerResponse> deleteEmployee(ServerRequest request) {

        String id = request.pathVariable(EMPLOYEE_ID);

        LOG.debug("delete employee id: {}", id);

        return employeeRepository.find(new EmployeeId(id))
                .map(employee -> request.bodyToMono(EmployeeRequest.class)
                        .doOnNext(r -> employee.delete(new DeleteEmployeeCommand(r.name())))
                        .map(i -> employeeRepository.save(employee))
                        .map(e -> new EmployeeResource(e.employeeId().id(), e.name().name()))
                        .flatMap(resource -> ok().bodyValue(withSuccess(resource))))
                .orElseGet(employeeNotFound(id));
    }

    private Supplier<Mono<ServerResponse>> employeeNotFound(String id) {
        return () -> badRequest().bodyValue(withErrors(errorResolver.resolve(EMPLOYEE_ENTITY_NOT_FOUND, id)));
    }
}

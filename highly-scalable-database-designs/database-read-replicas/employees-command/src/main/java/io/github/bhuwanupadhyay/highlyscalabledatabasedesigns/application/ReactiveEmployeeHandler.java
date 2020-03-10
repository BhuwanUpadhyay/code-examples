package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.web;

import io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.EmployeeHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
class ReactiveEmployeeHandler implements EmployeeHandler {

    @Override
    public Mono<ServerResponse> createEmployee(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> updateEmployee(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> deleteEmployee(ServerRequest request) {
        return null;
    }
}

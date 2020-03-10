package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeHandler {

    String EMPLOYEE_ID = "id";
    String EMPLOYEE_ENTITY_NOT_FOUND = "employee_entity_not_found";

    Mono<ServerResponse> createEmployee(ServerRequest request);

    Mono<ServerResponse> updateEmployee(ServerRequest request);

    Mono<ServerResponse> deleteEmployee(ServerRequest request);

    record EmployeeRequest(String name) {
    }

    record EmployeeResource(String employeeId, String name) {
    }

    record MessageResource(String lang, String value) {
    }

    record ErrorResource(String errorId, List<MessageResource>errors) {
    }

    record ServerResource<T>(int statusCode, T resource, List<ErrorResource>errors) {

        public static <E> ServerResource<E> withSuccess(E resource) {
            return new ServerResource<>(HttpStatus.OK.value(), resource, new ArrayList<>());
        }

        public static ServerResource<Void> withErrors(ErrorResource... errors) {
            return new ServerResource<>(HttpStatus.BAD_REQUEST.value(), null, List.of(errors));
        }
    }

}

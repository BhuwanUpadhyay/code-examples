package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface EmployeeHandler {

    Mono<ServerResponse> createEmployee(ServerRequest request);

    Mono<ServerResponse> updateEmployee(ServerRequest request);

    Mono<ServerResponse> deleteEmployee(ServerRequest request);

}

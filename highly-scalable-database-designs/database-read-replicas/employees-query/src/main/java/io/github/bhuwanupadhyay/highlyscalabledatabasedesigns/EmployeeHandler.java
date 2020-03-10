package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface EmployeeHandler {

    Mono<ServerResponse> getEmployee(ServerRequest request);

    Mono<ServerResponse> listEmployee(ServerRequest request);

}

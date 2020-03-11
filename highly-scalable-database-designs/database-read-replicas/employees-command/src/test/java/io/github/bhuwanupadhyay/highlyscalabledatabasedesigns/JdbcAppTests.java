package io.github.bhuwanupadhyay.highlyscalabledatabasedesigns;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static io.github.bhuwanupadhyay.highlyscalabledatabasedesigns.application.EmployeeHandler.EmployeeRequest;

@SpringBootTest(
        classes = App.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class JdbcAppTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private WebTestClient client;

    @LocalServerPort
    private int serverPort;

    @Test
    void canCreateEmployee() {
        this.client.post()
                .uri(
                        builder -> builder
                                .port(serverPort)
                                .path("/employees")
                                .build()
                )
                .body(BodyInserters.fromValue(new EmployeeRequest("Apple Gamma")))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.resource").isNotEmpty()
                .jsonPath("$.resource.name").isNotEmpty()
                .jsonPath("$.resource.name").isEqualTo("Apple Gamma");
    }

}

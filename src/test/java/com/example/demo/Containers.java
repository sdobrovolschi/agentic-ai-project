package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import static org.testcontainers.postgresql.PostgreSQLContainer.POSTGRESQL_PORT;

@Testcontainers(parallel = true)
public interface Containers {

    Logger log = LoggerFactory.getLogger("app");

    Network network = Network.newNetwork();

    @Container
    @ServiceConnection
    PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:9.6.12")
            .withNetwork(network)
            .withNetworkAliases(PostgreSQLContainer.NAME);

    @Container
    GenericContainer<?> app = new GenericContainer<>("demo:0.0.1-SNAPSHOT")
            .dependsOn(postgres)
            .withNetwork(network)
            .withNetworkAliases("app")
            .withExposedPorts(8080)
            .withEnv("SPRING_DATASOURCE_URL", "jdbc:postgresql://%s:%s/test".formatted(PostgreSQLContainer.NAME, POSTGRESQL_PORT))
            .withEnv("SPRING_DATASOURCE_USERNAME", "test")
            .withEnv("SPRING_DATASOURCE_PASSWORD", "test")
            .withLogConsumer(new Slf4jLogConsumer(log).withSeparateOutputStreams())
            .waitingFor(Wait.forHttp("/readyz"));

    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        registry.add("local.server.host", app::getHost);
        registry.add("local.server.port", () -> app.getMappedPort(8080));
    }
}

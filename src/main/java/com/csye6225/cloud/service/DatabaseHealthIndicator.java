package com.csye6225.cloud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@RequiredArgsConstructor
@Service
public class DatabaseHealthIndicator implements HealthIndicator {
    private final DataSource dataSource;

    /**
     * Database connectivity health check
     *
     * @return Health (Status.UP or Status.DOWN)
     */
    @Override
    public Health health() {
        try (Connection ignored = dataSource.getConnection()) {
            return Health.up().build();
        } catch (SQLException e) {
            log.error("Exception while trying to connect to the database: {}", e.getMessage());
        }
        return Health.down().build();
    }
}

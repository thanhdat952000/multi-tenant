package com.example.demo.config.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Long> {
    boolean existsByTenantId(String tenantId);

    @Query(value = "SELECT tenant_id FROM datasource_config", nativeQuery = true)
    List<String> findAllTenantId();
}

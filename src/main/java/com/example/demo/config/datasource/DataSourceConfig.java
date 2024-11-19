package com.example.demo.config.datasource;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "datasource_config")
public class DataSourceConfig {
    @Id
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "driver_class_name")
    private String driverClassName;

    @Column(name = "tenant_id")
    private String tenantId;
}


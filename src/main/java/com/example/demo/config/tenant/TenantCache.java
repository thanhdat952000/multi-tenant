package com.example.demo.config.tenant;

import com.example.demo.config.datasource.DataSourceConfigRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TenantCache {
    private final static Set<String> schemaCache = new HashSet<>();

    @Autowired
    private DataSourceConfigRepository configRepo;

    @Autowired
    private static DataSource dataSource;

    @PostConstruct
    public void loadSchemas() {
        List<String> schemas = configRepo.findAllTenantId();
        schemaCache.addAll(schemas);
    }

    public static boolean schemaExists(String tenantId) {
        return schemaCache.contains(tenantId);
    }

//    public static boolean schemaExists(String tenantId) {
//        String query = "SELECT 1 FROM information_schema.schemata WHERE schema_name = ?";
//        try (Connection connection = dataSource.getConnection();
//             PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, tenantId);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                return resultSet.next();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Lỗi kiểm tra schema tồn tại", e);
//        }
//    }
}
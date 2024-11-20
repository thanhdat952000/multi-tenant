package com.example.demo.config.schema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SchemaListerSQL {
    private static final ConcurrentHashMap<String, Boolean> schemaCache = new ConcurrentHashMap<>();

    @Autowired
    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public SchemaListerSQL(JdbcTemplate jdbcTemplate) {
        SchemaListerSQL.jdbcTemplate = jdbcTemplate;
    }

    public static boolean isSchemaExists(String schemaName) {
        if (schemaCache.containsKey(schemaName)) {
            return schemaCache.get(schemaName);
        }

        String sql = "SELECT schema_name FROM information_schema.schemata WHERE schema_name = ?";
        boolean exists = Boolean.TRUE.equals(jdbcTemplate.query(sql, new Object[]{schemaName}, ResultSet::next));

        schemaCache.put(schemaName, exists);
        return exists;
    }
}

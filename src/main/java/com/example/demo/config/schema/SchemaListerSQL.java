package com.example.demo.config.schema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class SchemaListerSQL {
    @Autowired
    private static DataSource dataSource;

    @Autowired
    public SchemaListerSQL(DataSource dataSource) {
        SchemaListerSQL.dataSource = dataSource;
    }

    public static List<String> getAllSchemas() {
        List<String> schemas = new ArrayList<>();
        String query = "SELECT schema_name FROM information_schema.schemata";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                schemas.add(rs.getString("schema_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schemas;
    }

    public static boolean isSchemaExists(String schemaToCheck) {
        List<String> schemas = getAllSchemas();
        return schemas.contains(schemaToCheck);
    }
}
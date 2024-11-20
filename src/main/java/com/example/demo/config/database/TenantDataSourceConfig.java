//package com.example.demo.config.database;
//
//import com.example.demo.domain.TenantConfig;
//import com.example.demo.repository.TenantConfigRepository;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Component
//public class TenantDataSourceConfig {
//
//    @Autowired
//    private TenantConfigRepository tenantConfigRepository;
//
//    private static final Map<String, DataSource> tenantDataSources = new HashMap<>();
//
//    @PostConstruct
//    public void loadTenantConfigurations() {
//        // Giả sử bạn có repository hoặc service để lấy dữ liệu từ bảng tenant_config
//        List<TenantConfig> tenantConfigs = tenantConfigRepository.findAll();
//        System.out.println("tenantConfig" + tenantConfigs);
//
//        for (TenantConfig config : tenantConfigs) {
//            DataSource dataSource = DataSourceBuilder.create()
//                    .url(config.getUrl())
//                    .username(config.getUserName())
//                    .password(config.getPassword())
//                    .build();
//            tenantDataSources.put(config.getTenantId(), dataSource);
//        }
//    }
//
//    public static DataSource getDataSource(String tenantId) {
//        return tenantDataSources.get(tenantId);
//    }
//}
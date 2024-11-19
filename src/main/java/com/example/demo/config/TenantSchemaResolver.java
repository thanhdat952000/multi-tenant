package com.example.demo.config;

import com.example.demo.config.tenant.TenantCache;
import com.example.demo.exception.HandleException;
import com.example.demo.utils.Constants;
import com.example.demo.utils.Messages;
import io.micrometer.common.util.StringUtils;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantSchemaResolver implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenantId = TenantContext.getCurrentTenant();
        if (StringUtils.isNotBlank(tenantId)) {
            if (!TenantCache.schemaExists(tenantId)) {
                throw new HandleException(Messages.SCHEMA_NOT_FOUND + tenantId);
            }
            return tenantId;
        } else {
            return Constants.TENANT_DEFAULT;
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}

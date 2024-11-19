package com.example.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        String tenantID = request.getHeader("X-TenantID");
        System.out.println("Search for X-TenantID  :: " + tenantID);
        System.out.println("____________________________________________");
//        if (tenantID.isEmpty()) {
//            response.getWriter().write("X-TenantID not present in the Request Header");
//            response.setStatus(400);
//            return false;
//        }
        TenantContext.setCurrentTenant(tenantID);
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TenantContext.clear();
    }

}
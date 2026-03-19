package com.stu.demo1.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import java.io.PrintWriter;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String uri = request.getRequestURI();

        // 精细化放行：注册(POST)、查询(GET)直接放行
        boolean isCreate = "POST".equals(method) && "/api/users".equals(uri);
        boolean isGet = "GET".equals(method) && uri.startsWith("/api/users/");

        if (isCreate || isGet) {
            return true;
        }

        // 敏感操作校验 Token
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("{\"code\":401,\"msg\":\"敏感操作需携带Token\",\"data\":null}");
            out.flush();
            out.close();
            return false;
        }
        return true;
    }
}
package dev.idriz.easyauth.security;

import dev.idriz.easyauth.annotations.AuthenticatedOnly;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class SecurityEndpointHandler implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod handlerMethod)) return true;

        var javaMethod = handlerMethod.getMethod();
        if (!javaMethod.isAnnotationPresent(AuthenticatedOnly.class)) return true;

        var authenticatedOnly = javaMethod.getAnnotation(AuthenticatedOnly.class);

        return true;
    }
}

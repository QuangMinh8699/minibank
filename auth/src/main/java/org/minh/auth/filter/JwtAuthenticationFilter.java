package org.minh.auth.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = extractToken(request);

        if (StringUtils.isNotBlank(token)) {}

    }

    private String extractToken(HttpServletRequest request) {
        String token = null;
        String header = request.getHeader("Authorization");
        if (StringUtils.isNotBlank(header) && header.startsWith("Bearer ")) {
            token = header.substring(7).trim();
        }
        return token;
    }
}

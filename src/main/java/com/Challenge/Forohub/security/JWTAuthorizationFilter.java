package com.Challenge.Forohub.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;
import java.util.ArrayList;

import static com.Challenge.Forohub.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final HandlerExceptionResolver exceptionResolver;

    public JWTAuthorizationFilter(AuthenticationManager authManager, HandlerExceptionResolver exceptionResolver) {
        super(authManager);
        this.exceptionResolver = exceptionResolver; // Asigna el HandlerExceptionResolver
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        try {
            UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(req, res);
        } catch (Exception e) {
            exceptionResolver.resolveException((HttpServletRequest) e, (HttpServletResponse) req, res, (Exception) null); // Usa el HandlerExceptionResolver para manejar la excepción
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            try {
                String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes()))
                        .build()
                        .verify(token.replace(TOKEN_PREFIX, ""))
                        .getSubject();

                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                }
            } catch (JWTVerificationException exception) {
                // Maneja específicamente las excepciones de JWT aquí
                exceptionResolver.resolveException((HttpServletRequest) exception, (HttpServletResponse) request, request, null); // Usa el HandlerExceptionResolver para manejar la excepción
            }
        }
        return null;
    }
}

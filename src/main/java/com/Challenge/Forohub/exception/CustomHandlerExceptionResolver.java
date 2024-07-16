package com.Challenge.Forohub.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value()); // O cualquier otro código de estado apropiado
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Devuelve null porque no necesitas devolver un ModelAndView aquí
    }
}

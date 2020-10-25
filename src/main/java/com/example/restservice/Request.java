package com.example.restservice;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Request {

    @RequestMapping("/request/**")
    public Respuesta request(HttpServletRequest request) throws IOException {
        Respuesta respuesta = new Respuesta();
        respuesta.headers = getHeades(request);
        respuesta.parameters = getParameters(request);
        respuesta.setBody(request.getInputStream());
        respuesta.method = request.getMethod();
        respuesta.url = request.getRequestURI();
        return respuesta;
    }
    private Map<String,String> getParameters(HttpServletRequest request) {

        Map<String,String> param = new HashMap<String, String>();
        Enumeration<String> paramKeys = request.getParameterNames();
        while ( paramKeys.hasMoreElements()) {
            String parameterKey= paramKeys.nextElement();
            param.put(parameterKey, request.getParameter(parameterKey));
        }
        return param;
    }
    private Map<String,String> getHeades(HttpServletRequest request) {

        Map<String,String> headers = new HashMap<String, String>();
        Enumeration<String> nameHeaders = request.getHeaderNames();

        while ( nameHeaders.hasMoreElements()) {
            String nameHeader = nameHeaders.nextElement();
            headers.put(nameHeader, request.getHeader(nameHeader) );
        }
        return headers;
    }

 
}

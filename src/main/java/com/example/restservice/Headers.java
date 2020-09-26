package com.example.restservice;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Headers {
    
private @Autowired 
HttpServletRequest request;

    @GetMapping("/headers")
    public Map<String,String> getHeaders() {

        Map<String,String> headers = new HashMap<String, String>();
        Enumeration<String> nameHeaders = request.getHeaderNames();

        while ( nameHeaders.hasMoreElements()) {
            String nameHeader = nameHeaders.nextElement();
            headers.put(nameHeader, request.getHeader(nameHeader) );
        }
        return headers;
    }


}

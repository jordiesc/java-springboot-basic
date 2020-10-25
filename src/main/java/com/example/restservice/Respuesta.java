package com.example.restservice;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletInputStream;

public class Respuesta {
        public Map<String,String> headers;
        public Map<String,String> parameters;
        public String url;
        public String method;
        public String body;

        public void setBody(ServletInputStream inputStream){
            
            try {
               this.body = new String(inputStream.readAllBytes());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }    
}

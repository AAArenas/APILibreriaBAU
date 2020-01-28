package com.baufest.Libreria.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    SessionFactoryHandler sessionFactoryHandler;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        System.out.println("----------  La request es un : " +  request.getMethod() + "  --------------");

        if(request.getMethod().equals("GET")){
            System.out.println("-----------  se usa la session de lectura  -------------");
            sessionFactoryHandler.setSessionToLectura();
        }
        else
        {
            System.out.println("--------------  se usa la session de escritura  -------------- ");
            sessionFactoryHandler.setSessionToEscritura();
        }

        return true;
    }
}

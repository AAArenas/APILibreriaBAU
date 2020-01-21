package com.baufest.Libreria.session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryHandler {

    @Autowired
    SessionHandler sessionHandler;

    SessionFactory sfLectura;
    SessionFactory sfEscritura;

    @PostConstruct
    public void BuildSessionFactorys(){
        HibernateUtil hibernateUtil = new HibernateUtil();
        sfLectura =  hibernateUtil.getSessionFactory("select");
        sfEscritura = hibernateUtil.getSessionFactory("insert");
    }

    public void setSessionToLectura(){
        sessionHandler.setFactory(sfLectura);
    }

    public void setSessionToEscritura(){
        sessionHandler.setFactory(sfEscritura);
    }
}

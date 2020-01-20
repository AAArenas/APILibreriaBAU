package com.baufest.Libreria.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SessionHandler {

    SessionFactory sessionFactory;

    public void setFactory(SessionFactory otherInstance){
        sessionFactory = otherInstance;
    }


    public Session getSession(){
        return sessionFactory.openSession();
    }
}

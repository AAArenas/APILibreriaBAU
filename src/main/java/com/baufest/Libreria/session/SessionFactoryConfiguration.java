package com.baufest.Libreria.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class SessionFactoryConfiguration {

    @Autowired
    HibernateUtil hibernateUtil;

    @Bean
    SessionFactory sessionFactoryLecutura(){
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory("lectura");
        return sessionFactory;
    }

    @Bean
    SessionFactory sessionFactoryEscritura(){
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory("escritura");
        return sessionFactory;
    }
}

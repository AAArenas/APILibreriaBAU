package com.baufest.Libreria.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SessionConfiguration {

    @Autowired
    SessionFactory sessionFactory;

    @Bean
    Session sessionBoot(){
        Session session = sessionFactory.openSession();
        return session;
    }
}

package com.baufest.Libreria.session;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private StandardServiceRegistry registry;
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                //create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                System.out.println("registry: " + registry);
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata

                Metadata metadata = sources.getMetadataBuilder().build();

                System.out.println("sources: " + sources);
                System.out.println("metaBuilder: " + sources.getMetadataBuilder());

                // Create SessionFactory

                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e ) {

                e.printStackTrace();
                if (registry != null){
                    StandardServiceRegistryBuilder.destroy(registry);
                }

            }
        }

        return sessionFactory;

    }

    public void shutdown() {
        if (registry != null){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}


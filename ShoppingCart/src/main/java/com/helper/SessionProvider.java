package com.helper;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionProvider
{
    private static SessionFactory factory;
    
    public static Session getSession() {
        if (SessionProvider.factory == null) {
            SessionProvider.factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return SessionProvider.factory.openSession();
    }
}
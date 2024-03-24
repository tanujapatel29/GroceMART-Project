/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grocemart.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author tanuj
 */


public class FactoryProvider {

    private static SessionFactory factory;

    // Private constructor to prevent instantiation
    private FactoryProvider() {
    }

    public static SessionFactory getFactory() {
        if (factory == null) {
            try {
                factory = new Configuration()
                        .configure()
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exception properly, maybe throw a custom exception
            }
        }
        return factory;
    }

    public static void closeFactory() {
        if (factory != null) {
            factory.close();
            factory = null;
        }
    }
}

     
     
    


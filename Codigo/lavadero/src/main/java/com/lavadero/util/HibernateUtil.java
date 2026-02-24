package com.lavadero.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();

            // 🔹 Ruta dinámica profesional en AppData
            String userHome = System.getProperty("user.home");
            String dbFolder = userHome + "\\AppData\\Local\\Lavadero";

            // Crear carpeta si no existe
            File folder = new File(dbFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String dbPath = dbFolder + "\\lavadero";

            configuration.setProperty(
                    "hibernate.connection.url",
                    "jdbc:h2:" + dbPath
            );

            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

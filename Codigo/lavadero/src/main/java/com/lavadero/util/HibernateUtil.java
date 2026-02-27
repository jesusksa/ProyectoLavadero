package com.lavadero.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();

            // 🔹 Obtiene la carpeta donde está corriendo el programa
            String currentDir = System.getProperty("user.dir");

            // Creamos una subcarpeta llamada 'data' para que no estén los archivos sueltos
            String dbFolder = currentDir + File.separator + "database";

            File folder = new File(dbFolder);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // Ruta final: ./database/lavadero
            String dbPath = dbFolder + File.separator + "lavadero";

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

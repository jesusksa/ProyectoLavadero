package com.lavadero;


import com.lavadero.util.CargaDatos;
import com.lavadero.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.Getter;

import javafx.scene.image.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Getter
    private static Stage mainStage;

    @Override
    public void init() {
        // 🔥 Se ejecuta antes de que arranque JavaFX

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {

            Long count = session.createQuery(
                    "select count(u) from usuario u", Long.class
            ).uniqueResult();

            if (count == 0) {
                CargaDatos.cargar();
            }
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        scene = new Scene(loadFXML("sesion"));
        stage.setTitle("Lavadero");
        Image icono = new Image(getClass().getResourceAsStream("/images/icono-ventana.png"));
        stage.getIcons().add(icono);
        stage.setScene(scene);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(screenBounds.getMinX());
        stage.setY(screenBounds.getMinY());
        stage.setWidth(screenBounds.getWidth());
        stage.setHeight(screenBounds.getHeight());

        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/viewsNew/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
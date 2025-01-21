package com.lavadero;


import com.lavadero.controllers.SesionController;
import com.lavadero.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.Getter;
import org.hibernate.SessionFactory;
import javafx.scene.image.Image;


import java.io.IOException;
import java.io.InputStream;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Getter
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        stage.setMaximized(true);
        scene = new Scene(loadFXML("inicio-sesion"));
        stage.setTitle("Lavadero");
        Image icono = new Image(getClass().getResourceAsStream("/images/icono-ventana.png"));
        stage.getIcons().add(icono);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/views/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    }
}
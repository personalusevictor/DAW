package org.club;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage primaryStage;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws Exception {
        primaryStage = stage;
        loadScene("main.fxml");
        stage.setTitle("Club de Películas");
        stage.setResizable(false);
        stage.show();
    }

    public static void loadScene(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(
            App.class.getResource("/org/club/" + fxml)
        );
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
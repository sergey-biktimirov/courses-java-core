package ru.geekbrains.courses.sbiktimirov.javacore.baselevel.lesson8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("main.fxml"));

        Parent root = loader.load();

        ((Controller) loader.getController()).init();

        primaryStage.setTitle("Hello World");

        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


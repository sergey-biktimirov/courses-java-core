package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson4.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson4.app.views.ChatView;

public class App extends Application {
    
    @Override
    public void init() {

    }

    @Override
    public void start(Stage stage){
        Scene scene = new Scene(ChatView.getView(), 640, 480);
        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}

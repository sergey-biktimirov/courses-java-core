package ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.geekbrains.courses.sbiktimirov.javacore.advancedlevel.lesson7.app.views.ChatView;

public class App extends Application {

    private static boolean isClosed = false;

    @Override
    public void init() {

    }

    @Override
    public void start(Stage stage){
        Scene scene = new Scene(ChatView.getView(), 640, 480);
        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            setClosed(true);
        });
    }

    static synchronized public boolean isClosed() {
        return isClosed;
    }

    synchronized public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public static void main(String args[]) {
        launch(args);
    }
}

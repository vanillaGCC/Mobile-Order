package com.example.mobileorder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MobileOrder extends Application {
    @Override
    public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(MobileOrder.class.getResource("/com/example/mobileorder/mainview.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("MobileOrder");
            stage.setScene(scene);
            stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
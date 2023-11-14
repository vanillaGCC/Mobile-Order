package com.example.mobileorder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.mobileorder.Item.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
            //new connectionToDB();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/mobileorder/mainview.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello world!");
            stage.setScene(scene);
            stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
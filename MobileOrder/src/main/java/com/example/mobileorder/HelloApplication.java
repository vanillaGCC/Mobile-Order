package com.example.mobileorder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //String url = "jdbc:postgresql://jtokushima.data.ise.shibaura-it.ac.jp/group8";
        String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/group8";
        String user = "al21074";
        String password = "bond";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            // データベースへの接続が成功した場合の処理
            Statement stmt = connection.createStatement();
            String sql = "SELECT * from 区分";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String kID = rs.getString("商品区分コード");
                String kName = rs.getString("商品区分");
                System.out.println(kID+" "+kName);
            }

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Hello");
            stage.setScene(scene);
            stage.show();
            // ここでデータベース操作を実行できます

            // 接続を閉じる
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}
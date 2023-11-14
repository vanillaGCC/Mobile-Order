package com.example.mobileorder;

import com.example.mobileorder.Item.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class connectionToDB {
    public static ObservableList<Item> getItemsFromDatabase() {
        ObservableList<Item> itemList = FXCollections.observableArrayList();
        String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/group8";
        String user = "al21074";
        String password = "bond";
        String sql = "SELECT 商品コード, 商品名, 単価, 商品区分コード FROM 商品";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String code = rs.getString("商品コード");
                String name = rs.getString("商品名");
                int price = rs.getInt("単価");
                int kubun = rs.getInt("商品区分コード");

                Item item = new Item(name, price, code, kubun);
                itemList.add(item);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // 本番環境では適切なエラーハンドリングが必要
        }


        return itemList;
    }

    public static void insertOrderIntoDatabase(String productCode, String orderId, int quantity, int price, int taxExcludedPrice, int tax, double totalPrice) {
        // データベースに注文を挿入する処理
        // JDBCを使用してデータベースに接続し、INSERT文を実行
        ObservableList<Item> itemList = FXCollections.observableArrayList();
        String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/group8";
        String user = "al21074";
        String password = "bond";
        String sql = "INSERT INTO  商品注文(商品コード, 注文番号, 個数, 金額, 税抜額, 消費税,合計) VALUES (?, ?, ?, ?, ?, ?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // パラメータの設定
            pstmt.setString(1, productCode);
            pstmt.setString(2, orderId);
            pstmt.setInt(3, quantity);
            pstmt.setInt(4, price);
            pstmt.setInt(5, taxExcludedPrice);
            pstmt.setInt(6, tax);
            pstmt.setDouble(7, totalPrice);

            // SQL文の実行
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // 実際のアプリケーションでは、適切なエラーハンドリングが必要です
        }

    }

    public static void inserCardIntoDatabase(String orderId, String cardNumber, String cardHolderName, String expirationDate, String formattedDateTime) {
        // データベースに注文を挿入する処理
        // JDBCを使用してデータベースに接続し、INSERT文を実行
        ObservableList<Item> itemList = FXCollections.observableArrayList();
        String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/group8";
        String user = "al21074";
        String password = "bond";

        String sql = "INSERT INTO 注文詳細 (注文番号, クレジットカード番号, 名義, 有効期限, 購入日時) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, orderId);
            pstmt.setString(2, cardNumber);
            pstmt.setString(3, cardHolderName);
            pstmt.setString(4, expirationDate);
            pstmt.setString(5, formattedDateTime);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // エラーハンドリング
        }

    }

    public static String getNextOrderId() {
        String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/group8";
        String user = "al21074";
        String password = "bond";
        String orderId = null;

        String sql = "SELECT nextval('order_id_seq')"; // シーケンスから次の値を取得

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                orderId = rs.getString(1); // 次のシーケンス値を取得
            }

        } catch (SQLException e) {
            e.printStackTrace(); // エラーハンドリングは適切に行う
        }

        return orderId;
    }


}
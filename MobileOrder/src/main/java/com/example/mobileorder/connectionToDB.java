package com.example.mobileorder;

import com.example.mobileorder.Item.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class connectionToDB {
    public static List<Item> getItemsFromDatabase() {
        List<Item> items = new ArrayList<>();
        String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/group8";
        String user = "al21074";
        String password = "bond";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM 商品");

            while (rs.next()) {
                String name = rs.getString("商品名");
                String menuCode = rs.getString("商品コード");
                double price = rs.getDouble("単価");
                String kubunCode = rs.getString("商品区分コード");
               // int quantity = rs.getInt("quantity");
                items.add(new Item(name, menuCode, price, kubunCode));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            // エラー処理
        }
        return items;
    }
}
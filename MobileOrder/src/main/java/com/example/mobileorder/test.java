package com.example.mobileorder;

import com.example.mobileorder.Item.Item;

import java.sql.*;

public class test {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/group8";
        String user = "al21074";
        String password = "bond";

        //String sql = "SELECT*FROM 商品注文";
        String sql = "SELECT*FROM 注文詳細";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String a=rs.getString("クレジットカード番号");
                    String b=rs.getString("購入日時");
                    /*String name = rs.getString("注文番号");
                    String code = rs.getString("商品コード");
                    String a=rs.getString("個数");
                    String b=rs.getString("金額");
                    String c=rs.getString("税抜額");
                    String d=rs.getString("消費税");
                    String e=rs.getString("合計");
                    System.out.println(name);
                    System.out.println(code);*/
                    System.out.println(a);
                    System.out.println(b);
                    /*System.out.println(c);
                    System.out.println(d);
                    System.out.println(e);*/

                }
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace(); // 本番環境では適切なエラーハンドリングが必要
        }


    }

}

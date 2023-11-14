package com.example.mobileorder.Item;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Product {
    private SimpleStringProperty name;
    private SimpleIntegerProperty price;
    private SimpleStringProperty code;
    private SimpleStringProperty kubuncode;
    private SimpleStringProperty kubun;

    // コンストラクタ
    public Product(String name, int price, String code, String kubuncode, String kubun) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.code = new SimpleStringProperty(code);
        this.kubuncode = new SimpleStringProperty(kubuncode);
        this.kubun = new SimpleStringProperty(kubun);
    }

    // ゲッターとセッター
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public SimpleIntegerProperty priceProperty() {
        return price;
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    public String getKubuncode() {
        return kubuncode.get();
    }

    public void setKubuncode(String  kubuncode) {
        this.kubuncode.set(kubuncode);
    }

    public SimpleStringProperty kubuncodeProperty() {
        return kubuncode;
    }

    public String getKubun() {
        return kubun.get();
    }

    public void setKubun(String kubun) {
        this.kubun.set(kubun);
    }

    public SimpleStringProperty kubunProperty() {
        return kubun;
    }
}




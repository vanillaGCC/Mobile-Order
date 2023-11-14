package com.example.mobileorder.Item;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import com.example.mobileorder.controller.*;
import com.example.mobileorder.*;

public class Item {
    private SimpleStringProperty name;
    private SimpleIntegerProperty price;
    private SimpleIntegerProperty quantity;
    private SimpleStringProperty code;
    private SimpleIntegerProperty kubun;
    private SimpleIntegerProperty temporaryQuantity;


    public Item(String name, int price, String code,int kubun) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.quantity = new SimpleIntegerProperty(1);
        this.code = new SimpleStringProperty(code);
        this.kubun = new SimpleIntegerProperty(kubun);
        this.temporaryQuantity=new SimpleIntegerProperty(1);
    }

    // nameのgetterとsetter
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("nameにnullを指定することはできません");
        }
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    // priceのgetterとsetter
    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        if (price < 0 ) {
            throw new IllegalArgumentException("0以下は指定できません");
        }
        this.price.set(price);
    }

    public SimpleIntegerProperty priceProperty() {
        return price;
    }

    // quantityのgetterとsetter
    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("codeにnullを指定することはできません");
        }
        this.code.set(code);
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    public int getKubun() {
        return kubun.get();
    }

    public void setKubun(int kubun) {
        if (kubun < 0 ) {
            throw new IllegalArgumentException("0以下は指定できません");
        }
        this.kubun.set(kubun);
    }

    public SimpleIntegerProperty kubunProperty() {
        return kubun;
    }

    public int getTemporaryQuantity() {
        return temporaryQuantity.get();
    }

    public void setTemporaryQuantity(int temporaryQuantity) {
        this.temporaryQuantity.set(temporaryQuantity);
    }

    public SimpleIntegerProperty temporaryQuantityProperty() {
        return temporaryQuantity;
    }
}

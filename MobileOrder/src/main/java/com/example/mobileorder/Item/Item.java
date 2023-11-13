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

    public Item(String name, int price, String code) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.quantity = new SimpleIntegerProperty(1);
        this.code = new SimpleStringProperty(code);
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
}

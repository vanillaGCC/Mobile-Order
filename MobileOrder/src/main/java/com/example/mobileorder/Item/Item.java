package com.example.mobileorder.Item;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private final SimpleStringProperty name;

    private final SimpleStringProperty menuCode;
    private final SimpleDoubleProperty price;

    private final SimpleStringProperty kubunCode;
    //private final SimpleIntegerProperty quantity;

    public Item(String name, String menuCode, double price, String kubunCode) {
        this.name = new SimpleStringProperty(name);
        this.menuCode = new SimpleStringProperty(menuCode);
        this.price = new SimpleDoubleProperty(price);
        this.kubunCode = new SimpleStringProperty(kubunCode);
        //this.quantity = new SimpleIntegerProperty(quantity);
    }

    // nameのgetterとsetter
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    // menuCodeのgetterとsetter
    public String getMenuCode() {
        return menuCode.get();
    }

    public void setMenuCode(String menuCode) {
        this.menuCode.set(menuCode);
    }

    public SimpleStringProperty menuCodeProperty() {
        return menuCode;
    }

    // priceのgetterとsetter
    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    // kubunCodeのgetterとsetter
    public String getKubunCode() {
        return kubunCode.get();
    }

    public void setKubunCode(String kubunCode) {
        this.kubunCode.set(kubunCode);
    }

    public SimpleStringProperty kubunCodeProperty() {
        return kubunCode;
    }

    /*
    // quantityのgetterとsetter
    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }*/
}

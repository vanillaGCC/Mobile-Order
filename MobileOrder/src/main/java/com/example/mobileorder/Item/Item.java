package com.example.mobileorder.Item;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private final SimpleStringProperty name;
    private final SimpleStringProperty namecode;
    private final SimpleDoubleProperty price;
    private final SimpleIntegerProperty kubun;

    public Item(String name, double price, int kubun,String namecode) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.kubun = new SimpleIntegerProperty(kubun);
        this.namecode = new SimpleStringProperty(namecode);
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

    public String getNameCode() {
        return namecode.get();
    }

    public void setNameCode(String namecode) {
        this.namecode.set(namecode);
    }

    public SimpleStringProperty nameCodeProperty() {
        return namecode;
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

    // quantityのgetterとsetter
    public int getkubun() {
        return kubun.get();
    }

    public void setkubun(int quantity) {
        this.kubun.set(quantity);
    }

    public SimpleIntegerProperty kubunProperty() {
        return kubun;
    }
}

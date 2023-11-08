package com.example.mobileorder.Item;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Item {
    private final SimpleStringProperty name;
<<<<<<< HEAD

    private final SimpleStringProperty menuCode;
    private final SimpleDoubleProperty price;

    private final SimpleStringProperty kubunCode;
    //private final SimpleIntegerProperty quantity;

    public Item(String name, String menuCode, double price, String kubunCode) {
=======
    private final SimpleStringProperty namecode;
    private final SimpleDoubleProperty price;
    private final SimpleIntegerProperty kubun;

    public Item(String name, double price, int kubun,String namecode) {
>>>>>>> 128d11049b25a2185a835d6a981e069ebcd88013
        this.name = new SimpleStringProperty(name);
        this.menuCode = new SimpleStringProperty(menuCode);
        this.price = new SimpleDoubleProperty(price);
<<<<<<< HEAD
        this.kubunCode = new SimpleStringProperty(kubunCode);
        //this.quantity = new SimpleIntegerProperty(quantity);
=======
        this.kubun = new SimpleIntegerProperty(kubun);
        this.namecode = new SimpleStringProperty(namecode);
>>>>>>> 128d11049b25a2185a835d6a981e069ebcd88013
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

<<<<<<< HEAD
    // menuCodeのgetterとsetter
    public String getMenuCode() {
        return menuCode.get();
    }

    public void setMenuCode(String menuCode) {
        this.menuCode.set(menuCode);
    }

    public SimpleStringProperty menuCodeProperty() {
        return menuCode;
=======
    public String getNameCode() {
        return namecode.get();
    }

    public void setNameCode(String namecode) {
        this.namecode.set(namecode);
    }

    public SimpleStringProperty nameCodeProperty() {
        return namecode;
>>>>>>> 128d11049b25a2185a835d6a981e069ebcd88013
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
    public int getkubun() {
        return kubun.get();
    }

    public void setkubun(int quantity) {
        this.kubun.set(quantity);
    }

<<<<<<< HEAD
    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }*/
=======
    public SimpleIntegerProperty kubunProperty() {
        return kubun;
    }
>>>>>>> 128d11049b25a2185a835d6a981e069ebcd88013
}

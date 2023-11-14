package com.example.mobileorder.Item;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Order {

    private SimpleStringProperty name;
    private SimpleIntegerProperty price;
    private SimpleIntegerProperty quantity;
    private SimpleStringProperty code;
    private SimpleIntegerProperty kubun;
    private SimpleIntegerProperty oneprice;
    private SimpleStringProperty orderId;
    private SimpleStringProperty date;
    private SimpleIntegerProperty totalprice;

    public Order(String name, int price, int quantity, String code, int kubun, int oneprice, String orderId, String date, int totalprice) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.code = new SimpleStringProperty(code);
        this.kubun = new SimpleIntegerProperty(kubun);
        this.oneprice = new SimpleIntegerProperty(oneprice);
        this.orderId = new SimpleStringProperty(orderId);
        this.date = new SimpleStringProperty(date);
        this.totalprice = new SimpleIntegerProperty(totalprice);

    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    // priceのゲッター、セッター、プロパティメソッド
    public int getPrice() {
        return price.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public SimpleIntegerProperty priceProperty() {
        return price;
    }

    // quantityのゲッター、セッター、プロパティメソッド
    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    // codeのゲッター、セッター、プロパティメソッド
    public String getCode() {
        return code.get();
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public SimpleStringProperty codeProperty() {
        return code;
    }

    // kubunのゲッター、セッター、プロパティメソッド
    public int getKubun() {
        return kubun.get();
    }

    public void setKubun(int kubun) {
        this.kubun.set(kubun);
    }

    public SimpleIntegerProperty kubunProperty() {
        return kubun;
    }

    // onepriceのゲッター、セッター、プロパティメソッド
    public int getOneprice() {
        return oneprice.get();
    }

    public void setOneprice(int oneprice) {
        this.oneprice.set(oneprice);
    }

    public SimpleIntegerProperty onepriceProperty() {
        return oneprice;
    }

    // kinngakuのゲッター、セッター、プロパティメソッド
    public String getOrderId() {
        return orderId.get();
    }

    public void setOrderId(String orderId) {
        this.orderId.set(orderId);
    }

    public SimpleStringProperty orderIdProperty() {
        return orderId;
    }

    // dateのゲッター、セッター、プロパティメソッド
    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    // totalpriceのゲッター、セッター、プロパティメソッド
    public int getTotalprice() {
        return totalprice.get();
    }

    public void setTotalprice(int totalprice) {
        this.totalprice.set(totalprice);
    }

    public SimpleIntegerProperty totalpriceProperty() {
        return totalprice;
    }
}

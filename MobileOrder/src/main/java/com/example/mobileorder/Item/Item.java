package com.example.mobileorder.Item;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Item {
    private final SimpleIntegerProperty code;
    private final SimpleStringProperty name;
    private final SimpleDoubleProperty price;
    private SimpleIntegerProperty quantity;

    public Item(int code, String name, double price, int quantity) {
        this.code = new SimpleIntegerProperty(code);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public int getCode() { return code.get(); }
    public void setCode(int fCode) { code.set(fCode); }
    public String getName() { return name.get(); }
    public void setName(String fName) { name.set(fName); }
    public double getPrice() { return price.get(); }
    public void setPrice(double fPrice) { price.set(fPrice); }
    public int getQuantity() { return quantity.get(); }
    public void setQuantity(int fQuantity) { quantity.set(fQuantity); }

}

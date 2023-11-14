package com.example.mobileorder.controller;
import com.example.mobileorder.Item.*;
import com.example.mobileorder.connectionToDB;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.util.Callback;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.*;
import javafx.beans.value.ObservableValue;

public class maincontroller {
    @FXML
    private TableView<Item> tableView;

    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, Integer> priceColumn;
    @FXML
    private TableColumn<Item, Integer> quantityColumn;
    @FXML
    private TableColumn<Item, String> addToCartColumn;

    private final ObservableList<Item> itemList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        setupTableColumns();
        loadItems();
    }

    private void setupTableColumns() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // 価格列の設定
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // 数量選択列の設定
        quantityColumn.setCellFactory(col -> new TableCell<>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    ChoiceBox<Integer> choiceBox = new ChoiceBox<>(
                            FXCollections.observableArrayList(1, 2, 3, 4, 5)
                    );
                    choiceBox.setValue(getItem());
                    choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                        if (newVal != null) {
                            Item currentItem = getTableView().getItems().get(getIndex());
                            currentItem.setQuantity(newVal);
                        }
                    });
                    setGraphic(choiceBox);
                }
            }
        });

        // カートに追加列の設定
        addToCartColumn.setCellFactory(col -> new TableCell<>() {
            private final Button addButton = new Button("カートに追加");

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    addButton.setOnAction(event -> {
                        Item currentItem = getTableView().getItems().get(getIndex());
                        addToCart(currentItem);
                    });
                    setGraphic(addButton);
                }
            }
        });
    }

    private void loadItems() {
        // データベースから商品データを読み込んでitemListに追加
        // 以下はデモデータの例
        itemList.add(new Item("バーガー", 250, "B001"));
        itemList.add(new Item("フライドポテト", 150, "F001"));
        // ...

        tableView.setItems(itemList);
    }

    // カートに追加するボタンのアクションを扱うメソッド
    // 例えば、商品をカートに追加する処理など
    @FXML
    private void addToCart(Item item) {
        // カートに商品を追加する処理

    }
}


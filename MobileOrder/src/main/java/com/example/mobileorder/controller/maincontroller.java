package com.example.mobileorder.controller;


import com.example.mobileorder.Item.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
public class MainController {

    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, Double> priceColumn;
    @FXML
    private TableColumn<Item, Integer> quantityColumn;
    @FXML
    private TableColumn<Item, Void> addToCartColumn;

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(/* ... */);
        priceColumn.setCellValueFactory(/* ... */);
        quantityColumn.setCellValueFactory(/* ... */);

        // 数量のChoiceBoxを設定
        quantityColumn.setCellFactory(col -> new TableCell<>() {
            private final ChoiceBox<Integer> choiceBox = new ChoiceBox<>();

            {
                // 必要な数量の選択肢を設定
                choiceBox.getItems().addAll(1, 2, 3, 4, 5);
                choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                    // 数量が変更されたときの処理
                    if (newVal != null) {
                        System.out.println("Selected quantity: " + newVal);
                        // 必要に応じてモデルを更新
                        Item item = getTableView().getItems().get(getIndex());
                        item.setQuantity(newVal);
                    }
                });
            }

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    choiceBox.getSelectionModel().select(item);
                    setGraphic(choiceBox);
                }
            }
        });

        // カートに追加ボタンを設定
        addToCartColumn.setCellFactory(col -> new TableCell<>() {
            private final Button addButton = new Button("カートに追加");

            {
                addButton.setOnAction(event -> {
                    Item item = getTableView().getItems().get(getIndex());
                    // カートに追加する処理
                    System.out.println("Added to cart: " + item.getName());
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : addButton);
            }
        });

        private void loadItems() {
            List<Item> itemList = DatabaseUtil.getItemsFromDatabase();
            ObservableList<Item> items = FXCollections.observableArrayList(itemList);
            tableView.setItems(items);
        }
    }
}

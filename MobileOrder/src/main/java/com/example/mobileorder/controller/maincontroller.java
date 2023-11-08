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

public class maincontroller {
    // ...

    // Quantity Columnのセットアップ
    @FXML
    private TableView<Item> tableView;

    // 以下、FXMLファイルで定義したTableViewの列をアノテーションでマッピング
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, Double> priceColumn;
    @FXML
    private TableColumn<Item, Integer> quantityColumn;
    @FXML
    private TableColumn<Item, Void> addToCartColumn;
    private void setupQuantityColumn() {
        quantityColumn.setCellFactory(new Callback<TableColumn<Item, Integer>, TableCell<Item, Integer>>() {
            @Override
            public TableCell<Item, Integer> call(TableColumn<Item, Integer> param) {
                return new TableCell<Item, Integer>() {
                    @Override
                    protected void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
                            choiceBox.getItems().addAll(1, 2, 3, 4, 5); // 例として5までの数量を設定
                            // 現在のアイテムの数量を選択
                            choiceBox.setValue(getItem());
                            // 選択が変更された時のイベントハンドラ
                            choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                                // ここで選択された数量を処理します
                                Item Item = getTableView().getItems().get(getIndex());
                                Item.setQuantity(newVal);
                            });
                            setGraphic(choiceBox);
                        }
                    }
                };
            }
        });
    }

    // Add To Cart Columnのセットアップ
    private void setupAddToCartColumn() {
        addToCartColumn.setCellFactory(new Callback<TableColumn<Item, Void>, TableCell<Item, Void>>() {
            @Override
            public TableCell<Item, Void> call(TableColumn<Item, Void> param) {
                return new TableCell<Item, Void>() {
                    private final Button addButton = new Button("カートに追加");

                    {
                        addButton.setOnAction(event -> {
                            Item item = getTableView().getItems().get(getIndex());
                            // ここでカートにアイテムを追加するロジックを実装します
                            // addToCart(item);
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(addButton);
                        }
                    }
                };
            }
        });
    }

    private void loadItems() {
        // データベースからアイテムリストを取得
        List<Item> itemList = connectionToDB.getItemsFromDatabase();

        // アイテムリストをObservableListに変換
        ObservableList<Item> observableItemList = FXCollections.observableArrayList(itemList);

        // TableViewにアイテムリストをセット
        tableView.setItems(observableItemList);
    }


    // initializeメソッドでこれらを呼び出します
    @FXML
    public void initialize() {
        // ...
        setupQuantityColumn();
        setupAddToCartColumn();
        loadItems();
    }

    // loadItemsと他の必要なメソッドを含む
}


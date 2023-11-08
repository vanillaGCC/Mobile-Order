package com.example.mobileorder.controller;

import com.example.mobileorder.Item.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class maincontroller {

    @FXML
    private TableView<Item> tableView;
    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, Number> priceColumn;
    @FXML
    private TableColumn<Item, Integer> quantityColumn;
    @FXML
    private TableColumn<Item, String> addToCartColumn;

    // 初期化メソッド
    public void initialize() {
        // 商品名と価格に関するプロパティをセットアップ
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // 数量選択のComboBoxをセットアップ
        setupQuantityColumn();

        // カートに追加ボタンの設定をここに記述
        setupAddToCartColumn();

        // 商品データの読み込み（ダミーまたはDBからの読み込み）
        loadProducts();
    }

    private void setupQuantityColumn() {
        // 数量の選択肢を1から5までのリストとして生成
        ObservableList<Integer> quantityOptions = FXCollections.observableArrayList(1, 2, 3, 4, 5);

        // 数量の列をComboBoxとして設定
        quantityColumn.setCellFactory(column -> new ComboBoxTableCell<>(new IntegerStringConverter(), quantityOptions));
    }

    private void setupAddToCartColumn() {
        // カートに追加ボタンの列を設定（実装は省略）
    }

    private void loadProducts() {
        // 商品データをロード（ダミーまたはDBからの読み込みを想定）
    }

    // その他のメソッド...

}

class ComboBoxTableCell<S, T> extends TableCell<S, T> {
    private final ComboBox<T> comboBox;

    public ComboBoxTableCell(StringConverter<T> converter, ObservableList<T> items) {
        comboBox = new ComboBox<>(items);
        comboBox.setConverter(converter);
        comboBox.setEditable(true);

        comboBox.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (isEditing()) {
                commitEdit(newValue);
            }
        });
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            comboBox.setValue(item);
            setGraphic(comboBox);
        }
    }

    @Override
    public void startEdit() {
        super.startEdit();
        comboBox.getSelectionModel().select(getItem());
        setGraphic(comboBox);
        comboBox.requestFocus();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setGraphic(null);
    }

    @Override
    public void commitEdit(T newValue) {
        super.commitEdit(newValue);
        setGraphic(null);
    }
}

package com.example.mobileorder.controller;

import com.example.mobileorder.Item.*;
import com.example.mobileorder.MobileOrder;
import com.example.mobileorder.connectionToDB;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class maincontroller {
    @FXML
    public TableView<Order> tableviews;
    @FXML
    public TableColumn <Order,String>orderId1;
    @FXML
    public TableColumn<Order,String> code1;
    @FXML
    public TableColumn<Order,String> name1;
    @FXML
    public TableColumn<Order,Integer> kubun1;
    @FXML
    public TableColumn<Order,Integer> oneprice1;
    @FXML
    public TableColumn<Order,Integer> price1;
    @FXML
    public TableColumn<Order,Integer> quantity1;
    @FXML
    public TableColumn<Order,String> date;
    @FXML
    public TableColumn<Order,Integer> totalprice1;
    @FXML
    public TextField textfieldorder;
    @FXML
    public Button search;
    @FXML
    public Button refresh;
    @FXML
    public TableColumn<Product,String> code2;
    @FXML
    public TableColumn<Product,String > name2;
    @FXML
    public TableColumn<Product,String> kubun2;
    @FXML
    public TableColumn<Product,Integer> kubuncode2;
    @FXML
    public TableColumn<Product,Integer> price2;
    @FXML
    public TextField codeField;
    @FXML
    public Button searchc;
    @FXML
    public TextField nameField;
    @FXML
    public Button searchn;
    @FXML
    public TextField kubunField;
    @FXML
    public Button searchk;
    @FXML
    public Button update;
    @FXML
    public TableView<Product> tableviewp;
    @FXML
    public ChoiceBox<String> kubunbox;
    @FXML
    public TextField newproductname;
    @FXML
    public TextField newcode;
    @FXML
    public TextField newprice;
    @FXML
    public Label alartlabel;
    @FXML
    public Button addbutoon;
    @FXML
    public Button editProduct;

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
    @FXML
    private TableView<Item> tableView1;

    @FXML
    private TableColumn<Item, String> nameColumn1;
    @FXML
    private TableColumn<Item, Integer> priceColumn1;
    @FXML
    private TableColumn<Item, Integer> quantityColumn1;
    @FXML
    private TableColumn<Item, String> addToCartColumn1;

    @FXML
    private TableView<Item> tableView2;

    @FXML
    private TableColumn<Item, String> nameColumn2;
    @FXML
    private TableColumn<Item, Integer> priceColumn2;
    @FXML
    private TableColumn<Item, Integer> quantityColumn2;
    @FXML
    private TableColumn<Item, String> addToCartColumn2;

    @FXML
    private TableView<Item> tableView21;

    @FXML
    private TableColumn<Item, String> nameColumn21;
    @FXML
    private TableColumn<Item, Integer> priceColumn21;
    @FXML
    private TableColumn<Item, Integer> quantityColumn21;
    @FXML
    private TableColumn<Item, String> deleteFromCartColumn;

    @FXML
    private Label goukei;

    @FXML
    TextField cardNumber;

    @FXML
    TextField month;
    @FXML
    TextField year;
    @FXML
    TextField username;
    @FXML
    private Label alart;

    @FXML
    Button confirm;

    private final ObservableList<Item> itemList = FXCollections.observableArrayList();
    private final ObservableList<Item> burgerItems = FXCollections.observableArrayList();
    private final ObservableList<Item> drinkItems = FXCollections.observableArrayList();
    private final ObservableList<Item> sideItems = FXCollections.observableArrayList();
    private final ObservableList<Item> cartItems = FXCollections.observableArrayList();

    private final ObservableList<Order> orderItems= FXCollections.observableArrayList();
    int total;


    @FXML
    private void initialize() {
        setupTableColumns();
        loadItems();
        onUpdate();
        onUpdateProduct();
        setUpkubunbox();
    }

    private void setupTableColumns() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // 価格列の設定
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        nameColumn1.setCellValueFactory(new PropertyValueFactory<>("name"));

        // 価格列の設定
        priceColumn1.setCellValueFactory(new PropertyValueFactory<>("price"));

        nameColumn2.setCellValueFactory(new PropertyValueFactory<>("name"));

        // 価格列の設定
        priceColumn2.setCellValueFactory(new PropertyValueFactory<>("price"));

        nameColumn21.setCellValueFactory(new PropertyValueFactory<>("name"));

        // 価格列の設定
        priceColumn21.setCellValueFactory(new PropertyValueFactory<>("price"));

        quantityColumn21.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        orderId1.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        code1.setCellValueFactory(new PropertyValueFactory<>("code"));
        name1.setCellValueFactory(new PropertyValueFactory<>("name"));
        kubun1.setCellValueFactory(new PropertyValueFactory<>("kubun"));
        oneprice1.setCellValueFactory(new PropertyValueFactory<>("oneprice"));
        price1.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantity1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        totalprice1.setCellValueFactory(new PropertyValueFactory<>("totalprice"));

        name2.setCellValueFactory(new PropertyValueFactory<>("name"));
        code2.setCellValueFactory(new PropertyValueFactory<>("code"));
        kubun2.setCellValueFactory(new PropertyValueFactory<>("kubun"));
        kubuncode2.setCellValueFactory(new PropertyValueFactory<>("kubuncode"));
        price2.setCellValueFactory(new PropertyValueFactory<>("price"));




        // 数量選択列の設定
        quantityColumn.setCellFactory(col -> new TableCell<Item, Integer>() {
            private final ChoiceBox<Integer> choiceBox = new ChoiceBox<>(
                    FXCollections.observableArrayList(1, 2, 3, 4, 5));

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Item currentItem = getTableView().getItems().get(getIndex());
                    choiceBox.setValue(currentItem.getQuantity());
                    choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                        if (newVal != null) {
                            currentItem.setTemporaryQuantity(newVal);
                        }
                    });
                    setGraphic(choiceBox);
                }
            }
        });

        // 数量選択列の設定
        quantityColumn1.setCellFactory(col -> new TableCell<Item, Integer>() {
            private final ChoiceBox<Integer> choiceBox = new ChoiceBox<>(
                    FXCollections.observableArrayList(1, 2, 3, 4, 5));

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Item currentItem = getTableView().getItems().get(getIndex());
                    choiceBox.setValue(currentItem.getQuantity());
                    choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                        if (newVal != null) {
                            currentItem.setTemporaryQuantity(newVal);
                        }
                    });
                    setGraphic(choiceBox);
                }
            }
        });

        quantityColumn2.setCellFactory(col -> new TableCell<Item, Integer>() {
            private final ChoiceBox<Integer> choiceBox = new ChoiceBox<>(
                    FXCollections.observableArrayList(1, 2, 3, 4, 5));

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Item currentItem = getTableView().getItems().get(getIndex());
                    choiceBox.setValue(currentItem.getQuantity());
                    choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                        if (newVal != null) {
                            currentItem.setTemporaryQuantity(newVal);
                        }
                    });
                    setGraphic(choiceBox);
                }
            }
        });

        /*quantityColumn21.setCellFactory(col -> new TableCell<Item, Integer>() {
            private final ChoiceBox<Integer> choiceBox = new ChoiceBox<>(
                    FXCollections.observableArrayList(1, 2, 3, 4, 5));

            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    Item currentItem = getTableView().getItems().get(getIndex());
                    choiceBox.setValue(currentItem.getQuantity());
                    choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                        if (newVal != null) {
                            currentItem.setQuantity(newVal);
                        }
                    });
                    setGraphic(choiceBox);
                }
            }
        });*/

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

        // カートに追加列の設定
        addToCartColumn1.setCellFactory(col -> new TableCell<>() {
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

        // カートに追加列の設定
        addToCartColumn2.setCellFactory(col -> new TableCell<>() {
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

        // カートに追加列の設定
        deleteFromCartColumn.setCellFactory(col -> new TableCell<>() {
            private final Button addButton = new Button("カートから削除");

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    addButton.setOnAction(event -> {
                        Item currentItem = getTableView().getItems().get(getIndex());
                        deleteFromCart(currentItem);
                    });
                    setGraphic(addButton);
                }
            }
        });

    }

    private void setUpkubunbox(){
        kubunbox.setItems(FXCollections.observableArrayList("0", "1", "2"));
        kubunbox.setValue("0"); // デフォルト値を設定
    }

    private void loadItems() {
        // データベースから商品データを読み込んでitemListに追加
        // 以下はデモデータの例
        //itemList.add(new Item("バーガー", 250, "B001", 1));
        //itemList.add(new Item("フライドポテト", 150, "F001", 3));
        // ...


        ObservableList<Item> items = connectionToDB.getItemsFromDatabase();

        for (Item item : items) {
            if (item.getKubun() == 0) {
                burgerItems.add(item);
            } else if (item.getKubun() == 1) {
                drinkItems.add(item);
            } else if (item.getKubun() == 2) {
                sideItems.add(item);
            }
            // 追加の条件が必要な場合はここに記述
        }
        tableView.setItems(burgerItems); // バーガーのテーブルビュー
        tableView2.setItems(drinkItems); // ドリンクのテーブルビュー
        tableView1.setItems(sideItems); // サイドのテーブルビュー
    }

    // カートに追加するボタンのアクションを扱うメソッド
    // 例えば、商品をカートに追加する処理など
    @FXML
    private void addToCart(Item newItem) {
        boolean itemExists = false;

        for (Item itemInCart : cartItems) {
            if (itemInCart.getCode().equals(newItem.getCode())) {
                // カートに商品が既に存在する場合、一時的に保持していた数量を更新
                itemInCart.setQuantity(itemInCart.getQuantity() + newItem.getTemporaryQuantity());
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            // カートに商品が存在しない場合、新しいアイテムを追加
            newItem.setQuantity(newItem.getTemporaryQuantity());
            cartItems.add(newItem);
        }

        total = updateTotalAmount();
        tableView21.setItems(cartItems);
    }


    @FXML
    private void deleteFromCart(Item item) {
        cartItems.remove(item);
        updateTotalAmount();
    }

    private int updateTotalAmount() {
        int total = 0;
        for (Item item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }

        // 合計金額を表示するUIコンポーネントに値をセット
        goukei.setText(Integer.toString(total));

        return total;
    }

    @FXML
    private void confirmOrder() {
        alart.setText("");
        if (cartItems.isEmpty()) {
            alart.setText("カートが空です");
            return;
        }
        if (cardNumber.getText().trim().isEmpty() ||
                month.getText().trim().isEmpty() ||
                year.getText().trim().isEmpty() ||
                username.getText().trim().isEmpty()) {
            // 一つでも空白がある場合は処理を中断
            alart.setText("カード情報が空白です");
            return; // 処理を中断
        }
        String orderId = generateOrderId(); // 注文番号を生成するメソッド

        String cardNumber = this.cardNumber.getText();
        String cardHolderName = this.username.getText();
        String expirationDate = this.month.getText().trim() + "/" + this.year.getText().trim();
        LocalDateTime purchaseDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = purchaseDateTime.format(formatter);

        connectionToDB.inserCardIntoDatabase(orderId,cardNumber,cardHolderName,expirationDate,formattedDateTime);

        int totalPrice = total;

        for (Item item : cartItems) {
            int price = item.getPrice() * item.getQuantity();
            int tax = (int) (price * 0.08); // 消費税を計算
            int taxExcludedPrice = price - tax;
            int kubu = item.getKubun();
            String kubun=Integer.toString(kubu);
            String name = item.getName();
            int tanka= item.getPrice();

            // データベースに挿入する処理
            connectionToDB.insertOrderIntoDatabase(item.getCode(), orderId, item.getQuantity(), price, taxExcludedPrice, tax, totalPrice);
            connectionToDB.insertOrderIntoDatabase2(item.getCode(), orderId, item.getQuantity(), price, taxExcludedPrice, tax, totalPrice,name,kubun,tanka,formattedDateTime);
        }

        cartItems.clear(); // カートを空にする
        updateTotalAmount(); // 合計金額を更新

    }

    private String generateOrderId() {
        String str = connectionToDB.getNextOrderId();
        int code = Integer.parseInt(str);
        return String.format("%08d",code);
    }

    @FXML
    private void onUpdate() {
        // データベースから全ての注文情報を取得
        ObservableList<Order> orders = connectionToDB.getAllOrders();

        // TableViewにデータを設定
        tableviews.setItems(orders);
    }

    @FXML
    private void onSearch() {
        // TextFieldから注文番号を取得
        String orderId = textfieldorder.getText();

        // 指定された注文番号に基づいてデータベースから注文情報を取得
        ObservableList<Order> orders = connectionToDB.getOrdersByOrderId(orderId);

        // TableViewにデータを設定
        tableviews.setItems(orders);
    }
    
    @FXML
    private void onUpdateProduct(){
        ObservableList<Product> products = connectionToDB.getAllProducts();

        // TableViewにデータを設定
        tableviewp.setItems(products);
    }

    @FXML
    private void onSearchPCode() {
        // TextFieldから注文番号を取得
        String code = codeField.getText();

        // 指定された注文番号に基づいてデータベースから注文情報を取得
        ObservableList<Product> products = connectionToDB.getOrdersByCode(code);

        // TableViewにデータを設定
        tableviewp.setItems(products);
    }

    @FXML
    private void onSearchName() {
        // TextFieldから注文番号を取得
        String name = nameField.getText();

        // 指定された注文番号に基づいてデータベースから注文情報を取得
        ObservableList<Product> products = connectionToDB.getOrdersByName(name);

        // TableViewにデータを設定
        tableviewp.setItems(products);
    }

    @FXML
    private void onSearchKubun() {
        // TextFieldから注文番号を取得
        String kubun = kubunField.getText();
        // 指定された注文番号に基づいてデータベースから注文情報を取得
        ObservableList<Product> products = connectionToDB.getOrdersByKubun(kubun);

        // TableViewにデータを設定
        tableviewp.setItems(products);
    }

    @FXML
    public void addNewProduct() {
        ObservableList<Item> items = connectionToDB.getItemsFromDatabase();
        String newName=newproductname.getText();
        StringBuilder newCode= new StringBuilder(newcode.getText());
        int price = Integer.parseInt(newprice.getText());
        alartlabel.setText("");
        String code="";
        int kubuncode =Integer.parseInt(kubunbox.getValue());
        if (!isSixDigitInteger(newCode.toString())){
            alartlabel.setText("商品を追加できません");
            return;
        }
        for (Item item : items) {
            if ( kubuncode == 0) {
                if(item.getName().equals(newName)){
                    alartlabel.setText("商品を追加できません");
                    return;
                }
                if(item.getCode().equals("BU"+newCode)){
                    alartlabel.setText("商品を追加できません");
                    return;
                }else{
                    code="BU"+ newCode;
                }
            } else if (kubuncode == 1) {
                if(item.getName().equals(newName)){
                    alartlabel.setText("商品を追加できません");
                    return;
                }
                if(item.getCode().equals("DR"+newCode)){
                    alartlabel.setText("商品を追加できません");
                    return;
                }else{
                    code="DR"+ newCode;
                }
            } else if (kubuncode == 2) {
                if(item.getName().equals(newName)){
                    alartlabel.setText("商品を追加できません");
                    return;
                }
                if(item.getCode().equals("SI"+newCode)){
                    alartlabel.setText("商品を追加できません");
                    return;
                }else{
                    code="SI"+ newCode;
                }
            }
            // 追加の条件が必要な場合はここに記述
        }

        int i = connectionToDB.insertNewProductIntoDatabase(code, newName, price, Integer.toString(kubuncode));
        if(i==1){
            alartlabel.setText("追加に成功しました");
        }else{
            alartlabel.setText("追加に失敗しました");
        }

    }

    private static boolean isSixDigitInteger(String str) {
        if (str == null || str.length() != 6) {
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


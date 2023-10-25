module com.example.mobileorder {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // java.sqlモジュールへの依存関係を追加


    requires org.controlsfx.controls;
                    requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
                requires com.almasb.fxgl.all;
    
    opens com.example.mobileorder to javafx.fxml;
    exports com.example.mobileorder;
}
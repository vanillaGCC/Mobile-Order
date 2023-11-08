module com.example.mobileorder {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                    requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
                requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.mobileorder to javafx.fxml;
    exports com.example.mobileorder;
    exports com.example.mobileorder.controller;
    opens com.example.mobileorder.controller to javafx.fxml;
}
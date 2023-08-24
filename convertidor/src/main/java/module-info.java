module com.convertidor {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.convertidor to javafx.fxml;
    exports com.convertidor;
    exports controller;
    opens controller to javafx.fxml;
    exports model;
    opens model to javafx.fxml;
}
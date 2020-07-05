module com.bertanzon {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.bertanzon to javafx.fxml;
    exports com.bertanzon;
}
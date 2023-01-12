module com.example.tableview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tableview to javafx.fxml;
    exports com.example.tableview;
    exports com.example.tableview.GUI;
    opens com.example.tableview.GUI to javafx.fxml;
}
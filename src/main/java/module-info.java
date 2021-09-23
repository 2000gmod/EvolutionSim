module com.example.evolutionsim {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.evosim.ui to javafx.fxml;
    exports com.evosim.ui;
}
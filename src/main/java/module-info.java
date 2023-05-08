module com.example.javafxuserinformation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxuserinformation to javafx.fxml;
    exports com.example.javafxuserinformation;
}
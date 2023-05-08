package com.example.javafxuserinformation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InfoController {
    @FXML
    private ComboBox<String> jobCompany;
    @FXML
    private TextField name;
    @FXML
    private TextField score;
    @FXML
    private TableView columnInfo;

    @FXML
    private void initialize() {
        ObservableList<String> items
                = FXCollections.observableArrayList("株式会社A","株式会社B","株式会社C");
        jobCompany.setItems(items);
    }

    @FXML
    public void onAdd(ActionEvent actionEvent) {
        var jobCompanyValue = jobCompany.getValue();
        var nameValue = name.getText();
        var scoreValue = score.getText();
        var information = setColumnInfo(jobCompanyValue, nameValue, scoreValue);
        columnInfo.setItems(information);
    }

    public static ObservableList setColumnInfo(String jobCompany, String name, String score) {
        ObservableList items
                = FXCollections.observableArrayList(jobCompany, name, score);
        return items;
    }
}

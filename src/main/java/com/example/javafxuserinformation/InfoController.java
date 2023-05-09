package com.example.javafxuserinformation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class InfoController {
    @FXML private ComboBox<String> jobComboBox;
    @FXML private TextField nameTextField;
    @FXML private TextField scoreTextField;
    @FXML private TableView<User> tableView;
    @FXML private TableColumn<User, Integer> idColumn;
    @FXML private TableColumn<User, String> nameColumn;
    @FXML private TableColumn<User, String> jobColumn;
    @FXML private TableColumn<User, Integer> scoreColumn;

    private int idCounter = 1;

    @FXML
    private void initialize() {
        ObservableList<String> items
                = FXCollections.observableArrayList("株式会社A","株式会社B","株式会社C");
        jobComboBox.setItems(items);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("job"));
        jobColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
    }

    @FXML
    public void onAdd(ActionEvent actionEvent) {
        String job = jobComboBox.getValue();
        String name = nameTextField.getText();
        int score = Integer.parseInt(scoreTextField.getText());
        User user = new User(job, name, score);
        user.setId(idCounter);
        idCounter++;
        tableView.getItems().add(user);
    }

}

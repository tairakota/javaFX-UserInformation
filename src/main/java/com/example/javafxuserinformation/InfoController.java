package com.example.javafxuserinformation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.stream.Collectors;

public class InfoController {
    @FXML private ComboBox<String> jobComboBox;
    @FXML private TextField nameTextField;
    @FXML private TextField scoreTextField;
    @FXML private ComboBox<String> jobComboBoxEdit;
    @FXML private TextField nameTextFieldEdit;
    @FXML private TextField scoreTextFieldEdit;
    @FXML private TableView<User> tableView;
    @FXML private TableColumn<User, Integer> idColumn;
    @FXML private TableColumn<User, String> nameColumn;
    @FXML private TableColumn<User, String> jobColumn;
    @FXML private TableColumn<User, Integer> scoreColumn;

    ObservableList<String> items
            = FXCollections.observableArrayList("株式会社A","株式会社B","株式会社C");
    @FXML
    private void initialize() {
        jobComboBox.setItems(items);
        jobComboBoxEdit.setItems(items);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        jobColumn.setCellValueFactory(new PropertyValueFactory<>("job"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        User dafaultuser = new User("株式会社A", "aaa", 10);
        dafaultuser.setId(1);
        tableView.getItems().add(dafaultuser);
    }

    @FXML
    public void onAdd(ActionEvent actionEvent) {
        int maxId = tableView.getItems().stream()
                .mapToInt(User::getId)
                .max()
                .orElse(0);
        String job = jobComboBox.getValue();
        String name = nameTextField.getText();
        int score = Integer.parseInt(scoreTextField.getText());
        User user = new User(job, name, score);
        user.setId(maxId + 1);
        tableView.getItems().add(user);
    }
    @FXML
    private void onDelete(ActionEvent actionEvent) {
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableView.getItems().remove(selectedIndex);
        }
    }
    @FXML
    private void onEdit(ActionEvent actionEvent) {
        User edituser = tableView.getSelectionModel().getSelectedItem();
        jobComboBoxEdit.setValue(edituser.getJob());
        nameTextFieldEdit.setText(edituser.getName());
        scoreTextFieldEdit.setText(String.valueOf(edituser.getScore()));
    }


}

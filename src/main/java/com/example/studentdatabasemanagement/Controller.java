package com.example.studentdatabasemanagement;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    public Controller() {
    }

    @FXML
    void initialize() {

    }

    // Admin's Button
    public void adminButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("admLogin-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    // Professor's button
    public void profButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profLogin-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}

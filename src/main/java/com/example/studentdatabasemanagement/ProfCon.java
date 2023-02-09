package com.example.studentdatabasemanagement;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProfCon {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Users> table_users;

    @FXML
    private TableColumn<Users, Integer> ID;

    @FXML
    private TableColumn<Users, String> GroupNumber;

    @FXML
    private TableColumn<Users, Integer> StudentID;

    @FXML
    private TableColumn<Users, String> StudentName;
    @FXML
    private TableColumn<Users,String> EmailAddress;
    @FXML
    private TableColumn<Users,String> PhoneNumber;


    ObservableList<Users> dataList;


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        search_user();

    }

    @FXML
    void search_user() throws SQLException, ClassNotFoundException {
        StudentID.setCellValueFactory(new PropertyValueFactory<Users, Integer>("studentID"));

        ID.setCellValueFactory(new PropertyValueFactory<Users, Integer>("nid"));
        GroupNumber.setCellValueFactory(new PropertyValueFactory<Users, String>("groupNumber"));
        StudentName.setCellValueFactory(new PropertyValueFactory<Users, String>("studentName"));
        EmailAddress.setCellValueFactory(new PropertyValueFactory<Users,String>("emailAddress"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<Users,String>("phoneNumber"));


        dataList = MySQLConnection.getDataUsers();
        table_users.setItems(dataList);
        FilteredList<Users> filteredData = new FilteredList<>(dataList, b -> true);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(person.getStudentID()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
                } else if (String.valueOf(person.getID()).indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                } else if (person.getGroupNumber().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                } else if (person.getStudentName().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;// Filter matches email
                } else if (person.getEmailAddress().toLowerCase().indexOf(lowerCaseFilter) != -1 ){
                    return true;
                } else if (person.getPhoneNumber().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }


                else
                    return false; // Does not match.
            });
        });
        SortedList<Users> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table_users.comparatorProperty());
        table_users.setItems(sortedData);
    }

    public void backPageClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

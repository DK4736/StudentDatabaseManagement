package com.example.studentdatabasemanagement;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;

public class TableSearching implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

    @FXML
    private TableView<Users> table_users;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_group;

    @FXML
    private TextField txt_studentID;

    @FXML
    private TextField txt_studentName;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_phone;


    @FXML
    private TextField searchingField;




    ObservableList<Users> listM;
    ObservableList<Users> dataList;


    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    public void Add_students() {
        Users user = new Users();
        conn = MySQLConnection.ConnectDb();
        String sql = "insert into student_info ( ID, studentID , studentName, GroupNumber, EmailAddress, PhoneNumber) values (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.setString(2, txt_studentID.getText());
            pst.setString(3, txt_studentName.getText());
            pst.setString(4, txt_group.getText());
            pst.setString(5, txt_email.getText());
            pst.setString(6, txt_phone.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Users Added successfully");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    //////METHOD SELECTED STUDENT DATA/////////
    @FXML
    void getSelected(MouseEvent event) {
        index = table_users.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
        txt_studentID.setText(StudentID.getCellData(index).toString());
        txt_id.setText(ID.getCellData(index).toString());
        txt_group.setText(GroupNumber.getCellData(index).toString());
        txt_studentName.setText(StudentName.getCellData(index).toString());
        txt_email.setText(EmailAddress.getCellData(index).toString());
        txt_phone.setText(PhoneNumber.getCellData(index).toString());

    }

    /// Modifying/Changing the Students information
    public void Modify() {
        try {
            conn = MySQLConnection.ConnectDb();
            String value1 = txt_id.getText();
            String value2 = txt_studentID.getText();
            String value3 = txt_studentName.getText();
            String value4 = txt_group.getText();
            String value5 = txt_email.getText();
            String value6 = txt_phone.getText();

            String sql = "update student_info set ID = '" + value1 + "' ,studentID= '" + value2 +
                    "',studentName= '" + value3 + "' ,GroupNumber= '" + value4 + "',EmailAddress= '" + value5 + "',PhoneNumber= '" + value6 + "' where ID '" + value1 + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

    }

    public void Delete() {
        conn = MySQLConnection.ConnectDb();
        String sql = "delete from student_info where ID= ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
            UpdateTable();
            search_user();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void UpdateTable() {
        StudentID.setCellValueFactory(new PropertyValueFactory<Users, Integer>("studentID"));
        ID.setCellValueFactory(new PropertyValueFactory<Users, Integer>("ID"));
        GroupNumber.setCellValueFactory(new PropertyValueFactory<Users, String>("groupNumber"));
        StudentName.setCellValueFactory(new PropertyValueFactory<Users, String>("studentName"));
        EmailAddress.setCellValueFactory(new PropertyValueFactory<Users,String>("email"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<Users,String>("phoneNumber"));

        listM = (ObservableList<Users>) MySQLConnection.getDataUsers();
        table_users.setItems(listM);
    }

    @FXML
    void search_user() {
        StudentID.setCellValueFactory(new PropertyValueFactory<Users,Integer>("studentID"));
        ID.setCellValueFactory(new PropertyValueFactory<Users,Integer>("id"));
        GroupNumber.setCellValueFactory(new PropertyValueFactory<Users,String>("groupNumber"));
        StudentName.setCellValueFactory(new PropertyValueFactory<Users,String>("studentName"));
        EmailAddress.setCellValueFactory(new PropertyValueFactory<Users,String>("emailAddress"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<Users,String>("phoneNumber"));

        dataList = (ObservableList<Users>) MySQLConnection.getDataUsers();
        table_users.setItems(dataList);
        FilteredList<Users> filteredData = new FilteredList<>(dataList, b -> true);
        searchingField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (String.valueOf(person.getStudentID()).indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                } else if (String.valueOf(person.getID()).indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if (person.getGroupNumber().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else if (person.getStudentName().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
                    return true;
                }else if (person.getEmailAddress().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                }else if (person.getPhoneNumber().toLowerCase().indexOf(lowerCaseFilter)!=-1){
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        UpdateTable();
        search_user();

    }

    public void backClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

package com.example.studentdatabasemanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class profLogin implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label LoginMessageLabel;

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;


     public profLogin(){}

     @FXML
     void initialize(){

     }

    @FXML
    public Button profLoginButton;
    public Button Back;




    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
      @FXML
     private void profLoginButton (ActionEvent event) throws Exception {
         conn = MySQLConnection.ConnectDb();
         String sql = "Select * from useraccount where UserName = ? and Password = ?";
         try {
             pst = conn.prepareStatement(sql);
             pst.setString(1, usernameTextField.getText());
             pst.setString(2, passwordField.getText());
             rs = pst.executeQuery();

             if (rs.next()) {
                 JOptionPane.showMessageDialog(null, "UserName and Password is Correct");
                 profLoginButton.getScene().getWindow().hide();
                 Parent root = FXMLLoader.load(getClass().getResource("ProfCon.fxml"));
                 Stage mainStage = new Stage();
                 Scene scene = new Scene(root);
                 mainStage.setScene(scene);
                 mainStage.show();

             } else {
                 JOptionPane.showMessageDialog(null, "UserName or Passsword is incorrect");
             }

         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);

         }


     }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}











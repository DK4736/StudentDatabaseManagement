package com.example.studentdatabasemanagement;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.DriverManager;

import javax.swing.*;
import java.sql.*;


public class MySQLConnection {
    private static final String username = "root";
    private static final String password = "";
    private static final String dataConn = "jdbc:mysql://localhost:3306/javafinalproject";

    private static Connection conn;


    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dataConn,username,password);
            System.out.println("Connection established......");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;

        }
        return conn;
    }

    public static ObservableList<Users> getDataUsers() {
        Connection conn = ConnectDb();
        ObservableList<Users> list = FXCollections.observableArrayList();
        try {
            PreparedStatement pst=null;
            ResultSet rs = null;
            pst = conn.prepareStatement("select * from student_info");
            rs = pst.executeQuery();
            while (rs.next()) {
                Users tempUser = new Users();
                tempUser.setStudentID(Integer.parseInt(rs.getString("studentID")));
                tempUser.setID(Integer.parseInt(rs.getString("ID")));
                tempUser.setGroupNumber(rs.getString("GroupNumber"));
                tempUser.setStudentName(rs.getString("studentName"));
                tempUser.setEmailAddress(rs.getString("EmailAddress"));
                tempUser.setPhoneNumber(rs.getString("PhoneNumber"));
                list.add(tempUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}


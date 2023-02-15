package com.example.studentdatabasemanagement;

public class Users {
    public int studentID, id;
    String studentName,groupNumber,emailAddress,phoneNumber;

    public Users() { }

    public Users( int id,int studentID, String groupNumber, String studentName,String emailAddress, String phoneNumber) {
        this.id = id;
        this.studentID = studentID;

        this.groupNumber = groupNumber;
        this.studentName = studentName;
        this.emailAddress = emailAddress;
        this.phoneNumber=phoneNumber;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setEmailAddress(String emailAddress) {this.emailAddress=emailAddress;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber=phoneNumber;}

    public int getStudentID() {
        return studentID;
    }

    public int getID() {
        return id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public String getStudentName() {
        return studentName;
    }
    public String getEmailAddress() {return emailAddress;}
    public String getPhoneNumber(){return phoneNumber;}
}

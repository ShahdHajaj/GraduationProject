package com.example.grad;

public class UserInfo {


    private String Password;
    private String UserName;
    private String Gender;
    private  int Age;
    private String Bmi;
    private String Smoking;


    public UserInfo() {
    }

    public UserInfo(int Age, String Password, String UserName, String Gender, String Bmi,String Smoking) {

        this.Password = Password;
        this.UserName = UserName;
        this.Gender = Gender;
        this.Age=Age;
        this.Bmi=Bmi;
        this.Smoking=Smoking;

    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }


    public String getBmi() {
        return Bmi;
    }

    public void setBmi(String bmi) {
        Bmi = bmi;
    }

    public void setSmoking(String smoking) {
        Smoking = smoking;
    }

    public String getSmoking() {
        return Smoking;
    }
}

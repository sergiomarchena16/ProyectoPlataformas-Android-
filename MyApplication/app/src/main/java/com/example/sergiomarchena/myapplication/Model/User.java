package com.example.sergiomarchena.myapplication.Model;

/**
 * Created by SergioMarchena on 3/14/18.
 */

public class User {

    private String Name, Password, Phone;

    public User (){

    }

    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

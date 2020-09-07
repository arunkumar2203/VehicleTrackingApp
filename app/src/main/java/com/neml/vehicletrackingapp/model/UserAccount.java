package com.neml.vehicletrackingapp.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "useraccounts" )
public class UserAccount {

    @PrimaryKey
    @NonNull
    String userId;
    String password;


    public UserAccount()
    {

    }
    public UserAccount(String username, String pwd)
    {
        this.userId = username;
        this.password = pwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}

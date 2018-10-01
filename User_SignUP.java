package com.example.lenovo.myapplication;

import android.app.Activity;
import android.widget.TextView;

public class User_SignUP {

    public String email;
    public String name;
    public String password;



    public int spent;
    public int payable;
    //TextView rees = (TextView) findViewById(R.id.result);

    public User_SignUP() {}

    public User_SignUP(String name, String email, String password)
    {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}

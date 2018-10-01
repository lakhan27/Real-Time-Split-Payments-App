package com.example.lenovo.myapplication;

import android.app.Activity;
import android.widget.TextView;

/**
 * Created by lenovo on 22-04-2018.
 */

public class Ev_Group
{


    public String ev_name;
    public String grp_code;

    public String[] participants = new String[10];
    public int[] expenditure = new int[10];

    public Ev_Group(){}

    public int[][] downs = new int[10][10];

    public Ev_Group(String ev_name, String grp_code)
    {
        this.ev_name = ev_name;
        this.grp_code = grp_code;
    }

    public String grp_create()
    {
        RandomN r = new RandomN();
        this.grp_code = Integer.toString(r.Generate());

        return this.grp_code;
    }

    public void grp_join(String grp_code)
    {
        this.grp_code = grp_code;
    }

    public Ev_Group thisobj()
    {
        return this;
    }

    public String getEv_name()
    {
        return this.ev_name;
    }

    void setEv_name(String ev_name)
    {
        this.ev_name = ev_name;
    }



}

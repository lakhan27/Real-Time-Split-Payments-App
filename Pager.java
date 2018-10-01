package com.example.lenovo.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by lenovo on 18-04-2018.
 */

public class Pager extends FragmentStatePagerAdapter {

    int tabcount;

    public Pager(FragmentManager fm , int tabcount){
        super(fm);
        this.tabcount=tabcount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                tab1_fragment tab1_fragment = new tab1_fragment();
                return tab1_fragment;
            case 1 :
                tab2_fragment tab2_fragment = new tab2_fragment();
                return tab2_fragment;
            case 2 :
                tab3_fragment tab3_fragment = new tab3_fragment();
                return tab3_fragment;
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}

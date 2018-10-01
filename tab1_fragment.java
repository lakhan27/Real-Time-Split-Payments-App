package com.example.lenovo.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.lenovo.myapplication.Main2Activity.*;

/**
 * Created by lenovo on 18-04-2018.
 */

public class tab1_fragment extends Fragment {

    TextView name;
    TextView code;
    TextView part;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab1,container,false);

        final Button activity =(Button)view.findViewById(R.id.activity);


        /*
        name.setText(intent.getStringExtra("lol1"));
        code.setText(intent.getStringExtra("lol2"));
        part.setText(intent.getStringExtra("lol3"));
        */

        activity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity.class);
                startActivity(intent);


            }
        });
        return view;

    }



}

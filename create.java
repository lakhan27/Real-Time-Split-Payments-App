package com.example.lenovo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class create extends Activity {


    TextView dispcode;
    EditText name;
    Ev_Group grp = new Ev_Group();
    TextView test;
    Button proceed;
    String temp1;

    DatabaseReference mRootRef1 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference GrpProp = mRootRef1.child("Group Properties");
    String temp;
    int i = 1;
    Intent in;
    Ev_Group curr_grp = new Ev_Group();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        test = (TextView)findViewById(R.id.Email_id);

         dispcode = (TextView) findViewById(R.id.code);
         name = (EditText) findViewById(R.id.event_n);
         proceed=(Button)findViewById(R.id.proceed);

        in = getIntent();

        String c = grp.grp_create();
        dispcode.setText(c);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grp.ev_name = name.getText().toString();
                GrpProp.child(grp.grp_code).child("ev_name").setValue(grp.ev_name);
                GrpProp.child(grp.grp_code).child("grp_code").setValue(grp.grp_code);
                //mRootRef1.child("i").child("value_i").setValue(i);



                mRootRef1.child("Current Group").child("curr_code").setValue(grp.grp_code);
                mRootRef1.child("Current Group").child("curr_name").setValue(grp.ev_name);

                /*
                if("Group".equals(in.getStringExtra("label")))
                {
                    temp1 = in.getStringExtra("email");
                    mRootRef1.child("Current Group").child(temp1).setValue("0");
                }*/

                Intent intent = new Intent(create.this, tab1.class);
                startActivity(intent);
            }
        });
    }

}

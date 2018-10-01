package com.example.lenovo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tab1 extends AppCompatActivity {


    TextView name;
    TextView code;
    TextView part;
    Button activity;
    Button records;

    User_SignUP me = new User_SignUP();
    Ev_Group curr_grp = new Ev_Group();

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mCurrGrpPart = mRootRef.child("Current Group").child("Participants");
    DatabaseReference mHiddenRef = mRootRef.child("HIDDEN");

    String temp;
    String temp2;
    String hidden1;

    int m, m2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab1);

        Intent intent = getIntent();
        me.email = intent.getStringExtra("name");




            mCurrGrpPart.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int i = 0;
                    for(DataSnapshot ds : dataSnapshot.getChildren())
                    {
                        temp = ds.getKey();
                        curr_grp.participants[i] = temp;
                        //temp2 = ds.child("spent").getValue(String.class);
                        //curr_grp.expenditure[i] += Integer.parseInt(temp2);
                        i++;
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });





        Log.i("create: ", "create called");



        activity=(Button)findViewById(R.id.activity);

        records=(Button)findViewById(R.id.records);

        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab1.this, activity.class);
                intent.putExtra("Group_Names", curr_grp.participants);
                intent.putExtra("Group_Expenditure", curr_grp.expenditure);
                intent.putExtra("label", "tab1");
                intent.putExtra("My_Email", me.email);
                intent.putExtra("My_Spent", me.spent);
                intent.putExtra("My_Payable", me.payable);
                startActivity(intent);
            }
        });

        records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tab1.this, records.class);
                intent.putExtra("Group_Names", curr_grp.participants);
                intent.putExtra("Group_Expenditure", curr_grp.expenditure);
                intent.putExtra("label", "tab1");
                intent.putExtra("My_Email", me.email);
                intent.putExtra("My_Spent", me.spent);
                intent.putExtra("My_Payable", me.payable);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

    }
}

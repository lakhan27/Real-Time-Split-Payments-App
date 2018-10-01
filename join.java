package com.example.lenovo.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class join extends AppCompatActivity {

    TextView code;
    TextView res1;
    DatabaseReference mRootRef11 = FirebaseDatabase.getInstance().getReference();
    DatabaseReference tempChild = mRootRef11.child("Group Properties");

    String temp;
    String temp2;
    String temp1;
    int x;

    Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        code = (EditText) findViewById(R.id.grpcode123);
        res1 = (TextView) findViewById(R.id.textView8);
        Button proceed=(Button)findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(join.this, tab1.class);
                in = getIntent();
                temp = code.getText().toString();

                mRootRef11.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot8) {
                        for(DataSnapshot ds : dataSnapshot8.getChildren())
                        {
                            temp2 = ds.child(temp).child("grp_code").getValue(String.class);
                            if(temp.equals(temp2))
                            {
                                x = 1;
                            }

                        }

                        if(x == 1)
                        {
                            if("Group".equals(in.getStringExtra("label")))
                            {
                                temp1 = in.getStringExtra("name");
                                mRootRef11.child("Current Group").child("Participants").child(temp1).child("name").setValue(temp1);
                                //mRootRef11.child("Current Group").child("Participants").child(temp1).child("spent").setValue("0");
                                //mRootRef11.child("Current Group").child("Participants").child(temp1).child("payable").setValue("0");
                                intent.putExtra("label", "join");
                                intent.putExtra("name", temp1);
                            }

                            res1.setText("Success!");

                            startActivity(intent);
                        }

                        else if(x == 0)
                        {
                            res1.setText("Could not find group. Please try again.");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });
    }
}

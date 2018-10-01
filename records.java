package com.example.lenovo.myapplication;

import android.content.Intent;
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

import javax.xml.datatype.DatatypeConfigurationException;

public class records extends AppCompatActivity {

    public Ev_Group curr_grp = new Ev_Group();
    User_SignUP me = new User_SignUP();

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;

    TextView e1;
    TextView e2;
    TextView e3;
    TextView e4;

    String key;

    String[] temp = new String[4];
    int w = 0;

    String[] d = new String[4];


    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mCurrPart = mRootRef.child("Current Group");
    DatabaseReference mHidden = mRootRef.child("HIDDEN");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        e1 = (TextView) findViewById(R.id.textView22);
        e2 = (TextView) findViewById(R.id.textView23);
        e3 = (TextView) findViewById(R.id.textView24);
        e4 = (TextView) findViewById(R.id.textView16);

        t1 = (TextView) findViewById(R.id.textView12);
        t2 = (TextView) findViewById(R.id.textView13);
        t3 = (TextView) findViewById(R.id.textView14);
        t4 = (TextView) findViewById(R.id.textView15);

        for(w = 0; w<4; w++)
        {
            temp[w] = "";
        }

        Intent i = getIntent();

        curr_grp.participants = i.getStringArrayExtra("Group_Names");
        curr_grp.expenditure = i.getIntArrayExtra("Group_Expenditure");

        me.email = i.getStringExtra("My_Email");

        me.spent = i.getIntExtra("My_Spent", 0);
        me.payable = i.getIntExtra("My_Payable", 0);

        mHidden.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int inn = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    key = ds.child("value").getValue(String.class);
                    temp[inn] = key;
                    Log.i("value", ds.child("value").getValue(String.class));
                    inn++;
                }

                e1.setText(temp[0]);
                e2.setText(temp[1]);
                e3.setText(temp[2]);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        t1.setText(curr_grp.participants[0]);
        t2.setText(curr_grp.participants[1]);
        t3.setText(curr_grp.participants[2]);
//        t4.setText(curr_grp.participants[3]);


        Button results=(Button)findViewById(R.id.result);
        results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(records.this, result.class);
                intent.putExtra("email", me.email);
                intent.putExtra("Participants", curr_grp.participants);
                startActivity(intent);
            }
        });
    }
}

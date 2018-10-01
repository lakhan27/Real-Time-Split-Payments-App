package com.example.lenovo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class result extends AppCompatActivity {


    TextView p0, p1, p2;

    TextView[] o0 = new TextView[3];
    TextView[] o1 = new TextView[3];
    TextView[] o2 = new TextView[3];

    TextView[] a0 = new TextView[3];
    TextView[] a1 = new TextView[3];
    TextView[] a2 = new TextView[3];

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mHidden20 = mRootRef.child("HIDDEN2").child("0");
    DatabaseReference mHidden21 = mRootRef.child("HIDDEN2").child("1");
    DatabaseReference mHidden22 = mRootRef.child("HIDDEN2").child("2");

    Ev_Group curr_grp = new Ev_Group();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        curr_grp.participants = intent.getStringArrayExtra("Participants");

        o0[1] = (TextView)findViewById(R.id.owes01);
        o0[2] = (TextView)findViewById(R.id.owes02);
        o1[0] = (TextView)findViewById(R.id.owes10);
        o1[2] = (TextView)findViewById(R.id.owes12);
        o2[0] = (TextView)findViewById(R.id.owes20);
        o2[1] = (TextView)findViewById(R.id.owes21);

        a0[1] = (TextView)findViewById(R.id.amt01);
        a0[2] = (TextView)findViewById(R.id.amt02);
        a1[0] = (TextView)findViewById(R.id.amt10);
        a1[2] = (TextView)findViewById(R.id.amt12);
        a2[0] = (TextView)findViewById(R.id.amt20);
        a2[1] = (TextView)findViewById(R.id.amt21);

        p0 = (TextView)findViewById(R.id.person0);
        p1 = (TextView)findViewById(R.id.person1);
        p2 = (TextView)findViewById(R.id.person2);

        p0.setText(curr_grp.participants[0]+" owes: ");
        p1.setText(curr_grp.participants[1]+" owes: ");
        p2.setText(curr_grp.participants[2]+" owes: ");


        mHidden20.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int inn = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {

                    if(inn == 3)
                    {
                        break;
                    }
                    String x = ds.child("owes").getValue(String.class);

                    if (inn == 1)
                    {
                        o0[1].setText(curr_grp.participants[1]);
                        a0[1].setText(x);
                    }

                    if (inn == 2)
                    {
                        o0[2].setText(curr_grp.participants[2]);
                        a0[2].setText(x);
                    }
                    inn++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mHidden21.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int inn = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    if(inn == 1)
                    {
                        inn++;
                        continue;
                    }
                    if(inn == 3)
                    {
                        break;
                    }
                    a1[inn].setText(ds.child("owes").getValue(String.class));
                    if (inn == 0)
                    {
                        o1[0].setText(curr_grp.participants[0]);
                    }
                    if (inn == 2)
                    {
                        o1[2].setText(curr_grp.participants[2]);
                    }
                    inn++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mHidden22.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int inn = 0;
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    if(inn == 2)
                    {
                        break;
                    }
                    a2[inn].setText(ds.child("owes").getValue(String.class));
                    if (inn == 0)
                    {
                        o2[0].setText(curr_grp.participants[0]);
                    }
                    if (inn == 1)
                    {
                        o2[1].setText(curr_grp.participants[1]);
                    }
                    inn++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

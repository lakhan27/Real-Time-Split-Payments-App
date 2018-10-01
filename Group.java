package com.example.lenovo.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Group extends AppCompatActivity {

    String temp;
    Intent i;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

         i = getIntent();

        /*
        if("Login_activity".equals(i.getStringExtra("label")))
        {
            Log.i("email: ", i.getStringExtra("email"));
            temp = i.getStringExtra("email");
            mRootRef.child("Current Group").child(temp).setValue("0");
        }
*/
        Button create=(Button)findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Group.this, create.class);
                /*
                if("Login_activity".equals(i.getStringExtra("label")))
                {
                    intent.putExtra("label", "Group");
                    intent.putExtra("name", temp);
                }*/
                startActivity(intent);
            }
        });

        Button join=(Button)findViewById(R.id.join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Group.this, join.class);
                if("Login_activity".equals(i.getStringExtra("label")))
                {
                    intent.putExtra("label", "Group");
                    intent.putExtra("name", i.getStringExtra("name"));
                }
                else if("Signup_activity".equals(i.getStringExtra("label")))
                {
                    intent.putExtra("label", "Group");
                    intent.putExtra("name", i.getStringExtra("name"));
                }
                startActivity(intent);
            }
        });

    }

}

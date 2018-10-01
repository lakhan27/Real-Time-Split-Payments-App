package com.example.lenovo.myapplication;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup_acivity extends AppCompatActivity {

    EditText pass;
    EditText emailid;
    EditText firstname;
    EditText lastname;
    Button done;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mUser = mRootRef.child("Users");

    int x;

    Login_activity l = new Login_activity();
    DataSnapshot dataSnapshot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_signup_acivity);
        pass = (EditText) findViewById(R.id.pass);
        emailid = (EditText) findViewById(R.id.emailid);
        firstname = (EditText) findViewById(R.id.firstname);
        done=(Button)findViewById(R.id.done);
        lastname = (EditText)findViewById(R.id.lastname);


        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(firstname.getText().toString().trim().equalsIgnoreCase("")){
                    firstname.setError("Enter your first name");
                }

                else if(lastname.getText().toString().trim().equalsIgnoreCase("")){
                    lastname.setError("Enter your last name");
                }

                else if(emailid.getText().toString().trim().equalsIgnoreCase("")) {
                    emailid.setError("Enter your email id");
                }

                else if(pass.getText().toString().trim().equalsIgnoreCase("")) {
                    pass.setError("Enter password");
                }

                else {

                    Intent intent = new Intent(Signup_acivity.this, Group.class);
                    startActivity(intent);
                }

            }
        });
        firstname.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                firstname.setError(null);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                firstname.setError(null);

            }
        });

        lastname.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                lastname.setError(null);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                lastname.setError(null);

            }
        });

        emailid.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailid.setError(null);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                emailid.setError(null);

            }
        });

        pass.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pass.setError(null);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                pass.setError(null);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = firstname.getText().toString();
                String em = emailid.getText().toString();
                String password = pass.getText().toString();

                User_SignUP user = new User_SignUP(u, em, password);


                mUser.child(em).child("name").setValue(user.name);
                mUser.child(em).child("password").setValue(user.password);

                Intent intent = new Intent(Signup_acivity.this, Group.class);
                intent.putExtra("label", "Signup_activity");
                intent.putExtra("name", em);
                startActivity(intent);
            }
        });
    }



}

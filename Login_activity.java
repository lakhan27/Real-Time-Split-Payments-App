package com.example.lenovo.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.R.attr.button;
import static android.R.attr.data;
import static android.R.attr.start;
import static android.R.attr.x;

public class Login_activity extends Activity {

    EditText password1;
    EditText Email_id;
    Button go;
    EditText name_ver;
    TextView res;
    String ver_pass;
    String em;

    public User_SignUP me = new User_SignUP();
    int x = 0;
    String ii;
    String pass;
    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mUser = mRootRef.child("Users");
    DataSnapshot dataSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login_activity);
        Email_id = (EditText) findViewById(R.id.Email_id);
        go=(Button)findViewById(R.id.go);
        password1= (EditText)findViewById(R.id.password);
        res = (TextView) findViewById(R.id.result);
        //name_ver = (EditText) findViewById(R.id.name_ver);

        go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(Email_id.getText().toString().trim().equalsIgnoreCase("")){
                    Email_id.setError("Enter Email id");
                }

                else if(password1.getText().toString().trim().equalsIgnoreCase("")){
                    password1.setError("Enter Password");
                }


            }
        });
        Email_id.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Email_id.setError(null);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                Email_id.setError(null);

            }
        });

        password1.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password1.setError(null);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                password1.setError(null);

            }
        });
    }

    /*
    public void SetSnap(DataSnapshot dataSnapshot)
    {
        this.dataSnapshot = dataSnapshot;
    }
*/

    @Override
    protected void onStart() {
        super.onStart();

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                em = Email_id.getText().toString();
                res.setText(em);
                pass = password1.getText().toString();
                //String n = name_ver.getText().toString();


                mRootRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot1) {


                        for(DataSnapshot ds : dataSnapshot1.getChildren())
                        {
                            ver_pass = ds.child(em).child("password").getValue(String.class);
                            if(pass.equals(ver_pass))
                            {
                                x = 1;
                                break;
                            }
                        }

                       if(x == 1)
                       {
                           res.setText("Success!");
                           //Intent i = new Intent(Login_activity.this, join.class);
                           Intent intent = new Intent(Login_activity.this, Group.class);

                           intent.putExtra("label", "Login_activity");
                           intent.putExtra("name", em);
                           //startActivity(i);
                           startActivity(intent);

                       }

                        else if(x == 0)
                       {
                           res.setText("Failure.");
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

package com.example.grad;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button butt1 = (Button)findViewById(R.id.signup1);
        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(MainActivity.this,signUp.class);
                MainActivity.this.startActivity(int1);
            }
           });

        Button butt2 = (Button)findViewById(R.id.login);
        username = (EditText) findViewById(R.id.namefiled);
        password = (EditText) findViewById(R.id.passwordfield);
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(username.getText().toString().matches("") || password.getText().toString().matches(""))) {
                    DataBaseHelperInfo dataBaseHelper = new DataBaseHelperInfo(MainActivity.this);
                    String userr = username.getText().toString();
                    Cursor cursor = dataBaseHelper.getUserByName(userr);
                    if (!cursor.moveToFirst()) {
                        Context context = getApplicationContext();
                        CharSequence text = "User not found";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else {
                        String pass = password.getText().toString();
                        if (pass.matches(cursor.getString(1))) {
                            Intent int1 = new Intent(MainActivity.this,login.class);
                            MainActivity.this.startActivity(int1);
                        }
                    }
                } else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Fill all Information";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}


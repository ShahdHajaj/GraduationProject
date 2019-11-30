package com.example.grad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
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
        sensorDataBaseHelper sensordatabasehelper = new sensorDataBaseHelper(MainActivity.this );
        Cursor cursor = sensordatabasehelper.getAllData();
        if (!cursor.moveToFirst()) {

            sensorInfo sensorinfo = new sensorInfo();
            sensorinfo.setTime("12:00:00:00");
            sensorinfo.setWeather("rainy");
            sensorinfo.setFasten(127);
            sensorinfo.setRandom(210);
            sensorinfo.setActive(1);
            sensorinfo.setEat(1);

            sensordatabasehelper.insertRow(sensorinfo);
            sensorinfo.setTime("1:00:00:00");
            sensorinfo.setWeather("sunny");
            sensorinfo.setFasten(75);
            sensorinfo.setRandom(129);
            sensorinfo.setActive(0);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("2:00:00:00");
            sensorinfo.setWeather("cloudy");
            sensorinfo.setFasten(143);
            sensorinfo.setRandom(250);
            sensorinfo.setActive(0);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("3:00:00:00");
            sensorinfo.setWeather("rainy");
            sensorinfo.setFasten(128);
            sensorinfo.setRandom(290);
            sensorinfo.setActive(0);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("4:00:00:00");
            sensorinfo.setWeather("rainy");
            sensorinfo.setFasten(150);
            sensorinfo.setRandom(300);
            sensorinfo.setActive(1);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("5:00:00:00");
            sensorinfo.setWeather("sunny");
            sensorinfo.setFasten(154);
            sensorinfo.setRandom(320);
            sensorinfo.setActive(0);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("6:00:00:00");
            sensorinfo.setWeather("cloudy");
            sensorinfo.setFasten(225);
            sensorinfo.setRandom(200);
            sensorinfo.setActive(1);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("7:00:00:00");
            sensorinfo.setWeather("cloudy");
            sensorinfo.setFasten(163);
            sensorinfo.setRandom(260);
            sensorinfo.setActive(1);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("8:00:00:00");
            sensorinfo.setWeather("sunny");
            sensorinfo.setFasten(90);
            sensorinfo.setRandom(149);
            sensorinfo.setActive(0);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("9:00:00:00");
            sensorinfo.setWeather("rainy");
            sensorinfo.setFasten(133);
            sensorinfo.setRandom(332);
            sensorinfo.setActive(0);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("10:00:00:00");
            sensorinfo.setWeather("cloudy");
            sensorinfo.setFasten(176);
            sensorinfo.setRandom(370);
            sensorinfo.setActive(1);
            sensordatabasehelper.insertRow(sensorinfo);
            sensorinfo.setTime("11:00:00:00");
            sensorinfo.setWeather("rainy");
            sensorinfo.setFasten(69);
            sensorinfo.setRandom(144);
            sensorinfo.setActive(1);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("13:00:00:00");
            sensorinfo.setWeather("rainy");
            sensorinfo.setFasten(180);
            sensorinfo.setRandom(400);
            sensorinfo.setActive(0);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("14:00:00:00");
            sensorinfo.setWeather("cloudy");
            sensorinfo.setFasten(167);
            sensorinfo.setRandom(310);
            sensorinfo.setActive(1);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("15:00:00:00");
            sensorinfo.setWeather("sunny");
            sensorinfo.setFasten(168);
            sensorinfo.setRandom(300);
            sensorinfo.setActive(1);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("16:00:00:00");
            sensorinfo.setWeather("rainy");
            sensorinfo.setFasten(155);
            sensorinfo.setRandom(366);
            sensorinfo.setActive(1);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("17:00:00:00");
            sensorinfo.setWeather("sunny");
            sensorinfo.setFasten(187);
            sensorinfo.setRandom(220);
            sensorinfo.setActive(0);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensordatabasehelper.insertRow(sensorinfo);
            sensorinfo.setTime("18:00:00:00");
            sensorinfo.setWeather("cloudy");
            sensorinfo.setFasten(140);
            sensorinfo.setRandom(410);
            sensorinfo.setActive(1);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("19:00:00:00");
            sensorinfo.setWeather("rainy");
            sensorinfo.setFasten(169);
            sensorinfo.setRandom(350);
            sensorinfo.setActive(1);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("20:00:00:00");
            sensorinfo.setWeather("cloudy");
            sensorinfo.setFasten(157);
            sensorinfo.setRandom(244);
            sensorinfo.setActive(0);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("21:00:00:00");
            sensorinfo.setWeather("sunny");
            sensorinfo.setFasten(97);
            sensorinfo.setRandom(133);
            sensorinfo.setActive(0);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("22:00:00:00");
            sensorinfo.setWeather("sunny");
            sensorinfo.setFasten(77);
            sensorinfo.setRandom(130);
            sensorinfo.setActive(1);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("23:00:00:00");
            sensorinfo.setWeather("rainy");
            sensorinfo.setFasten(100);
            sensorinfo.setRandom(200);
            sensorinfo.setActive(0);
            sensorinfo.setEat(1);
            sensordatabasehelper.insertRow(sensorinfo);

            sensorinfo.setTime("24:00:00:00");
            sensorinfo.setWeather("sunny");
            sensorinfo.setFasten(300);
            sensorinfo.setRandom(245);
            sensorinfo.setActive(0);
            sensorinfo.setEat(0);
            sensordatabasehelper.insertRow(sensorinfo);
        }



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
                            SharedPreferences sharedPreference = getSharedPreferences("usernameInfo", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreference.edit();
                            editor.putString("username", userr);
                            editor.commit();
                        }

                        Intent intent = new Intent(MainActivity.this,MyService.class);
                        startService(intent);

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


package com.example.grad;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        TextView textView1=findViewById(R.id.timefield);
        TextView textView2=findViewById(R.id.weatherfield);
        TextView textView3=findViewById(R.id.activefiled);
        TextView textView4=findViewById(R.id.fastenfiled);
        TextView textView5=findViewById(R.id.randomfiled);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());

        textView1.setText(currentDateandTime);
        sensorDataBaseHelper dataBaseHelper = new sensorDataBaseHelper(login.this);
        Cursor cursor = dataBaseHelper.getDataByTime(currentDateandTime.split(":")[0]+":00:00:00");
        if (cursor.moveToFirst()) {
            SharedPreferences sharedPreference = getSharedPreferences("usernameInfo", Context.MODE_PRIVATE);
            String username = sharedPreference.getString("username", "");
            DataBaseHelperInfo dataBaseHelper2 = new DataBaseHelperInfo(login.this);
            Cursor cursor2 = dataBaseHelper2.getUserByName(username);
            if (!cursor2.moveToFirst()) {
                Context context = getApplicationContext();
                CharSequence text = "User not found";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {

            }
            textView2.setText(cursor.getString(1));
            if (cursor.getString(5).matches("0")) {
                textView3.setText("Not Active");
            }
            else {
                textView3.setText("Active");

            }
            textView4.setText(cursor.getString(3));
            textView5.setText(cursor.getString(4));

        }

    }
}

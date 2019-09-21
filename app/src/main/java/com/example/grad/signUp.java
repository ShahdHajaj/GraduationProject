package com.example.grad;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class signUp extends AppCompatActivity {
    EditText user, password, age;
    RadioGroup smoking, gender, male, female;
    Button sign;
    Spinner bmi;
    String gen, smok = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        age = findViewById(R.id.Agefiled);
        user = findViewById(R.id.userfield2);
        password = findViewById(R.id.passfield);
        gender = findViewById(R.id.genderfield);
        smoking = findViewById(R.id.smokingfield);
        String[] options = {"Under", "Healthy", "Over", "Obese"};
        bmi = (Spinner) findViewById(R.id.bmifield);
        ArrayAdapter objGenderArr = new ArrayAdapter(this, android.R.layout.simple_spinner_item, options);
        bmi.setAdapter(objGenderArr);
        sign = (Button) findViewById(R.id.signup2);
        gender = (RadioGroup) findViewById(R.id.genderfield);
        smoking = (RadioGroup) findViewById(R.id.smokingfield);

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup RadioGroup, int checkedId) {

                if (checkedId == R.id.Male) {
                    gen = "Male";

                } else if (checkedId == R.id.Female) {
                    gen = "Female";
                }
            }
        });
        smoking.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup RadioGroup, int checkedId) {

                if (checkedId == R.id.yes) {
                    smok = "Yes";

                } else if (checkedId == R.id.no) {
                    smok = "No";
                }
            }
        });


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(age.getText().toString().matches("") || user.getText().toString().matches("") || password.getText().toString().matches("")) || bmi.getSelectedItem().toString().matches("")) {
                    if (!(gender.getCheckedRadioButtonId() == -1 || smoking.getCheckedRadioButtonId() == -1)) {
                        int agee = Integer.parseInt(age.getText().toString());
                        String userr = user.getText().toString();
                        String pass = password.getText().toString();
                        String bmii = bmi.getSelectedItem().toString();
                        DataBaseHelperInfo dataBaseHelper = new DataBaseHelperInfo(signUp.this);
                        Cursor cursor = dataBaseHelper.getUserByName(userr);
                        if (cursor.moveToFirst()) {
                            Context context = getApplicationContext();
                            CharSequence text = "There is an existing name, please enter another one.";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            UserInfo user = new UserInfo();
                            user.setAge(agee);
                            user.setBmi(bmii);
                            user.setGender(gen);
                            user.setPassword(pass);
                            user.setSmoking(smok);
                            user.setUserName(userr);

                            dataBaseHelper.insertUser(user);
                            finish();
                            Context context = getApplicationContext();

                            CharSequence text = "Sign up successfully";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            Intent int1 = new Intent(signUp.this, MainActivity.class);
                            signUp.this.startActivity(int1);
                        }
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Fill all Information";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Fill all Information";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }

}
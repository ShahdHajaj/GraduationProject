package com.example.grad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class signUp extends Activity {
    EditText user, password,age;
    RadioGroup bmi,smoking,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        age = (EditText) findViewById(R.id.Agefiled);
        user = (EditText) findViewById(R.id.Agefiled);
        password = (EditText) findViewById(R.id.passwordT);
        gender = (RadioGroup) findViewById(R.id.genderfield);
        bmi = (RadioGroup) findViewById(R.id.bmifield);
        smoking = (RadioGroup) findViewById(R.id.smokingfield);

        Button sign = (Button) findViewById(R.id.signup2);
        sign.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!(age.getText().toString().matches("") || user.getText().toString().matches("")|| password.getText().toString().matches("") )) {
                CharSequence text = "Fill all Info Please";


            }
    }
});
    }

}
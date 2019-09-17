package com.example.grad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.Context;

public class signUp extends Activity {
    EditText user, password,age;
    RadioGroup bmi,smoking,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        age =      findViewById(R.id.Agefiled);
        user =     findViewById(R.id.userfield2);
        password = findViewById(R.id.passfield);
        gender =   findViewById(R.id.genderfield);
        bmi =      findViewById(R.id.bmifield);
        smoking =  findViewById(R.id.smokingfield);

        Button sign = findViewById(R.id.signup2);
        sign.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!(age.getText().toString().matches("") || user.getText().toString().matches("")|| password.getText().toString().matches("") )) {
                Context context = getApplicationContext();
                CharSequence text = "Fill all Info Please";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
    }
});
    }

}
package com.example.moizzahid.classtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup();
            }
        });

    }
    public void Signup() {
        EditText name = (EditText) findViewById(R.id.editTextNAME);
        EditText email = (EditText) findViewById(R.id.editTextEMAIL);
        EditText pass = (EditText) findViewById(R.id.editTextPWD);
        EditText ph_num = (EditText) findViewById(R.id.editTextPH);

        Intent myintent = new Intent(getApplicationContext() , listview.class);
        Bundle data = new Bundle();
        data.putString("name" , name.getText().toString());
        data.putString("email" , email.getText().toString());
        data.putString("password" , pass.getText().toString());
        data.putString("phonenumber" , ph_num.getText().toString());

        myintent.putExtras(data);
        startActivity(myintent);

    }
}

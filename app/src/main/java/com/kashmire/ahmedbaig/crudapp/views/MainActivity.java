package com.kashmire.ahmedbaig.crudapp.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kashmire.ahmedbaig.crudapp.R;
import com.kashmire.ahmedbaig.crudapp.database.DatabseHelper;
import com.kashmire.ahmedbaig.crudapp.utils.contact;

import java.io.Console;

public class MainActivity extends AppCompatActivity {


    DatabseHelper helper = new DatabseHelper(this);

    private static final String TAG= Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View v){
        switch (v.getId()){
            case R.id.login:
                EditText name = findViewById(R.id.name);
                EditText password = findViewById(R.id.password);
                //TODO:
                // 1: Read from database here
                contact person = new contact(name.getText().toString(), password.getText().toString());
                Bundle data = helper.validateUser(person);
                Toast.makeText(getApplicationContext(), data.getString("token")+
                        " "+data.getString("approved"), Toast.LENGTH_SHORT).show();
                // 2: match results
                if(Boolean.valueOf(data.getString("approved"))){
                    // 3: intent to Notes with user ID
                    Intent loginPage = new Intent(getApplicationContext(), Notes.class);
                    startActivity(loginPage);
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.openRegister:
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
                break;
        }
    }

}

package com.kashmire.ahmedbaig.crudapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kashmire.ahmedbaig.crudapp.R;
import com.kashmire.ahmedbaig.crudapp.database.DatabseHelper;
import com.kashmire.ahmedbaig.crudapp.utils.contact;

public class Register extends AppCompatActivity {

    DatabseHelper helper = new DatabseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    public void onClickButton2(View v){
        switch (v.getId()){
            case R.id.register:
                EditText name = (EditText) findViewById(R.id.editTextNAME);
                EditText email = (EditText) findViewById(R.id.editTextEMAIL);
                EditText pass = (EditText) findViewById(R.id.editTextPWD);
                EditText con_pass = (EditText) findViewById(R.id.editTextCONPWD);
                EditText ph_num = (EditText) findViewById(R.id.editTextPH);
                if(pass.getText().toString().contentEquals(con_pass.getText().toString())){
                    //TODO:
                    // 1: match if already exists
                    contact person = new contact(name.getText().toString(), email.getText().toString(), pass.getText().toString(),ph_num.getText().toString());
                    Toast.makeText(getApplicationContext(), String.valueOf(helper.verifyEntry(person)), Toast.LENGTH_SHORT).show();
//                    if(helper.verifyEntry(person)){
//                        // 2: add to data
//                        helper.insertPerson(person);
//                        // 3: go back to login screen
//                        Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
//                        this.finish();
//                    }else{
//                        Toast.makeText(getApplicationContext(), "User already exists", Toast.LENGTH_SHORT).show();
//                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Passwords did not match", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.openLogin:
                this.finish();
                break;
        }
    }
}

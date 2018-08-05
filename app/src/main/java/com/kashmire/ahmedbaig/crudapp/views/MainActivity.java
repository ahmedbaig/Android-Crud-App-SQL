package com.kashmire.ahmedbaig.crudapp.views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kashmire.ahmedbaig.crudapp.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG= Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View v){
        switch (v.getId()){
            case R.id.login:
                //TODO:
                // 1: Read from database here
                // 2: match results
                // 3: intent to Notes with user ID
                break;
            case R.id.openRegister:
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
                break;
        }
    }

}

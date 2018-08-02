package com.example.moizzahid.classtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class listview extends AppCompatActivity implements AdapterView.OnItemClickListener  {


    //    TODO 1 :delete the samearray
//    String[] sampleArray = {"Janauary", "Feburary", "March", "April", "May", "June",
//            "July", "August", "September", "October", "November", "December"};;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView lst ;
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> email = new ArrayList<String>();
        ArrayList<String> password = new ArrayList<String>();
        ArrayList<String> phonenumber = new ArrayList<String>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names.add(getIntent().getExtras().getString("name"));
        email.add(getIntent().getExtras().getString("email"));
        password.add(getIntent().getExtras().getString("password"));
        phonenumber.add(getIntent().getExtras().getString("phonenumber"));
        lst = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.activity_list_item, names);
        lst.setAdapter(arrayAdapter);
        lst.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?>parent, View view, int position, long id){
        TextView tv=(TextView)view;
        Toast.makeText(this,"You click on"+ tv.getText()+ position ,Toast.LENGTH_SHORT).show();
    }
}

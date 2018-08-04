package com.example.moizzahid.classtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class listview extends AppCompatActivity{

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();

        ListItem listItem = new ListItem(
                getIntent().getExtras().getString("name"),
                getIntent().getExtras().getString("phonenumber"),
                getIntent().getExtras().getString("password"),
                getIntent().getExtras().getString("email")
        );
        listItems.add(listItem);

        adapter = new RecyclerViewAdapter(listItems, this);

        recyclerView.setAdapter(adapter);
    }

//    public void onItemClick(AdapterView<?>parent, View view, int position, long id){
//        TextView tv=(TextView)view;
//        Toast.makeText(this,"You click on"+ tv.getText()+ position ,Toast.LENGTH_SHORT).show();
//    }
}

package com.kashmire.ahmedbaig.crudapp.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kashmire.ahmedbaig.crudapp.R;

public class NoteDetail extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_view);
        //TODO:
        // 1: get the ID from intent of previous page
        // 2: search from database for note with the ID and user
        // 3: get note data
        // 4: set data tho the textviews accordingly
    }
    public void onClickButton4(View v){
        this.finish();
    }
}

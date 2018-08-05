package com.kashmire.ahmedbaig.crudapp.views;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.kashmire.ahmedbaig.crudapp.R;

public class Notes extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_view);
    }


    public void onClickButton3(View v){
        switch (v.getId()){
            case R.id.floatingActionButton:
                //TODO:
                // 1: Create a popup box with Text Fields inside
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Notes.this);
                View mView = getLayoutInflater().inflate(R.layout.create_new_note_dialog, null);
                final EditText mEmail = (EditText) mView.findViewById(R.id.create_note_description);
                Button add = (Button) mView.findViewById(R.id.addNote);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 2: On Submit add that data to the database for recycler

                        // 3: dismiss dialog box
                        dialog.dismiss();
                    }
                });
                break;
        }
    }
}
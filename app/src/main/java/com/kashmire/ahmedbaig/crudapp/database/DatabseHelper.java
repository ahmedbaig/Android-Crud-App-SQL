package com.kashmire.ahmedbaig.crudapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

import com.kashmire.ahmedbaig.crudapp.utils.contact;

public class DatabseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "note.db";
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_email = "email";
    private static final String COLUMN_PASS = "pass";
    private static final String COLUMN_PHONE = "phone";

    private SQLiteDatabase db;

    private static final String TABLE_CREATE = "CREATE TABLE users (id integer primary key autoincrement not null ,name text not null, email text not null, pass text not null, phone text not null )";

    public DatabseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void insertPerson(contact person){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, person.getName());
        values.put(COLUMN_email, person.getEmail());
        values.put(COLUMN_PASS, person.getPass());
        values.put(COLUMN_PHONE, person.getPhone());

        db.insert(TABLE_NAME, null, values);

    }

    public boolean verifyEntry(contact person) {
        db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, COLUMN_email);
        if(count>=1){
            return false;
        }else{
            return true;
        }
    }

    public Bundle validateUser(contact person){
        db = this.getReadableDatabase();
        String query = "SELECT id, phone, email, pass  FROM users WHERE email="+person.getEmail()+" AND pass="+person.getPass()+";";
        Cursor cursor = db.rawQuery(query, null);
        String id, email, phone, pass;
        Bundle data = new Bundle();
        data.putString("approved", String.valueOf(false));
        if(cursor.moveToFirst()){
            do {
                id = cursor.getString(0);
                phone = cursor.getString(1);
                email= cursor.getString(2);
                pass = cursor. getString(3);
                if(email.contentEquals(person.getEmail()) && pass.contentEquals(person.getPass())){
                    data.putString("email", email);
                    data.putString("phone_number", phone);
                    data.putString("token", id);
                    data.putString("approved", String.valueOf(true));
                    break;
                }
            }while (cursor.moveToNext());
        }
        return data;
    }

}

package com.unalyeten.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create database
        SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Vehicles", MODE_PRIVATE, null);

        // Create table
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Automobiles (id INTEGER PRIMARY KEY, name VARCHAR, age INT)");

        // DELETE ALL
        sqLiteDatabase.execSQL("DELETE FROM Automobiles");

        // Insert
        sqLiteDatabase.execSQL("INSERT INTO Automobiles (name, age) VALUES ('Ünal', 40)");

        // Update
        //sqLiteDatabase.execSQL("UPDATE Automobiles SET name = 'Ünal2' WHERE name = 'Ünal'");

        // Select
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Automobiles", null);

        // Index
        int idIndex = cursor.getColumnIndex("id");
        int nameIndex = cursor.getColumnIndex("name");
        int ageIndex = cursor.getColumnIndex("age");

        // Diplay
        while (cursor.moveToNext()){
            System.out.println(cursor.getString(idIndex));
            System.out.println(cursor.getString(nameIndex));
            System.out.println(cursor.getString(ageIndex));
        }

    }
}
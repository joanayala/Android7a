package com.joan.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListPetsActivity extends AppCompatActivity {

    private ListView ListAllPets;
    Database mypets;
    ArrayList<String> listItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pets);

        ListAllPets = findViewById(R.id.lvListAllPets);
        mypets = new Database(this, "mypets",null,1);
        listItem = new ArrayList<>();

        //Here we are going to list all pets
        viewAllPets();
    }

    private void viewAllPets(){
        //Connect to DB
        Database manager = new Database(this, "mypets", null, 1);
        //Let write on DB
        SQLiteDatabase mypets = manager.getWritableDatabase();
        Cursor row = mypets.rawQuery("SELECT * FROM pets", null);

        if (row.getCount() == 0) {
            Toast.makeText(this, "::: Empty Database :::", Toast.LENGTH_SHORT).show();
        } else {
            while (row.moveToNext()) {
                listItem.add(row.getString(1));
                listItem.add(row.getString(4));
            }
            adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_expandable_list_item_1, listItem);
            ListAllPets.setAdapter(adapter);
        }
    }
}

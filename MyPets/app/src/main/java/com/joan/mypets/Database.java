package com.joan.mypets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase mypets) {
        //Create users table
        mypets.execSQL("CREATE TABLE users (" +
                "id integer primary key autoincrement not null," +
                "email text unique not null," +
                "password text not null," +
                "firstname text," +
                "lastname text," +
                "mobile text)"
        );
        mypets.execSQL("CREATE TABLE pets (" +
                "id integer primary key autoincrement not null," +
                "name text not null," +
                "age text," +
                "gender text," +
                "race text)"
        );
        mypets.execSQL("INSERT INTO users (email, password) " +
                "VALUES('admin','12345')");
        mypets.execSQL("INSERT INTO users (email, password, firstname, lastname, mobile) " +
                "VALUES('peter','1234567','Peter','McDonald','300567777')");
        mypets.execSQL("INSERT INTO pets (name, age, gender, race) " +
                "VALUES('Luna','2','Female','None')");
        mypets.execSQL("INSERT INTO pets (name, age, gender, race) " +
                "VALUES('Lulu','5','Female','None')");
        mypets.execSQL("INSERT INTO pets (name, age, gender, race) " +
                "VALUES('Pow','3','Male','None')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase mypets, int i, int i1) {
        mypets.execSQL("CREATE TABLE pets (" +
                "id integer primary key autoincrement not null," +
                "name text not null," +
                "age text," +
                "gender text," +
                "race text)"
        );
        mypets.execSQL("INSERT INTO pets (name, age, gender, race) " +
                "VALUES('Luna','2','Female','None')");
        mypets.execSQL("INSERT INTO pets (name, age, gender, race) " +
                "VALUES('Lulu','5','Female','None')");
        mypets.execSQL("INSERT INTO pets (name, age, gender, race) " +
                "VALUES('Pow','3','Male','None')");
    }


}

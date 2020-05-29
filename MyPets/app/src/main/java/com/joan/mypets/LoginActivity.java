package com.joan.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText user_name, passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name = findViewById(R.id.txtUsername);
        passwd = findViewById(R.id.txtPassword);

    }

    public void btnLogin (View view) {
        //Connect to DB
        Database manager = new Database(this, "mypets", null, 1);
        //Let write on DB
        //SQLiteDatabase mypets = manager.getWritableDatabase();
        SQLiteDatabase mypets = manager.getWritableDatabase();
        //Get values from UI
        String UNAME = user_name.getText().toString();
        String PASSWD = passwd.getText().toString();

        if (UNAME.isEmpty() || PASSWD.isEmpty()) {
            Toast.makeText(this, "::: There are some empty fields :::", Toast.LENGTH_SHORT).show();
            user_name.setError("");
            passwd.setError("");
        } else {
            //Validate if user already exists
            Cursor row = mypets.rawQuery("SELECT * FROM users " + "WHERE email = ? AND password = ? LIMIT 1", new String[]{UNAME,PASSWD});

            if (row.getCount() > 0) {
                Intent i = new Intent(this, ListUsersActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(this,
                        "::: Invalid information :::", Toast.LENGTH_SHORT).show();
                user_name.setError("");
                passwd.setError("");
            }
        }
    }

    public void btnGotoRegisterUser (View view) {
        Intent i = new Intent(this, RegisterUserActivity.class);
        startActivity(i);
    }
}

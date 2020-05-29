package com.joan.mypets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUserActivity extends AppCompatActivity {

    private EditText user_name, passwd, passwd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        user_name = findViewById(R.id.txtUsernameRegiter);
        passwd = findViewById(R.id.txtPasswordRegister);
        passwd2 = findViewById(R.id.txtPassword2);
    }

    public void btnSignup (View view) {
        //Connect to DB
        Database manager = new Database(this, "mypets", null, 1);

        //Let write on DB
        SQLiteDatabase mypets = manager.getWritableDatabase();

        //Get values from UI
        String UNAME = user_name.getText().toString();
        String PASSWD = passwd.getText().toString();
        String PASSWD2 = passwd2.getText().toString();

        if (UNAME.isEmpty() || PASSWD.isEmpty() || PASSWD2.isEmpty()){
            Toast.makeText(this, "::: There are some empty fields :::", Toast.LENGTH_SHORT).show();
            user_name.setError("");
            passwd.setError("");
            passwd2.setError("");
        } else {
            if (!PASSWD.equals(PASSWD2)){
                Toast.makeText(this, "::: Passwords do not match :::", Toast.LENGTH_SHORT).show();
                passwd.setError("");
                passwd2.setError("");
            } else {
                //Validate if user already exists
                Cursor row = mypets.rawQuery("SELECT * FROM users " +
                        "WHERE email = ? LIMIT 1", new String[]{UNAME});
                //getCount() < 1 or moveToFirst()
                if(row.getCount()>0){
                    Toast.makeText(this, "::: The user already exits :::", Toast.LENGTH_SHORT).show();
                } else {
                    //Make a package values
                    ContentValues data = new ContentValues();

                    data.put("email", UNAME);
                    data.put("password", PASSWD);

                    mypets.insert("users",null,data);
                    mypets.close();

                    Toast.makeText(this, "::: The user has been created :::", Toast.LENGTH_LONG).show();

                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);
                }
            }
        }
    }
}

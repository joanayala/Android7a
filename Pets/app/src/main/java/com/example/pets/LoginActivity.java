package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Toast.makeText(this, "Creating app on device", Toast.LENGTH_LONG).show();
    }

    public void Btn_Login(View view){
        Toast.makeText(this, "You have pressed login button", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,
                InboxActivity.class);
        startActivity(intent);
    }
    public void Btn_Signup(View view){
        Toast.makeText(this, "You have pressed sign up button", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,
                RegisterActivity.class);
        startActivity(intent);
    }
    /*
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "The app has started", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "The app is on your screen", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "The app has been paused", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "The app has been stopped", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "The app has been restarted", Toast.LENGTH_SHORT).show();
    }
    */
}

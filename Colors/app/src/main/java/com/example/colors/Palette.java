package com.example.colors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class Palette extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {

    private SeekBar vRed = null;
    private SeekBar vGreen = null;
    private SeekBar vBlue = null;
    private SeekBar vAlpha = null;
    private View vFilter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        //Code here .....
        //Get components' id's
        vRed = findViewById(R.id.sbrRed);
        vGreen = findViewById(R.id.sbrGreen);
        vBlue = findViewById(R.id.sbrBlue);
        vAlpha = findViewById(R.id.sbrAlpha);
        vFilter = findViewById(R.id.vieColors);

        vRed.setOnSeekBarChangeListener(this);
        vGreen.setOnSeekBarChangeListener(this);
        vBlue.setOnSeekBarChangeListener(this);
        vAlpha.setOnSeekBarChangeListener(this);
    }

    //#############################################
    //MENUS
    //#############################################
    //Show the options menu on the Device.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Item actions.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.iteTransparent :
                vAlpha.setProgress(0);
                //Toast.makeText(this, "This color is going to change", Toast.LENGTH_SHORT).show();
                break;

            case R.id.iteSemitransparent :
                vAlpha.setProgress(128);
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                break;

            case R.id.iteOpaque :
                vAlpha.setProgress(255);
                break;

            case R.id.iteBlack :
                break;

            case R.id.iteWhite :
                //Code to change color
                break;

            case R.id.iteRed :
                vRed.setProgress(255);
                vGreen.setProgress(0);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;

            case R.id.iteGreen :
                //Change color to green
                vRed.setProgress(0);
                vGreen.setProgress(255);
                vBlue.setProgress(0);
                vAlpha.setProgress(128);
                break;

            case R.id.iteBlue :
                //Change color to blue
                vRed.setProgress(0);
                vGreen.setProgress(0);
                vBlue.setProgress(255);
                vAlpha.setProgress(128);
                break;

            case R.id.iteCyan :
                break;

            case R.id.iteMagenta :
                break;

            case R.id.iteYellow :
                break;

            case R.id.iteReset :
                break;

            case R.id.iteAboutof :
                //Go/jump to Aboutof Activity
                Intent intent = new Intent(this, AboutofActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean bo) {
        //1. Get Seekbar values
        int r = vRed.getProgress();
        int g = vGreen.getProgress();
        int b = vBlue.getProgress();
        int a = vAlpha.getProgress();

        //2. Convert values (in step 1) to ARGB function
        int filter_color = Color.argb(a,r,g,b); //Alpha, Red, Green, Blue

        /*
        int filter_color = Color.argb(
            vRed.getProgress(),
            vGreen.getProgress(),
            vBlue.getProgress(),
            vAlpha.getProgress()
        );
        */

        //3. Set the new color to Image (View)
        vFilter.setBackgroundColor(filter_color);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

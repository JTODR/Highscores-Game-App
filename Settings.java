package com.joeysapp.joseph.highscoresgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    public final static String TIMER = "newTimeForGame";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void backToMainMenu(View view){
        Intent menu_intent = new Intent(this, MainActivity.class);
        startActivity(menu_intent);
    }

    //Set timer to 10 seconds
    public void mainMenu10Sec(View view){
        String time_10sec = "10";

        Intent menu_intent = new Intent(this, MainActivity.class);
        menu_intent.putExtra(TIMER, time_10sec);       //Send along the new time

        String changed_time = "Timer has been set to " + time_10sec + " seconds";
        Toast.makeText(Settings.this, changed_time, Toast.LENGTH_SHORT).show();

        startActivity(menu_intent);
    }

    //Set timer to 20 seconds
    public void mainMenu20Sec(View view){
        String time_20sec = "20";

        Intent menu_intent = new Intent(this, MainActivity.class);
        menu_intent.putExtra(TIMER, time_20sec);       //Send along the new time

        String changed_time = "Timer has been set to " + time_20sec + " seconds";
        Toast.makeText(Settings.this, changed_time, Toast.LENGTH_SHORT).show();

        startActivity(menu_intent);
    }

    //Set timer to 30 seconds
    public void mainMenu30Sec(View view){
        String time_30sec = "30";

        Intent menu_intent = new Intent(this, MainActivity.class);
        menu_intent.putExtra(TIMER, time_30sec);       //Send along the new time

        String changed_time = "Timer has been set to " + time_30sec + " seconds";
        Toast.makeText(Settings.this, changed_time, Toast.LENGTH_SHORT).show();

        startActivity(menu_intent);
    }

    //Set timer to 60 seconds
    public void mainMenu60Sec(View view){
        String time_60sec = "60";

        Intent menu_intent = new Intent(this, MainActivity.class);
        menu_intent.putExtra(TIMER, time_60sec);       //Send along the new time

        String changed_time = "Timer has been set to " + time_60sec + " seconds";
        Toast.makeText(Settings.this, changed_time, Toast.LENGTH_SHORT).show();

        startActivity(menu_intent);
    }
}

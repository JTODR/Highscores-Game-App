package com.joeysapp.joseph.highscoresgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final static String TIMER_KEY = "timerLengthForGame";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seeHighscores(View view){
        Intent highscores_intent = new Intent(this, Highscores.class);
        startActivity(highscores_intent);       //open the highscores activity

    }

    public void startNewGame(View view){
        Intent received_intent = getIntent();
        String timer_length = received_intent.getStringExtra(Settings.TIMER);

        if(timer_length == null){   //if no timer was set in Settings
            timer_length = "10";
        }

        Intent new_game_intent = new Intent(this, CountdownForNewGame.class);
        new_game_intent.putExtra(TIMER_KEY, timer_length);  //send along new time for the game

        startActivity(new_game_intent);     //opens activity to start a new game
    }

    public void openSettings(View view){
        Intent settings_intent = new Intent(this, Settings.class);
        startActivity(settings_intent);
    }
}

package com.joeysapp.joseph.highscoresgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //public final static String HIGHSCORES_KEY = "HIGHSCORES";

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
        Intent new_game_intent = new Intent(this, CountdownForNewGame.class);
        startActivity(new_game_intent);     //opens activity to start a new game
    }
}

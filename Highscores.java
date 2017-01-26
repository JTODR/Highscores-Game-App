package com.joeysapp.joseph.highscoresgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Highscores extends AppCompatActivity {

    DBHandler dbHandler;
    private TextView testScoreText;
    private Button deleteHighscoresButton;
    private Button newGameButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);

        testScoreText = (TextView) findViewById(R.id.testScoreText);
        deleteHighscoresButton = (Button)findViewById(R.id.deleteHighscoresButton);
        newGameButton = (Button)findViewById(R.id.newGameButton);

        dbHandler = new DBHandler(this, null, null, 1);
        printDatabase();

    }

    public void mainMenuReturn(View view){
        Intent main_menu_intent = new Intent(this, MainActivity.class);
        startActivity(main_menu_intent);
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        //String scoreString = dbHandler.scoreToString();
        //String printString = dbString + " " + scoreString;
        testScoreText.setText(dbString);
    }

    public void deleteBtnClicked(View view){
        dbHandler.deleteHighscores();
        printDatabase();
    }

    /*public void startNewGameFromHighscores(View view){
        Intent new_game_intent = new Intent(this, CountdownForNewGame.class);
        startActivity(new_game_intent);
    }*/
}

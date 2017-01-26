package com.joeysapp.joseph.highscoresgame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CountdownForNewGame extends AppCompatActivity {

    public final static String USERNAME = "usernameKeySpeedClickerApp";

    private TextView countdownText;
    private Handler mHandler = new Handler();
    private EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_for_new_game);

        countdownText = (TextView)findViewById(R.id.countdownText);
        username = (EditText)findViewById(R.id.username);


    }

    public void StartGameButton(View view){
        countdownText.setText("Ready?");

        mHandler.postDelayed(new Runnable(){
            public void run(){
                countdownText.setText("Go!");
                delayIntent();
            }
        }, 3000);
    }

    public void delayIntent() {
        String username_to_save = username.getText().toString();
        Intent intent = new Intent(this, NewGame.class);
        intent.putExtra(USERNAME, username_to_save);
        startActivity(intent);     //opens activity to start a new game
    }
}

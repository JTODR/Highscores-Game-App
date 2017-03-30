package com.joeysapp.joseph.highscoresgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CountdownForNewGame extends AppCompatActivity {

    public final static String USERNAME = "usernameKeySpeedClickerApp";
    public final static String THE_TIMER_KEY = "finalSendingOfTimer";

    private TextView countdownText, timerSetText;
    //private Handler mHandler = new Handler();
    private EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_for_new_game);

        countdownText = (TextView)findViewById(R.id.countdownText);
        username = (EditText)findViewById(R.id.username);
        timerSetText = (TextView)findViewById(R.id.timerSetText);
        Intent received_intent = getIntent();
        String timer_length = received_intent.getStringExtra(MainActivity.TIMER_KEY);
        timerSetText.setText("Timer set to " + timer_length + " seconds");

    }

    public void StartGameButton(View view){     //an onClick method
        String username_given = username.getText().toString();

        if (username_given.matches("")){
            String no_username = "Please enter a username";
            Toast.makeText(CountdownForNewGame.this, no_username, Toast.LENGTH_LONG).show();
        }

        else {
            new CountDownTimer(4000, 1000) {
                public void onTick(long millisecUntilFinished) {

                    if (millisecUntilFinished < 4000) {      //Need a second of delay as at 3000, the countdown starts at 2 sec... so do at 4000ms and dont print if at 4000ms
                        countdownText.setText(String.valueOf(millisecUntilFinished / 1000));
                    }
                }

                public void onFinish() {
                    countdownText.setText("Go!");
                    delayIntent();
                }

            }.start();
        }
    }

    public void delayIntent() {
        Intent received_intent = getIntent();
        String timer_length = received_intent.getStringExtra(MainActivity.TIMER_KEY);

        if(timer_length.matches("")){
            timer_length = received_intent.getStringExtra(Highscores.TIMER_KEY_RESTART);
        }

        String username_to_save = username.getText().toString();

        Intent intent = new Intent(this, NewGame.class);

        intent.putExtra(USERNAME, username_to_save);    //sending along the username
        intent.putExtra(THE_TIMER_KEY, timer_length);   //sending along the desired timer length

        startActivity(intent);     //opens activity to start a new game
    }

    public void returnToMainMenu(View view){    //onClick to return to the main menu
        Intent main_menu_intent = new Intent(this, MainActivity.class);
        startActivity(main_menu_intent);
    }
}

package com.joeysapp.joseph.highscoresgame;


import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NewGame extends AppCompatActivity {

    public final static String HIGHSCORES_TIMER_KEY = "SendingOfTimerHighscores";

    //Intent received_intent = getIntent();
    //String USERNAME_GLOBAL = received_intent.getStringExtra(CountdownForNewGame.USERNAME);

    private ProgressBar progressBar;
    private Button startButton;
    private Button clickerButton;
    private TextView timer;
    private TextView scoreText;
    private TextView speedText;
    private TextView usernameTitleText;
    private Handler handler = new Handler();
    private RelativeLayout my_relative_layout;
    private int progressStatus = 0;
    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        startButton = (Button)findViewById(R.id.startButton);
        timer = (TextView)findViewById(R.id.timer);
        clickerButton = (Button)findViewById(R.id.clickerButton);
        my_relative_layout = (RelativeLayout)findViewById(R.id.my_relative_layout);
        speedText = (TextView)findViewById(R.id.speedText);
        usernameTitleText = (TextView)findViewById(R.id.usernameTitleText);

        dbHandler = new DBHandler(this, null, null, 1);

        Intent intent = getIntent();
        String saved_username = intent.getStringExtra(CountdownForNewGame.USERNAME);

        //Setting the length of the progress bar relative to the chosen time
        String length_of_bar = intent.getStringExtra(CountdownForNewGame.THE_TIMER_KEY);
        int length_of_bar_int = Integer.parseInt(length_of_bar);
        progressBar.setMax(length_of_bar_int);

        if(length_of_bar_int== 10){
            usernameTitleText.setText(dbHandler.databaseToString10());
        }
        else if(length_of_bar_int == 20){
            usernameTitleText.setText(dbHandler.databaseToString20());
        }
        else if(length_of_bar_int == 30){
            usernameTitleText.setText(dbHandler.databaseToString30());
        }
        else if(length_of_bar_int == 60){
            usernameTitleText.setText(dbHandler.databaseToString60());
        }


        runGame();
    }


    //When the red clicker button is clicked
    int score = 1;
    boolean restart_flag = false;       //used so that when the restart button is clicked, the red button can't be then clicked
    public void incrementScore(View view){

        Intent received_intent = getIntent();
        String desired_time = received_intent.getStringExtra(CountdownForNewGame.THE_TIMER_KEY);
        final int TIME = Integer.parseInt(desired_time);

        //If the timer hasnt run out, keep going
        if (progressStatus < TIME) {
            scoreText = (TextView) findViewById(R.id.scoreText);
            scoreText.setText(String.valueOf(score));       //Change the value of score for every click
            score = score + 1;
        }

        //else finish the game
        else{
            if(!restart_flag) {
                Intent intent_countdown = getIntent();
                String username_to_use = received_intent.getStringExtra(CountdownForNewGame.USERNAME);

                clickerButton.setEnabled(false);
                scoreText.setText("Final score: " + score);
                //String retreive_username_only = usernameTitleText.getText().toString();
                String highscore_text = String.valueOf(score) + " - " + username_to_use ;


                //********************* DB STUFF *********************
                HighscoreList highscoreList = new HighscoreList(highscore_text/*, String.valueOf(score)*/);
                if(TIME == 10) {

                    String old_highscore = dbHandler.databaseToString10();
                    String number_only = old_highscore.replaceAll("[^0-9]", "");
                    //usernameTitleText.setText(number_only);

                    int old_score = 0;
                    if (old_highscore.matches("")) {
                        old_score = 0;
                    } else {
                        number_only = old_highscore.replaceAll("[^0-9]", "");
                        old_score = Integer.parseInt(number_only);
                    }

                    if (score > old_score) {
                        dbHandler.deleteHighscores10();
                        usernameTitleText.setText("");
                        dbHandler.addHighscore10(highscoreList);
                        usernameTitleText.setText(score + "  -  " + username_to_use);

                        Toast.makeText(NewGame.this, "Highscore Added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(NewGame.this, "Not a new highscore, try again", Toast.LENGTH_SHORT).show();
                    }
                }

                if(TIME == 20) {

                    String old_highscore = dbHandler.databaseToString20();
                    String number_only = old_highscore.replaceAll("[^0-9]", "");
                    //usernameTitleText.setText(number_only);

                    int old_score = 0;
                    if (old_highscore.matches("")) {
                        old_score = 0;
                    } else {
                        number_only = old_highscore.replaceAll("[^0-9]", "");
                        old_score = Integer.parseInt(number_only);
                    }

                    if (score > old_score) {
                        dbHandler.deleteHighscores20();
                        usernameTitleText.setText("");
                        dbHandler.addHighscore20(highscoreList);
                        usernameTitleText.setText(score + "  -  " + username_to_use);

                        Toast.makeText(NewGame.this, "Highscore Added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(NewGame.this, "Not a new highscore, try again", Toast.LENGTH_SHORT).show();
                    }
                }
                if(TIME == 30) {

                    String old_highscore = dbHandler.databaseToString30();
                    String number_only = old_highscore.replaceAll("[^0-9]", "");
                    //usernameTitleText.setText(number_only);

                    int old_score = 0;
                    if (old_highscore.matches("")) {
                        old_score = 0;
                    } else {
                        number_only = old_highscore.replaceAll("[^0-9]", "");
                        old_score = Integer.parseInt(number_only);
                    }

                    if (score > old_score) {
                        dbHandler.deleteHighscores30();
                        usernameTitleText.setText("");
                        dbHandler.addHighscore30(highscoreList);
                        usernameTitleText.setText(score + "  -  " + username_to_use);

                        Toast.makeText(NewGame.this, "Highscore Added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(NewGame.this, "Not a new highscore, try again", Toast.LENGTH_SHORT).show();
                    }
                }
                if(TIME == 60) {

                    String old_highscore = dbHandler.databaseToString60();
                    String number_only = old_highscore.replaceAll("[^0-9]", "");
                    //usernameTitleText.setText(number_only);

                    int old_score = 0;
                    if (old_highscore.matches("")) {
                        old_score = 0;
                    } else {
                        number_only = old_highscore.replaceAll("[^0-9]", "");
                        old_score = Integer.parseInt(number_only);
                    }

                    if (score > old_score) {
                        dbHandler.deleteHighscores60();
                        usernameTitleText.setText("");
                        dbHandler.addHighscore60(highscoreList);
                        usernameTitleText.setText(score + "  -  " + username_to_use);

                        Toast.makeText(NewGame.this, "Highscore Added", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(NewGame.this, "Not a new highscore, try again", Toast.LENGTH_SHORT).show();
                    }
                }

                //****************************************************


                double remainder = score % TIME;
                double speed = score / TIME;
                speed = speed + (remainder / TIME);
                speedText.setText(String.valueOf(speed) + " clicks/ sec");
            }
        }
    }

    //The running of the game is here
    public void runGame(){
        clickerButton.setEnabled(true);
        Intent received_intent = getIntent();
        String desired_time = received_intent.getStringExtra(CountdownForNewGame.THE_TIMER_KEY);
        final int TIME = Integer.parseInt(desired_time);

        progressStatus = 0;

        new Thread(new Runnable(){      //Need to set up a new thread as the progress bar shouldnt run from the interface, it has its on seperate thread
            public void run(){
                while(progressStatus < TIME){     //60 seconds
                    progressStatus += 1;    //increment progress by 1
                    handler.post(new Runnable() {   //Handler sends the progress bar the information that we need to update
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            timer.setText("Time: " + progressStatus);
                        }
                    });
                    try{
                        //sleep every 1000 milli seconds
                        Thread.sleep(1000); //This will try and sleep the thread we're currently on, ie. the one running the progress bar
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();    //lazy way of sorting out errors from try command
                    }
                }
            }
        }).start();


    }

    //Return to main menu
    public void goToMainMenu(View view){
        Intent menu_intent = new Intent(this, MainActivity.class);
        startActivity(menu_intent);
    }

    //Go to highscores
    public void viewHighscores(View view){
        Intent received_intent = getIntent();
        String desired_time = received_intent.getStringExtra(CountdownForNewGame.THE_TIMER_KEY);
        final int TIME = Integer.parseInt(desired_time);

        Intent highscores_intent = new Intent(this, Highscores.class);
        highscores_intent.putExtra(HIGHSCORES_TIMER_KEY, TIME);

        startActivity(highscores_intent);
    }

    //restart the game when the restart button is clicked
    public void restartGame(View view){
        restart_flag = true;
        progressStatus = 10;

        startButton.setEnabled(false);      //so the restart button cannot be spammed.. This caused a bug in the timer

        new CountDownTimer(4000, 1000){     //prints a countdown of 3,2,1... have it at 4000ms to give it time to reset
            public void onTick(long millisecUntilFinished){
                timer.setText("Ready?");
                speedText.setText("");

                if(millisecUntilFinished < 4000) {      //Need a second of delay as at 3000, the countdown starts at 2 sec... so do at 4000ms and dont print if at 4000ms
                    scoreText.setText(String.valueOf(millisecUntilFinished / 1000));
                }
            }
            public void onFinish(){
                score = 1;
                speedText.setText("");
                restart_flag = false;
                startButton.setEnabled(true);      //re-enabling the restart button just before running the game again
                runGame();
            }

        }.start();

    }
}

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

public class NewGame extends AppCompatActivity {

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

    final int TIME = 10;

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
        usernameTitleText.setText(saved_username);

        runGame();

    }


    //When the red clicker button is clicked
    int score = 1;
    boolean restart_flag = false;       //used so that when the restart button is clicked, the red button can't be then clicked
    public void incrementScore(View view){
        if (progressStatus < TIME) {
            scoreText = (TextView) findViewById(R.id.scoreText);
            scoreText.setText(String.valueOf(score));       //Change the value of score for every click
            score = score + 1;
        }
        else{
            if(!restart_flag) {
                scoreText.setText("Final score: " + score);
                String retreive_username = usernameTitleText.getText().toString();
                retreive_username = retreive_username + " - " + String.valueOf(score);
                //********************* DB STUFF *********************
                HighscoreList highscoreList = new HighscoreList(retreive_username/*, String.valueOf(score)*/);
                dbHandler.addHighscore(highscoreList);
                //****************************************************

                //double double_score = score;
                double remainder = score % TIME;
                double speed = score / TIME;
                speed = speed + (remainder / TIME);
                speedText.setText(String.valueOf(speed) + " clicks/ sec");
            }
        }
    }

    //restart the game when the restart button is clicked
    public void restartGame(View view){
        restart_flag = true;
        progressStatus = 10;
        new CountDownTimer(3000, 1000){
            public void onTick(long millisecUntilFinished){
                timer.setText("Ready?");
            }
            public void onFinish(){
                //timer.setText("Go!");
                score = 1;
                speedText.setText("");
                restart_flag = false;
                runGame();
            }

        }.start();

    }

    //Go to highscores
    public void viewHighscores(View view){
        Intent highscores_intent = new Intent(this, Highscores.class);
        startActivity(highscores_intent);
    }

    //The running of the game is here
    public void runGame(){
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

    /*public void addButtonClicked(View view){
        HighscoreList highscoreList = new HighscoreList(saved_username, score);
        dbHandler.addHighscore(highscoreList);
        //printDatabase();
    }*/


}

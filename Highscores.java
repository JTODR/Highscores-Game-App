package com.joeysapp.joseph.highscoresgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Highscores extends AppCompatActivity {

    public final static String TIMER_KEY_RESTART = "keyhighscorestimer";

    DBHandler dbHandler;
    Button deleteHighscoresButton;
    Button newGameButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);

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
        String dbString10 = dbHandler.databaseToString10();
        dbString10 = "10 sec:       " + dbString10;

        String dbString20 = dbHandler.databaseToString20();
        dbString20 = "20 sec:       " + dbString20;

        String dbString30 = dbHandler.databaseToString30();
        dbString30 = "30 sec:       " + dbString30;

        String dbString60 = dbHandler.databaseToString60();
        dbString60 = "60 sec:       " + dbString60;

        //ListView
        String[] highscores_list= {dbString10, dbString20, dbString30, dbString60};
        ListAdapter joeysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, highscores_list);
        ListView joeysListView = (ListView) findViewById(R.id.joeysListView);
        joeysListView.setAdapter(joeysAdapter);
    }

    public void deleteBtnClicked(View view){
        dbHandler.deleteHighscores10();
        dbHandler.deleteHighscores20();
        dbHandler.deleteHighscores30();
        dbHandler.deleteHighscores60();
        printDatabase();
    }

}

package com.joeysapp.joseph.highscoresgame;


import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "highscoresDB.db";
    public static final String TABLE_HIGHSCORES = "highscores";

    public static final String COLUMN_USERNAME = "username";
    //public static final String COLUMN_RANK = "rank";
    public static final String COLUMN_SCORE = "score";

    //We need to pass database information along to superclass
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_HIGHSCORES + "(" +
                //COLUMN_RANK + " INTEGER PRIMARY KEY " +
                COLUMN_USERNAME + " TEXT PRIMARY KEY " +
                COLUMN_SCORE + " INTEGER " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORES);
        onCreate(db);
    }

    //Add a new row to the database
    public void addHighscore(HighscoreList highscoreList){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, highscoreList.get_username());
        //values.put(COLUMN_RANK, highscoreList.get_rank());
        //values.put(COLUMN_SCORE, highscoreList.get_score());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_HIGHSCORES, null, values);
        db.close();
    }

    //Delete a highscore from the database
    public void deleteHighscores(){
        SQLiteDatabase db = getWritableDatabase();
        //db.execSQL("DELETE FROM " + TABLE_HIGHSCORES + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\";");
        db.delete(TABLE_HIGHSCORES,null,null);
        db.close();
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_HIGHSCORES + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("username")) != null) {
                dbString += c.getString(c.getColumnIndex("username"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    /*public String scoreToString() {
        String dbStringScore = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_HIGHSCORES + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("username")) != null) {
                dbStringScore += c.getInt(c.getColumnIndex("score"));
                dbStringScore += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbStringScore;
    }*/


}

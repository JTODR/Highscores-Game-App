package com.joeysapp.joseph.highscoresgame;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "highscoresDB.db";
    public static final String TABLE_HIGHSCORES_10 = "highscores10";
    public static final String TABLE_HIGHSCORES_20 = "highscores20";
    public static final String TABLE_HIGHSCORES_30 = "highscores30";
    public static final String TABLE_HIGHSCORES_60 = "highscores60";


    public static final String COLUMN_USERNAME_10 = "username10";
    public static final String COLUMN_USERNAME_20 = "username20";
    public static final String COLUMN_USERNAME_30 = "username30";
    public static final String COLUMN_USERNAME_60 = "username60";
    //public static final String COLUMN_RANK = "rank";
    //public static final String COLUMN_SCORE = "score";

    //We need to pass database information along to superclass
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query10 = "CREATE TABLE " + TABLE_HIGHSCORES_10 + "(" +
                //COLUMN_RANK + " INTEGER PRIMARY KEY " +
                COLUMN_USERNAME_10 + " TEXT PRIMARY KEY " +
                //COLUMN_SCORE + " INTEGER " +
                ");";
        db.execSQL(query10);

        String query20 = "CREATE TABLE " + TABLE_HIGHSCORES_20 + "(" +
                //COLUMN_RANK + " INTEGER PRIMARY KEY " +
                COLUMN_USERNAME_20 + " TEXT PRIMARY KEY " +
                //COLUMN_SCORE + " INTEGER " +
                ");";
        db.execSQL(query20);

        String query30 = "CREATE TABLE " + TABLE_HIGHSCORES_30 + "(" +
                //COLUMN_RANK + " INTEGER PRIMARY KEY " +
                COLUMN_USERNAME_30 + " TEXT PRIMARY KEY " +
                //COLUMN_SCORE + " INTEGER " +
                ");";
        db.execSQL(query30);

        String query60 = "CREATE TABLE " + TABLE_HIGHSCORES_60 + "(" +
                //COLUMN_RANK + " INTEGER PRIMARY KEY " +
                COLUMN_USERNAME_60 + " TEXT PRIMARY KEY " +
                //COLUMN_SCORE + " INTEGER " +
                ");";
        db.execSQL(query60);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORES_10);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORES_20);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORES_30);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HIGHSCORES_60);
        onCreate(db);
    }

    //Add a new row to the database
    public void addHighscore10(HighscoreList highscoreList){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME_10, highscoreList.get_username());
        //values.put(COLUMN_RANK, highscoreList.get_rank());
        //values.put(COLUMN_SCORE, highscoreList.get_score());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_HIGHSCORES_10, null, values);
        db.close();
    }

    public void addHighscore20(HighscoreList highscoreList){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME_20, highscoreList.get_username());
        //values.put(COLUMN_RANK, highscoreList.get_rank());
        //values.put(COLUMN_SCORE, highscoreList.get_score());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_HIGHSCORES_20, null, values);
        db.close();
    }

    public void addHighscore30(HighscoreList highscoreList){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME_30, highscoreList.get_username());
        //values.put(COLUMN_RANK, highscoreList.get_rank());
        //values.put(COLUMN_SCORE, highscoreList.get_score());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_HIGHSCORES_30, null, values);
        db.close();
    }

    public void addHighscore60(HighscoreList highscoreList){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME_60, highscoreList.get_username());
        //values.put(COLUMN_RANK, highscoreList.get_rank());
        //values.put(COLUMN_SCORE, highscoreList.get_score());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_HIGHSCORES_60, null, values);
        db.close();
    }

    //Delete a highscore from the database
    public void deleteHighscores10(){
        SQLiteDatabase db = getWritableDatabase();
        //db.execSQL("DELETE FROM " + TABLE_HIGHSCORES + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\";");
        db.delete(TABLE_HIGHSCORES_10,null,null);
        db.close();
    }
    public void deleteHighscores20(){
        SQLiteDatabase db = getWritableDatabase();
        //db.execSQL("DELETE FROM " + TABLE_HIGHSCORES + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\";");
        db.delete(TABLE_HIGHSCORES_20,null,null);
        db.close();
    }
    public void deleteHighscores30(){
        SQLiteDatabase db = getWritableDatabase();
        //db.execSQL("DELETE FROM " + TABLE_HIGHSCORES + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\";");
        db.delete(TABLE_HIGHSCORES_30,null,null);
        db.close();
    }
    public void deleteHighscores60(){
        SQLiteDatabase db = getWritableDatabase();
        //db.execSQL("DELETE FROM " + TABLE_HIGHSCORES + " WHERE " + COLUMN_USERNAME + "=\"" + username + "\";");
        db.delete(TABLE_HIGHSCORES_60,null,null);
        db.close();
    }

    public String databaseToString10(){
        String dbString = "";
        //String number_string = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_HIGHSCORES_10 + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("username10")) != null) {
                dbString += c.getString(c.getColumnIndex("username10"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    public String databaseToString20(){
        String dbString = "";
        String number_string = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_HIGHSCORES_20 + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("username20")) != null) {
                dbString += c.getString(c.getColumnIndex("username20"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    public String databaseToString30(){
        String dbString = "";
        String number_string = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_HIGHSCORES_30 + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("username30")) != null) {
                dbString += c.getString(c.getColumnIndex("username30"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    public String databaseToString60(){
        String dbString = "";
        String number_string = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_HIGHSCORES_60 + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("username60")) != null) {
                dbString += c.getString(c.getColumnIndex("username60"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }


}

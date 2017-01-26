package com.joeysapp.joseph.highscoresgame;

public class HighscoreList {

    //private int _rank;
    private String _username;
    //private String _score;

    public HighscoreList(){
    }

    public HighscoreList(String username/*, int rank , String score*/){
        this._username = username;
        //this._rank = rank;
        //this._score = score;
    }




    //Getter and setter for username
    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_username() {
        return _username;
    }




    //Getter and setter for rank
    /*public void set_rank(int _rank) {
        this._rank = _rank;
    }

    public int get_rank() {
        return _rank;
    }




    //Getter and setter for score
    public void set_score(String _score) {
        this._score = _score;
    }

    public String get_score() {
        return _score;
    }*/


}

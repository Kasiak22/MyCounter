package com.example.android.mycounter;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreA;
    int scoreB;
    int setA;
    int setB;
    TextView scoreView_a;
    TextView scoreView_b;
    TextView setView_b;
    TextView setView_a;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreA", scoreA);
        outState.putInt("scoreB", scoreB);
        outState.putInt("setA", setA);
        outState.putInt("setB", setB);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Warning:(39, 24) Casting 'findViewById(R.id.team_a_score)' to 'TextView' is redundant
        scoreView_a= findViewById(R.id.team_a_score);
        scoreView_b = findViewById(R.id.team_b_score);
        setView_a = findViewById(R.id.team_a_set);
        setView_b = findViewById(R.id.team_b_set);


        if (savedInstanceState != null && savedInstanceState.containsKey("scoreA")) {
            scoreA = savedInstanceState.getInt("scoreA");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("scoreB")) {
            scoreB = savedInstanceState.getInt("scoreB");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("setA")) {
            setA = savedInstanceState.getInt("setA");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("setB")) {
            setB = savedInstanceState.getInt("setB");
        }

        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
        displaySetTeamA(setA);
        displaySetTeamB(setB);
    }


    public void in(View view) {
        scoreA = scoreA + 1;
        winSet(scoreA);
    }

    public void out(View view) {
        scoreB = scoreB + 1;
        winSet(scoreB);
    }

    public void let(View view) {
        winSet(scoreA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {

        scoreView_a.setText(String.valueOf(scoreA));
    }

    public void displaySetTeamA(int set) {
        setView_a.setText(String.valueOf(setA));
    }

    public void inB(View view) {
        scoreB = scoreB + 1;
        winSet(scoreB);
    }

    public void outB(View view) {
        scoreA = scoreA + 1;
        winSet(scoreA);
    }

    public void letB(View view) {
        winSet(scoreB);
    }

    public void displayForTeamB(int score) {
        scoreView_b.setText(String.valueOf(scoreB));
    }

    public void displaySetTeamB(int set) {
        setView_b.setText(String.valueOf(setB));
    }

    public void winSet(int score) {
        if (scoreA == 11) {
            setA = setA + 1;
            scoreB = 0;
            scoreA = 0;
            displaySetTeamA(setA);
            Toast.makeText(this, "Set for Player A", Toast.LENGTH_LONG).show();
        }
        if (scoreB == 11) {
            setB = setB + 1;
            scoreB = 0;
            scoreA = 0;
            displaySetTeamB(setB);
            Toast.makeText(this, "Set for Player B", Toast.LENGTH_LONG).show();

        }
        if (setB + setA == 3) {
            Toast.makeText(this, "Match set!", Toast.LENGTH_LONG).show();
        }
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    public void resetSet(View view) {
        setA = 0;
        setB = 0;
        displaySetTeamA(setA);
        displaySetTeamB(setB);
    }

    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        setA = 0;
        setB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
        displaySetTeamA(setA);
        displaySetTeamB(setB);
    }

}

package com.example.android.mycounter;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreA));
    }

    public void displaySetTeamA(int set) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_set);
        scoreView.setText(String.valueOf(setA));
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
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreB));
    }

    public void displaySetTeamB(int set) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_set);
        scoreView.setText(String.valueOf(setB));

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

package com.xencosworks.kentkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int firstTeamScore = 0;
    int secondTeamScore = 0;

    int firstTeamWinCounter = 0;
    int firstTeamLossCounter = 0;

    int secondTeamWinCounter = 0;
    int secondTeamLossCounter = 0;

    Button successfulKent1;
    Button successfulStop1;
    Button foul1;

    Button successfulKent2;
    Button successfulStop2;
    Button foul2;

    Button newGame;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        successfulKent1 = findViewById(R.id.successful_kent_first);
        successfulKent1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(2, 1);
                counter(1, true);
                displayNewScore(firstTeamScore, 1);
            }
        });
        successfulStop1 = findViewById(R.id.successful_stop_first);
        successfulStop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(1, 1);
                counter(1, true);
                displayNewScore(firstTeamScore, 1);
            }
        });
        foul1 = findViewById(R.id.foul_first);
        foul1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(-1, 1);
                counter(1, false);
                displayNewScore(firstTeamScore, 1);
            }
        });


        successfulKent2 = findViewById(R.id.successful_kent_second);
        successfulKent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(2, 2);
                counter(2, true);
                displayNewScore(secondTeamScore, 2);
            }
        });
        successfulStop2 = findViewById(R.id.successful_stop_second);
        successfulStop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(1, 2);
                counter(2, true);
                displayNewScore(secondTeamScore, 2);
            }
        });
        foul2 = findViewById(R.id.foul_second);
        foul2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateScore(-1, 2);
                counter(2, false);
                displayNewScore(secondTeamScore, 2);
            }
        });

        newGame = findViewById(R.id.button_reset);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetScore();
                displayNewScore(firstTeamScore, 1);
                displayNewScore(secondTeamScore, 2);
            }
        });
    }

    public void displayNewScore(int toBeDisplayedScore, int team) {
        if (team == 1) {
            ((TextView) findViewById(R.id.first_team_score)).setText(String.valueOf(toBeDisplayedScore));
            ((TextView) findViewById(R.id.first_team_total_win)).setText(String.valueOf(firstTeamWinCounter));
            ((TextView) findViewById(R.id.first_team_total_loss)).setText(String.valueOf(firstTeamLossCounter));
        } else if (team == 2) {
            ((TextView) findViewById(R.id.second_team_score)).setText(String.valueOf(toBeDisplayedScore));
            ((TextView) findViewById(R.id.second_team_total_win)).setText(String.valueOf(secondTeamWinCounter));
            ((TextView) findViewById(R.id.second_team_total_loss)).setText(String.valueOf(secondTeamLossCounter));
        }
    }

    public void updateScore(int addedValue, int team) {
        if (team == 1) {
            firstTeamScore += addedValue;
        } else if (team == 2) {
            secondTeamScore += addedValue;
        }
    }

    public void resetScore() {
        firstTeamScore = 0;
        firstTeamWinCounter = 0;
        firstTeamLossCounter = 0;

        secondTeamScore = 0;
        secondTeamWinCounter = 0;
        secondTeamLossCounter = 0;
    }

    public void counter(int team, boolean win) {
        if (team == 1) {
            if (win) {
                firstTeamWinCounter += 1;
            } else {
                firstTeamLossCounter += 1;
            }
        } else if (team == 2) {
            if (win) {
                secondTeamWinCounter += 1;
            } else {
                secondTeamLossCounter += 1;
            }
        }
    }
}

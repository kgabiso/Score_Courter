package com.example.codetribe.scorecourter;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView scoreViewA, scoreViewB;
    Button points_3, point_2, free_throw, Reset;
    Button points_B_3, point_B_2, free_throw_B;
    int ScoreTeamA = 0;
    int ScoreTeamB = 0;
    Handler ScoreHandler = new Handler();
    int points_3_click, points_2_click, free_throw_click;
    int points_3_Bclick, point_2_Bclick, free_throw_Bclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        point_2 = (Button) findViewById(R.id.points2);
        points_3 = (Button) findViewById(R.id.points3);
        free_throw = (Button) findViewById(R.id.freeThrow);

        point_B_2 = (Button) findViewById(R.id.pointsB2);
        points_B_3 = (Button) findViewById(R.id.pointsB3);
        free_throw_B = (Button) findViewById(R.id.freeThrowB);

        Reset = (Button) findViewById(R.id.resetButton);
        //Click events Team A
        points_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                points_3_click++;
                points_3.setText("+3 point (" + points_3_click + ")");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        displayForTeamA(3);

                    }
                };
                new Thread(runnable).start();

            }

        });

        point_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points_2_click++;
                point_2.setText("+2 point (" + points_2_click + ")");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        displayForTeamA(2);
                    }
                };
                new Thread(runnable).start();

            }

        });
        free_throw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                free_throw_click++;
                free_throw.setText("Free Throw (" + free_throw_click + ")");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        displayForTeamA(1);
                    }
                };
                new Thread(runnable).start();


            }
        });
        //Click event Team B
        point_B_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                point_2_Bclick++;
                point_B_2.setText("+2 point (" + point_2_Bclick + ")");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        displayForTeamB(2);
                    }
                };
                new Thread(runnable).start();
            }
        });
        points_B_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points_3_Bclick++;
                points_B_3.setText("+2 point (" + points_3_Bclick + ")");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        displayForTeamB(3);
                    }
                };
                new Thread(runnable).start();
            }
        });
        free_throw_B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                free_throw_Bclick++;
                free_throw_B.setText("Free Throw (" + free_throw_Bclick + ")");
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        displayForTeamB(1);
                    }
                };
                new Thread(runnable).start();
            }
        });
        //Click event Reset
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points_3_click = 0;
                points_2_click = 0;
                free_throw_click = 0;
                points_3_Bclick = 0;
                point_2_Bclick = 0;
                free_throw_Bclick = 0;
                ScoreTeamA = 0;
                ScoreTeamB = 0;
                points_3.setText("+3 point (" + points_3_click + ")");
                point_2.setText("+2 point (" + points_2_click + ")");
                free_throw.setText("Free Throw (" + free_throw_click + ")");
                point_B_2.setText("+2 point (" + point_2_Bclick + ")");
                points_B_3.setText("+2 point (" + points_3_Bclick + ")");
                free_throw_B.setText("Free Throw (" + free_throw_Bclick + ")");
                displayForTeamA(ScoreTeamA);
                displayForTeamB(ScoreTeamB);
            }
        });
    }

    public void displayForTeamA(final int sore) {
        for (int x = 0; x < 5; x++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ScoreHandler.post(new Runnable() {
                @Override
                public void run() {
                    scoreViewA = (TextView) findViewById(R.id.score_A);
                    ScoreTeamA = ScoreTeamA + sore;
                    scoreViewA.setText(String.valueOf(ScoreTeamA / 5));
                }
            });

        }
    }

    public void displayForTeamB(final int sore) {
        for (int x = 0; x < 5; x++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ScoreHandler.post(new Runnable() {
                @Override
                public void run() {
                    scoreViewB = (TextView) findViewById(R.id.score_B);
                    ScoreTeamB = ScoreTeamB + sore;
                    scoreViewB.setText(String.valueOf(ScoreTeamB / 5));
                }
            });

        }
    }


}

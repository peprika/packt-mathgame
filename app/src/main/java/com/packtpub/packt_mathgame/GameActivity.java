package com.packtpub.packt_mathgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Riku Pepponen on 12.6.2017.
 * (riku.pepponen@gmail.com)
 */

public class GameActivity extends Activity implements View.OnClickListener {

    // Some basic declarations
    Button buttonObjectChoice1;
    Button buttonObjectChoice2;
    Button buttonObjectChoice3;
    TextView textObjectPartA;
    TextView textObjectPartB;
    TextView textObjectOperator;
    TextView textObjectScore;
    TextView textObjectLevel;

    int correctAnswer;
    int answerGiven;
    int currentScore = 0;
    int currentLevel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Variable declarations
        int partA = 9;
        int partB = 9;
        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;

        // UI element declarations
        textObjectPartA = (TextView)findViewById(R.id.textPartA);
        textObjectPartB = (TextView)findViewById(R.id.textPartB);
        textObjectOperator = (TextView)findViewById(R.id.textOperator);
        buttonObjectChoice1 = (Button)findViewById(R.id.buttonChoice1);
        buttonObjectChoice2 = (Button)findViewById(R.id.buttonChoice2);
        buttonObjectChoice3 = (Button)findViewById(R.id.buttonChoice3);
        textObjectScore = (TextView)findViewById(R.id.textScore);
        textObjectLevel = (TextView)findViewById(R.id.textLevel);

        // Set the UI elements' texts
        textObjectPartA.setText("" + partA);
        textObjectPartB.setText("" + partB);
        textObjectOperator.setText("*");

        buttonObjectChoice1.setText("" + correctAnswer);
        buttonObjectChoice2.setText("" + wrongAnswer1);
        buttonObjectChoice3.setText("" + wrongAnswer2);

        // Set some listeners
        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // Which button did the user click?
        switch (view.getId()) {
            case R.id.buttonChoice1:
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
                checkAnswer();
                break;

            case R.id.buttonChoice2:
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
                checkAnswer();
                break;

            case R.id.buttonChoice3:
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
                checkAnswer();
                break;
        }
    }

    // Check if it's the correct answer and show a toast
    public void checkAnswer() {
        if(answerGiven == correctAnswer) {
            Toast.makeText(getApplicationContext(),
                    "Well done!",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),
                    "Sorry, that's wrong",
                    Toast.LENGTH_LONG).show();
        }
    }
}
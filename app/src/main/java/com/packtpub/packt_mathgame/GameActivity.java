package com.packtpub.packt_mathgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

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
    boolean correctTrueOrFalse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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
        textObjectOperator.setText("*");
        textObjectScore.setText(getResources().getString(R.string.score) + " " + currentScore);
        textObjectLevel.setText(getResources().getString(R.string.level) + " " + currentLevel);

        // Set some listeners
        buttonObjectChoice1.setOnClickListener(this);
        buttonObjectChoice2.setOnClickListener(this);
        buttonObjectChoice3.setOnClickListener(this);

        // Give the user their first question
        setQuestion();
    }

    @Override
    public void onClick(View view) {

        // Which button did the user click?
        switch (view.getId()) {
            case R.id.buttonChoice1:
                answerGiven = Integer.parseInt("" + buttonObjectChoice1.getText());
                break;

            case R.id.buttonChoice2:
                answerGiven = Integer.parseInt("" + buttonObjectChoice2.getText());
                break;

            case R.id.buttonChoice3:
                answerGiven = Integer.parseInt("" + buttonObjectChoice3.getText());
                break;
        }

        // On every click:
        // Check the answer, update score/level, give the user a new question
        checkAnswer(answerGiven);
        updateScoreAndLevel(answerGiven);
        setQuestion();
    }

    // Check if it's the correct answer and show a toast
    public boolean checkAnswer(int answerGiven) {
        if(answerGiven == correctAnswer) {
            Toast.makeText(getApplicationContext(),
                    "Well done!",
                    Toast.LENGTH_LONG).show();
                    correctTrueOrFalse = true;
        } else {
            Toast.makeText(getApplicationContext(),
                    "Sorry, that's wrong",
                    Toast.LENGTH_LONG).show();
                    correctTrueOrFalse = false;
        }
        return correctTrueOrFalse;
    }

    private void setQuestion () {
        // Difficulty increases with level
        int numberRange = currentLevel * 3;

        // Get numbers for the question
        Random randInt = new Random();
        int partA = randInt.nextInt(numberRange);
        partA++; // no zero values
        int partB = randInt.nextInt(numberRange);
        partB++; // no zero values

        correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 2;
        int wrongAnswer2 = correctAnswer + 2;

        // Set the textview texts
        textObjectPartA.setText(""+partA);
        textObjectPartB.setText(""+partB);

        // Set the order for the correct/incorrect answer options shown
        int buttonLayout = randInt.nextInt(3);
        switch (buttonLayout) {

            case 0:
                buttonObjectChoice1.setText(""+correctAnswer);
                buttonObjectChoice2.setText(""+wrongAnswer1);
                buttonObjectChoice3.setText(""+wrongAnswer2);
                break;

            case 1:
                buttonObjectChoice2.setText(""+correctAnswer);
                buttonObjectChoice3.setText(""+wrongAnswer1);
                buttonObjectChoice1.setText(""+wrongAnswer2);
                break;

            case 2:
                buttonObjectChoice3.setText(""+correctAnswer);
                buttonObjectChoice1.setText(""+wrongAnswer1);
                buttonObjectChoice2.setText(""+wrongAnswer2);
                break;
        }
    }

    private void updateScoreAndLevel(int answerGiven) {
        // If the answer is correct, increase score
        // If the answer is incorrect, set score to 0 and level to 1;
        if(checkAnswer(answerGiven)) {
            for(int i = 0; i <= currentLevel; i++) {
                currentScore = currentScore + i;
            }
            currentLevel++;
        } else {
            currentScore = 0;
            currentLevel = 1;
        }

        // Update the textviews
        textObjectScore.setText(getResources().getString(R.string.score) + " " + currentScore);
        textObjectLevel.setText(getResources().getString(R.string.level) + " " + currentLevel);
    }
}
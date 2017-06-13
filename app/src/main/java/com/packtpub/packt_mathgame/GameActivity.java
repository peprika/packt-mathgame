package com.packtpub.packt_mathgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Riku Pepponen on 12.6.2017.
 * (riku.pepponen@gmail.com)
 */

public class GameActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Variable declarations
        int partA = 9;
        int partB = 9;
        int correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;

        // UI element declarations
        TextView textObjectPartA = (TextView)findViewById(R.id.textPartA);
        TextView textObjectPartB = (TextView)findViewById(R.id.textPartB);
        TextView textObjectOperator = (TextView)findViewById(R.id.textOperator);
        Button buttonObjectChoice1 = (Button)findViewById(R.id.buttonChoice1);
        Button buttonObjectChoice2 = (Button)findViewById(R.id.buttonChoice2);
        Button buttonObjectChoice3 = (Button)findViewById(R.id.buttonChoice3);

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
        switch (view.getId()) {
            case R.id.buttonChoice1:
                // Button 1 stuff goes here
                break;

            case R.id.buttonChoice2:
                // Button 2 stuff goes here
                break;

            case R.id.buttonChoice3:
                // Button 3 stuff goes here
                break;
        }
    }
}
package com.packtpub.packt_mathgame;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Riku Pepponen on 12.6.2017.
 * (riku.pepponen@gmail.com)
 */

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        int partA = 9;
        int partB = 9;
        int correctAnswer = partA * partB;
        int wrongAnswer1 = correctAnswer - 1;
        int wrongAnswer2 = correctAnswer + 1;
        
    }
}
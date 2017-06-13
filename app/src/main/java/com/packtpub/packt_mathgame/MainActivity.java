package com.packtpub.packt_mathgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    // Button declarations
    Button newGameButton;
    Button highScoresButton;
    Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting the buttons
        newGameButton = (Button)findViewById(R.id.new_game_button);
        highScoresButton= (Button)findViewById(R.id.highscore_button);
        quitButton = (Button)findViewById(R.id.quit_button);

        // Button listeners
        newGameButton.setOnClickListener(this);
        highScoresButton.setOnClickListener(this);
        quitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Which button did the user click?
        switch (view.getId()) {
            // New Game
            case R.id.new_game_button:
                Intent i;
                i = new Intent(this, GameActivity.class);
                startActivity(i);
                break;

            // High scores
            case R.id.highscore_button:
                // TODO: Highscores
                break;

            // Quit the app
            case R.id.quit_button:
                System.exit(1);
        }
    }
}
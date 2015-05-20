package com.yjsoon.jokes;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    int mJokeNumber = 0; // start counting from 0 when coding!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView jokeQuestionText = (TextView) findViewById(R.id.joke_question_text);
        final Button showPunchlineButton = (Button) findViewById(R.id.show_punchline_button);
        final TextView punchlineText = (TextView) findViewById(R.id.punchline_text);
        final Button showNextJokeButton = (Button) findViewById(R.id.show_next_joke_button);

        jokeQuestionText.setText("Dad, did you get a haircut?");
        punchlineText.setText("No, I got them all cut.");

        showPunchlineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                punchlineText.setVisibility(View.VISIBLE);
                showNextJokeButton.setVisibility(View.VISIBLE);
            }
        });

        showNextJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("YJ", "Show next joke!!!");

                mJokeNumber++; // this increments (increases by 1) the joke number

                if (mJokeNumber == 1) { // show joke 1!
                    jokeQuestionText.setText("Why couldn't the bicycle stand by itself?");
                    punchlineText.setText("Because it was two tired!");
                } else if (mJokeNumber == 2) { // show joke 2
                    jokeQuestionText.setText("What do you call cheese that isn't yours?");
                    punchlineText.setText("Nacho cheese!");
                } else { // there are no more jokes :(
                    jokeQuestionText.setText("There are no more jokes.");
                    punchlineText.setText("Life is sad.");
                }

                punchlineText.setVisibility(View.INVISIBLE);
                showNextJokeButton.setVisibility(View.INVISIBLE);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.darshilpatel.numbergame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    public void checkGuess (View view){
        EditText guessedNumber = (EditText) findViewById(R.id.guessedNumber);

        String guessedNumberString = guessedNumber.getText().toString();
        int convertedNumber = Integer.parseInt(guessedNumberString);
        String userMessage = "";

        if (guessedNumber.getText().toString().isEmpty()){
            userMessage ="Enter a number";
        }
        else if (convertedNumber > randomNumber){
           userMessage = "Too high";
        } else if (convertedNumber < randomNumber){
           userMessage = "Too low";
        } else {
            userMessage = "Correct!";
            Random randomGenerator = new Random();
            randomNumber = randomGenerator.nextInt(21);

        }

        Toast.makeText(getApplicationContext(), userMessage , Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Random randomGenerator = new Random();
        randomNumber = randomGenerator.nextInt(21);

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

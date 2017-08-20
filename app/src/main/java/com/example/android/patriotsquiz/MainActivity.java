package com.example.android.patriotsquiz;

import android.content.Context;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method will calculate tally the correct answers and display a toast
     */
    public void submitTest(View view) {
        // Question #1
        RadioButton superBowlTotal = (RadioButton) findViewById(R.id.five_super_bowls);
        boolean superBowlFive = superBowlTotal.isChecked();

        // Question #2
        RadioButton schoolForBill = (RadioButton) findViewById(R.id.school_wesleyan);
        boolean billBelichick = schoolForBill.isChecked();

        // Question #3
        CheckBox superBowlJulianEdelman = (CheckBox) findViewById(R.id.player_edelman);
        boolean julianEdelman = superBowlJulianEdelman.isChecked();
        CheckBox superBowlRobGronkowski = (CheckBox) findViewById(R.id.player_gronkowski);
        boolean robGronkowski = superBowlRobGronkowski.isChecked();
        CheckBox superBowlMalcolmButler = (CheckBox) findViewById(R.id.player_butler);
        boolean malcolmButler = superBowlMalcolmButler.isChecked();

        // Question #4
        EditText theGoatAnswer = (EditText) findViewById(R.id.goat_tom_brady);
        String tomBradyQuestion = theGoatAnswer.getText().toString();

        // Toast
        Context context = getApplicationContext();
        CharSequence text = calculateScore(superBowlFive, billBelichick, julianEdelman, robGronkowski, malcolmButler, tomBradyQuestion);
        int duration = Toast.LENGTH_LONG;
        Toast toastSubmit = Toast.makeText(context, text, duration);
        toastSubmit.show();
    }

    /**
     * This method will calculate the score and create a string to be displayed in the toast upon submission
     */
    public String calculateScore(boolean superBowlFive, boolean billBelichick, boolean julianEdelman, boolean robGronkowski, boolean malcolmButler, String tomBradyQuestion) {
        int questionSuperBowlTotal = 0;
        int questionBillBelichick = 0;
        int questionSuperBowlPlayers = 0;
        int questionTheGoat = 0;

        if(superBowlFive) {
            questionSuperBowlTotal = 1;
        }

        if(billBelichick) {
            questionBillBelichick = 1;
        }

        if(julianEdelman) {
            if(robGronkowski) {
                if(malcolmButler) {
                    questionSuperBowlPlayers = 1;
                }
            }
        }

        if(tomBradyQuestion.equalsIgnoreCase("Tom Brady")) {
            questionTheGoat = 1;
        }

        int totalScore = questionSuperBowlTotal + questionBillBelichick + questionSuperBowlPlayers + questionTheGoat;
        String scoreComment = totalScore + " of 4 correct!";

        if (totalScore == 0) {
            scoreComment += "\nWhat's a football???";
        }
        if (totalScore == 1) {
            scoreComment += "\nmore luck than skill?";
        }
        if (totalScore == 2) {
            scoreComment += "\nRight down the middle!";
        }
        if (totalScore == 3) {
            scoreComment += "\nNice job!  But no Tom Brady...";
        } else {
            scoreComment += "\nGOAT!";
        }
        return scoreComment;
    }
}

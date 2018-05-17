package com.example.android.meteorologyquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score;

    RadioButton answerOne, answerTwo, answerThree, answerFour;
    CheckBox answerFiveA, answerFiveB, answerFiveC, answerFiveD;
    EditText answerSix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        answerOne = findViewById(R.id.q1rb3);
        answerTwo = findViewById(R.id.q2rb4);
        answerThree = findViewById(R.id.q3rb2);
        answerFour = findViewById(R.id.q4rb4);

        answerFiveA = findViewById(R.id.q5cb1);
        answerFiveB = findViewById(R.id.q5cb2);
        answerFiveC = findViewById(R.id.q5cb3);
        answerFiveD = findViewById(R.id.q5cb4);

        answerSix = findViewById(R.id.answer6);
    }

    /**
     * Submits answers, calculates score
     */
    public void scoreQuiz(View view) {
        int finalScore = checkAnswers();

        if (finalScore < 3) {
            Toast.makeText(this, String.format(getString(R.string.tryAgainMessage), finalScore), Toast.LENGTH_SHORT).show();
        } else {
            Button submitButton = findViewById(R.id.submitButton);
            submitButton.setEnabled(false);
            Toast.makeText(this, String.format(getString(R.string.scoreMessage), finalScore), Toast.LENGTH_SHORT).show();
        }
        score = 0;
    }

    /**
     * Resets the score to zero
     */
    public void resetQuiz(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /**
     *    Checking the Answers
     *
     *    @return int score
     *
     */
    private int checkAnswers() {
        // Question 1 RadioButton - Correct Answer is B (Climate)
        if (answerOne.isChecked()) {
            score++;
        }

        // Question 2 RadioButton - Correct Answer is D (Energy use)
        if (answerTwo.isChecked()) {
            score++;
        }

        // Question 3:  RadioButton, Correct Answer B (Weather)
        if (answerThree.isChecked()) {
            score++;
        }

        // Question 4:  RadioButton, Correct Answer D (All of these are factors that influence temperature)
        if (answerFour.isChecked()) {
            score++;
        }

        // Question 5: Checkboxes, Correct Answer(s): all 3
        if (answerFiveA.isChecked() && answerFiveB.isChecked() && answerFiveC.isChecked() && !answerFiveD.isChecked()) {
            score++;
        }

        // Question 6: Edit Text, Correct Answer: Troposhere
        String strAnswer6 = answerSix.getText().toString();
        if (strAnswer6.equalsIgnoreCase("troposphere")) {
            score++;
        }

        return score;
    }

} // class MainActivity

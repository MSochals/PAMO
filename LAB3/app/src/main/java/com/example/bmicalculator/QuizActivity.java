package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    Button answerButton1, answerButton2, answerButton3, answerButton4;

    TextView scoreTextView, questionTextView;

    private Questions mQuestions = new Questions();

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;

    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        answerButton1 = (Button) findViewById(R.id.answerButton1);
        answerButton2 = (Button) findViewById(R.id.answerButton2);
        answerButton3 = (Button) findViewById(R.id.answerButton3);
        answerButton4 = (Button) findViewById(R.id.answerButton4);

        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        questionTextView = (TextView) findViewById(R.id.questionTextView);

        scoreTextView.setText("Score: " + mScore);

        updateQuestion(i);

        answerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (x < 7) {
                if(answerButton1.getText() == mAnswer) {
                    mScore++;
                    scoreTextView.setText("Score: " + mScore);
                }
                updateQuestion(i);
            }
        });

        answerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerButton2.getText() == mAnswer) {
                    mScore++;
                    scoreTextView.setText("Score: " + mScore);
                }
                updateQuestion(i);
            }
        });

        answerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerButton3.getText() == mAnswer) {
                    mScore++;
                    scoreTextView.setText("Score: " + mScore);
                }
                updateQuestion(i);
            }
        });

        answerButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answerButton4.getText() == mAnswer) {
                    mScore++;
                    scoreTextView.setText("Score: " + mScore);
                }
                updateQuestion(i);
            }
        });
    }

    private void updateQuestion(int num){
        if (num < mQuestionsLength) {
            questionTextView.setText(mQuestions.getQuestions(num));
            answerButton1.setText(mQuestions.getChoice1(num));
            answerButton2.setText(mQuestions.getChoice2(num));
            answerButton3.setText(mQuestions.getChoice3(num));
            answerButton4.setText(mQuestions.getChoice4(num));

            mAnswer = mQuestions.getCorrectAnswer(num);
            i++;
        }
        else {
            gameOver();
        }
    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(QuizActivity.this);
        alertDialogBuilder
                .setMessage("Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
                            }
                        })
                .setNegativeButton("Main menu",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
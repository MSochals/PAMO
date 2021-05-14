package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    var answerButton1: Button? = null
    var answerButton2: Button? = null
    var answerButton3: Button? = null
    var answerButton4: Button? = null
    var scoreTextView: TextView? = null
    var questionTextView: TextView? = null
    private val mQuestions: Questions? = Questions()
    private var mAnswer: String? = null
    private var mScore = 0
    private val mQuestionsLength = mQuestions?.mQuestions?.size
    private var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        answerButton1 = findViewById(R.id.answerButton1)
        answerButton2 = findViewById(R.id.answerButton2)
        answerButton3 = findViewById(R.id.answerButton3)
        answerButton4 = findViewById(R.id.answerButton4)
        scoreTextView = findViewById(R.id.scoreTextView)
        questionTextView = findViewById(R.id.questionTextView)
        scoreTextView!!.setText("Score: $mScore")
        updateQuestion(i)
        answerButton1!!.setOnClickListener(View.OnClickListener { //                if (x < 7) {
            if (answerButton1!!.getText() === mAnswer) {
                mScore++
                scoreTextView!!.setText("Score: $mScore")
            }
            updateQuestion(i)
        })
        answerButton2!!.setOnClickListener(View.OnClickListener {
            if (answerButton2!!.getText() === mAnswer) {
                mScore++
                scoreTextView!!.setText("Score: $mScore")
            }
            updateQuestion(i)
        })
        answerButton3!!.setOnClickListener(View.OnClickListener {
            if (answerButton3!!.getText() === mAnswer) {
                mScore++
                scoreTextView!!.setText("Score: $mScore")
            }
            updateQuestion(i)
        })
        answerButton4!!.setOnClickListener(View.OnClickListener {
            if (answerButton4!!.getText() === mAnswer) {
                mScore++
                scoreTextView!!.setText("Score: $mScore")
            }
            updateQuestion(i)
        })
    }

    private fun updateQuestion(num: Int) {
        if (num < mQuestionsLength!!) {
            if (mQuestions != null) {
                questionTextView?.setText(mQuestions.getQuestions(num))
            }
            if (mQuestions != null) {
                answerButton1?.setText(mQuestions.getChoice1(num))
            }
            if (mQuestions != null) {
                answerButton2?.setText(mQuestions.getChoice2(num))
            }
            if (mQuestions != null) {
                answerButton3?.setText(mQuestions.getChoice3(num))
            }
            if (mQuestions != null) {
                answerButton4?.setText(mQuestions.getChoice4(num))
            }
            if (mQuestions != null) {
                mAnswer = mQuestions.getCorrectAnswer(num)
            }
            i++
        } else {
            gameOver()
        }
    }

    private fun gameOver() {
        val alertDialogBuilder = AlertDialog.Builder(this@QuizActivity)
        alertDialogBuilder
                .setMessage("Your score is $mScore points.")
                .setCancelable(false)
                .setPositiveButton("New Game"
                ) { dialog, which -> startActivity(Intent(applicationContext, QuizActivity::class.java)) }
                .setNegativeButton("Main menu"
                ) { dialog, which -> startActivity(Intent(applicationContext, MainActivity::class.java)) }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
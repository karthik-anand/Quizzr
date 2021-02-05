package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username = intent.getStringExtra(Constants.USER_NAME)
        resname.text=username
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        scoreText.text="Your score is $correctAns out of $totalQuestions"
        btn_finish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}
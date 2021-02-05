package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var curPosn:Int=1
    private var questionList: ArrayList<QuestionClass>? = null
    private var selectedOption:Int=0
    private var correctAnscount:Int=0;
    private var userName:String?=null


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_quiz_question)
            userName=intent.getStringExtra(Constants.USER_NAME)

            questionList=Constants.getQuestions()
            setQuestion()

            tv_option1.setOnClickListener(this)
            tv_option2.setOnClickListener(this)
            tv_option3.setOnClickListener(this)
            tv_option4.setOnClickListener(this)
            btn_submit.setOnClickListener(this)

        }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option1->{
                selectedOptionView(tv_option1,1)
            }
            R.id.tv_option2->{
                selectedOptionView(tv_option2,2)
            }
            R.id.tv_option3->{
                selectedOptionView(tv_option3,3)
            }
            R.id.tv_option4->{
                selectedOptionView(tv_option4,4)
            }
            R.id.btn_submit->{
                if(selectedOption==0){
                    curPosn++
                    when{
                        curPosn<=questionList!!.size -> {
                            setQuestion()
                        }else->{
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,userName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,correctAnscount)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,questionList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = questionList?.get(curPosn-1)
                    if(question!!.correctAns!=selectedOption){
                        answerView(selectedOption,R.drawable.wrong_option_background)
                    }else{
                        correctAnscount++
                    }
                    answerView(question.correctAns,R.drawable.correct_option_background)
                }
                if(curPosn==questionList!!.size){
                    btn_submit.text="FINISH"
                }
                else{
                    btn_submit.text="NEXT QUESTION"
                }
                selectedOption=0
            }
        }
    }

        private fun setQuestion(){

            val question = questionList!![curPosn-1]

            defaultOptionsView()

            if(curPosn==questionList!!.size){
                btn_submit.text="FINISH"
            }
            else{
                btn_submit.text="SUBMIT"
            }

            progressBar.progress=curPosn
            progressText.text="$curPosn"+"/"+progressBar.max

            questionText.text=question!!.question
            questionImage.setImageResource(question.image)
            tv_option1.text=question.option1
            tv_option2.text=question.option2
            tv_option3.text=question.option3
            tv_option4.text=question.option4

        }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        selectedOption=selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface= Typeface.DEFAULT_BOLD
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_background)
    }

        private fun defaultOptionsView(){
            val options =ArrayList<TextView>()
            options.add(0,tv_option1)
            options.add(1,tv_option2)
            options.add(2,tv_option3)
            options.add(3,tv_option4)

            for(option in options){
                option.setTextColor(Color.parseColor("#7A8089"))
                option.typeface= Typeface.DEFAULT
                option.background=ContextCompat.getDrawable(this,R.drawable.button_background)
            }
        }





    private fun answerView(ans: Int, drawableView: Int){
        when(ans){
            1->{
                tv_option1.background= ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                tv_option2.background= ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                tv_option3.background= ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                tv_option4.background= ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

}
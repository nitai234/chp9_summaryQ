package com.example.chp9_summaryq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TriviaActivity extends AppCompatActivity implements View.OnClickListener {
    //למסך טריוויה
    Button ans1, ans2, ans3, ans4;
    TextView tvquestion, tvquestionNum, tvpoints;

    int points = 0, questionNum = 0;

    SharedPreferences spHighScore;
    SharedPreferences.Editor editor;

    Questions questions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        tvquestion = findViewById(R.id.question);
        tvquestionNum = findViewById(R.id.questionNum);
        tvpoints = findViewById(R.id.points);

        questions = new Questions();

        spHighScore = getSharedPreferences("Trivia", 0);
        editor = spHighScore.edit();
        editor.putInt("highScore", 0);
        editor.commit();

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        ans4.setOnClickListener(this);

        tvquestion.setText(questions.getQuestions().peek().getQuestion());

        ans1.setText(questions.getQuestions().peek().getAns1());
        ans2.setText(questions.getQuestions().peek().getAns2());
        ans3.setText(questions.getQuestions().peek().getAns3());
        ans4.setText(questions.getQuestions().peek().getAns4());

        tvquestionNum.setText(questionNum++);
    }

    @Override
    public void onClick(View view)
    {
        if(view == ans1 && questions.getQuestions().peek().getCorrect() == 1)
        {
            points++;
            Toast.makeText(this, "תשובה נכונה", Toast.LENGTH_LONG).show();
        }
        if(view == ans2 && questions.getQuestions().peek().getCorrect() == 2)
        {
            points++;
            Toast.makeText(this, "תשובה נכונה", Toast.LENGTH_LONG).show();
        }
        if(view == ans3 && questions.getQuestions().peek().getCorrect() == 3)
        {
            points++;
            Toast.makeText(this, "תשובה נכונה", Toast.LENGTH_LONG).show();
        }
        if(view == ans4 && questions.getQuestions().peek().getCorrect() == 4)
        {
            points++;
            Toast.makeText(this, "תשובה נכונה", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "תשובה לא נכונה", Toast.LENGTH_LONG).show();
        }
        nextQuestion();
    }

    public void nextQuestion()
    {

        if (questions.getQuestions().isEmpty())
        {
            if (spHighScore.getInt("highScore", 0) < points)
            {
                editor.putInt("highScore", points);
                editor.commit();
            }
            Toast.makeText(this, "המשחק נגמר", Toast.LENGTH_LONG).show();
            Intent intent = new Intent();
            intent.putExtra("points", points);
            finish();
        }
        else {
            questions.getQuestions().remove();
            tvquestion.setText(questions.getQuestions().peek().getQuestion());

            ans1.setText(questions.getQuestions().peek().getAns1());
            ans2.setText(questions.getQuestions().peek().getAns2());
            ans3.setText(questions.getQuestions().peek().getAns3());
            ans4.setText(questions.getQuestions().peek().getAns4());
            questionNum++;
            tvquestionNum.setText(questionNum);
        }
    }
}
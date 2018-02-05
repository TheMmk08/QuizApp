package com.example.android.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    boolean submitFlag=false;
    TextView txtScore;
    TextView txtState;
    RadioButton questionOneAnswer;
    RadioButton questionTwoAnswer;
    CheckBox questionThreeAnswer1;
    CheckBox questionThreeAnswer2;
    CheckBox questionFourAnswer1;
    CheckBox questionFourAnswer2;
    //Wrong answer's of Q1
    RadioButton questionOneRadio1;
    RadioButton questionOneRadio2;
    RadioButton questionOneRadio3;

    //Wrong answer's of Q2
    RadioButton questionTwoRadio1;
    RadioButton questionTwoRadio2;
    RadioButton questionTwoRadio3;

    //Wrong answer's of Q3
    CheckBox questionThreeCheck1;
    CheckBox questionThreeCheck2;
    //Wrong answer's of Q4
    CheckBox questionFourCheck1;
    CheckBox questionFourCheck2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SubmitAnswers(View view) {

        if (submitFlag != true) {
            submitFlag=true;
            questionOneAnswer = (RadioButton) findViewById(R.id.txt_q1_a);
            questionTwoAnswer = (RadioButton) findViewById(R.id.txt_q2_b);
            questionThreeAnswer1 = (CheckBox) findViewById(R.id.txt_q3_b);
            questionThreeAnswer2 = (CheckBox) findViewById(R.id.txt_q3_d);
            questionFourAnswer1 = (CheckBox) findViewById(R.id.txt_q4_a);
            questionFourAnswer2 = (CheckBox) findViewById(R.id.txt_q4_c);
            //First Answer Check
            if (questionOneAnswer.isChecked() == true) {
                ChangeImgFirstQ();
                questionOneAnswer.setTextColor(Color.GREEN);
                score += 1;

            } else {
                questionOneAnswer.setTextColor(Color.RED);
            }
            //Second Answer Check
            if (questionTwoAnswer.isChecked() == true) {
                ChangeImgSecondQ();
                questionTwoAnswer.setTextColor(Color.GREEN);
                score += 1;
            } else {
                questionTwoAnswer.setTextColor(Color.RED);
            }
            //Check 3. Question
            CheckCheckBoxQuestion(questionThreeAnswer1, questionThreeAnswer2);
            //Check 4. Question
            CheckCheckBoxQuestion(questionFourAnswer1, questionFourAnswer2);



            txtScore = (TextView) findViewById(R.id.score);
            txtScore.setText("SCORE IS: " + score);
            txtState = (TextView) findViewById(R.id.state);

            if (score >= 6) {
                txtState.setText("YOU WIN ! ! ");
            } else {
                txtState.setText("YOU LOSE ! ! ");
            }

        }
        return;
    }

    private void CheckCheckBoxQuestion(CheckBox one, CheckBox two) {
        if (one.isChecked() == true && two.isChecked() == true) {
            score += 1;


        }
        if (one.isChecked() != true) {
            one.setTextColor(Color.RED);
        } else {

            one.setTextColor(Color.GREEN);
        }
        if (two.isChecked() != true) {
            two.setTextColor(Color.RED);
        } else {
            two.setTextColor(Color.GREEN);
        }
    }

    private void ChangeImgFirstQ() {
        ImageView imgAnswer = (ImageView) findViewById(R.id.img_q1);
        imgAnswer.setImageResource(R.mipmap.alexander_fleming);
    }

    private void ChangeImgSecondQ() {

        ImageView imgAnswer = (ImageView) findViewById(R.id.img_q2);
        imgAnswer.setImageResource(R.mipmap.ernest);

    }

    public void ResetQuiz(View view) {

submitFlag=false;
        txtScore.setText(" ");
        txtState.setText(" ");
        score = 0;
        questionOneAnswer.setChecked(false);
        questionOneAnswer.setTextColor(Color.WHITE);
        questionTwoAnswer.setChecked(false);
        questionTwoAnswer.setTextColor(Color.WHITE);
        questionThreeAnswer1.setChecked(false);
        questionThreeAnswer1.setTextColor(Color.WHITE);
        questionThreeAnswer2.setChecked(false);
        questionThreeAnswer2.setTextColor(Color.WHITE);
        questionFourAnswer1.setChecked(false);
        questionFourAnswer1.setTextColor(Color.WHITE);
        questionFourAnswer2.setChecked(false);
        questionFourAnswer2.setTextColor(Color.WHITE);

        ImageView imgAnswer1 = (ImageView) findViewById(R.id.img_q1);
        imgAnswer1.setImageResource(R.mipmap.who);
        ImageView imgAnswer2 = (ImageView) findViewById(R.id.img_q2);
        imgAnswer2.setImageResource(R.mipmap.who);

        questionOneRadio1 = (RadioButton) findViewById(R.id.txt_q1_b);
        questionOneRadio1.setChecked(false);
        questionOneRadio2 = (RadioButton) findViewById(R.id.txt_q1_c);
        questionOneRadio2.setChecked(false);
        questionOneRadio3 = (RadioButton) findViewById(R.id.txt_q1_d);
        questionOneRadio3.setChecked(false);

        questionTwoRadio1 = (RadioButton) findViewById(R.id.txt_q2_a);
        questionTwoRadio1.setChecked(false);
        questionTwoRadio2 = (RadioButton) findViewById(R.id.txt_q2_c);
        questionTwoRadio2.setChecked(false);
        questionTwoRadio3 = (RadioButton) findViewById(R.id.txt_q2_d);
        questionTwoRadio3.setChecked(false);


        questionThreeCheck1 = (CheckBox) findViewById(R.id.txt_q3_a);
        questionThreeCheck2 = (CheckBox) findViewById(R.id.txt_q3_c);
        questionThreeCheck1.setChecked(false);
        questionThreeCheck2.setChecked(false);

        questionFourCheck1 = (CheckBox) findViewById(R.id.txt_q4_b);
        questionFourCheck2 = (CheckBox) findViewById(R.id.txt_q4_d);
        questionFourCheck1.setChecked(false);
        questionFourCheck2.setChecked(false);

    }
}

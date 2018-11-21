package com.example.saraa.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.widget.Toast;
import android.content.Context;

import java.util.ArrayList;

/**
 * This app displays a quiz for biology concepts.
 */

public class MainActivity extends AppCompatActivity {

    /**
     * These are the correct answers for each question.
     */

    final int answer1 = R.id.radio_cell;
    final int answer2 = R.id.radio_cellwall;
    final int answer3 = R.id.radio_thymine;
    final String answer5 = "Mitosis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Fixed list of questions and answers.
     * Creates a response message for when the user submits his answers.
     */

    public void gradeQuiz(View v) {
        ArrayList<String> wrongAnswersList = new ArrayList<String>();

        int numberOfRightQuestions = 0;

        if(gradeQ1()) {
            numberOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 1");
        }

        if(gradeQ2()) {
            numberOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 2");
        }
        if(gradeQ3()) {
            numberOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 3");
        }
        if(gradeQ4()) {
            numberOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 4");
        }
        if(gradeQ5()) {
            numberOfRightQuestions++;
        } else {
            wrongAnswersList.add("Question 5");
        }

        StringBuilder sb = new StringBuilder();
        for (String s: wrongAnswersList)
        {
            sb.append(s);
            sb.append("\n");
        }

        Context context = getApplicationContext();
        CharSequence text = "You got " + numberOfRightQuestions+ "/5 questions correct.\n\nReconsider:\n" + sb.toString();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Declares the correct answers for the quiz.
     */

    private boolean gradeQ1() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg_Bio1);

        if (rg.getCheckedRadioButtonId() == answer1) {
            return true;
        }
        return false;
    }
    private boolean gradeQ2() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg_Bio2);

        if (rg.getCheckedRadioButtonId() == answer2) {
            return true;
        }
        return false;
    }
    private boolean gradeQ3() {
        RadioGroup rg = (RadioGroup) findViewById(R.id.rg_Bio3);

        if (rg.getCheckedRadioButtonId() == answer3) {
            return true;
        }
        return false;
    }
    private boolean gradeQ4() {
        CheckBox c1 = (CheckBox) findViewById(R.id.checkBox_golgi);
        CheckBox c2 = (CheckBox) findViewById(R.id.checkBox_mitochondria);
        CheckBox c3 = (CheckBox) findViewById(R.id.checkBox_ATP);

        if (c1.isChecked() && c1.isChecked() && c2.isChecked() && !c3.isChecked()) {
            return true;
        }

        return false;
    }
    private boolean gradeQ5 () {
        EditText et = (EditText)findViewById(R.id.Bio5_edit_text);

        return et.getText().toString().equalsIgnoreCase(answer5);
    }
}
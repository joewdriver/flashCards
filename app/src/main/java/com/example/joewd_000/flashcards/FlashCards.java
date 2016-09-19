package com.example.joewd_000.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FlashCards extends AppCompatActivity {

    String filter = "filter";
    TextView txtNumber1, txtNumber2, txtOperator;
    RadioButton radioPlus, radioMinus;
    EditText txtboxAnswer;
    Button btnSubmit;
    int correctAnswer, save1, save2,  num1, num2;
    Random rand = new Random();

    private int count = 0;
    private int score = 0;

    private void checkAnswer() {
        int answer = -1000;
        try {
            answer = Integer.valueOf(txtboxAnswer.getText().toString());
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "Invalid submission, please use integers only", Toast.LENGTH_LONG).show();
        }
        if(answer == correctAnswer) {
            score++;
        }
    }

    private void nextCard() {
        num1 = rand.nextInt(10);
        num2 = rand.nextInt(10);
        if(radioMinus.isChecked()) {
            txtOperator.setText("-");
            correctAnswer = Math.max(num1, num2) - Math.min(num1, num2);
        } else {
            correctAnswer = Math.max(num1, num2) + Math.min(num1, num2);
            txtOperator.setText("+");
        }
        txtNumber1.setText("" + Math.max(num1, num2));
        txtNumber2.setText("" + Math.min(num1, num2));
    }

    private void reset() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(filter, "create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);

        txtNumber1 = (TextView)findViewById(R.id.txtNumber1);
        txtNumber2 = (TextView)findViewById(R.id.txtNumber2);
        txtOperator = (TextView)findViewById(R.id.txtOperator);

        radioPlus = (RadioButton)findViewById(R.id.radioPlus);
        radioMinus = (RadioButton)findViewById(R.id.radioMinus);

        nextCard();

        txtboxAnswer = (EditText)findViewById(R.id.txtboxAnswer);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkAnswer();
                count++;
                if(count >= 10) {
                    Toast.makeText(getApplicationContext(), "Your score is " + score + " out of 10",
                            Toast.LENGTH_LONG).show();
                    reset();
                } else {
                    nextCard();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        Log.i(filter, "start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(filter, "resume");
        super.onResume();
        num1 = save1;
        num2 = save2;
        nextCard();
    }

    @Override
    protected void onPause() {
        Log.i(filter, "pause");
        super.onPause();
        save1 = num1;
        save2 = num2;
    }

    @Override
    protected void onStop() {
        Log.i(filter, "stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(filter, "destroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.i(filter, "restart");
        super.onRestart();
    }
}

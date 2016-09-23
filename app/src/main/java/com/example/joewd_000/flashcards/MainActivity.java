package com.example.joewd_000.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUsername, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        txtUsername = (EditText)findViewById(R.id.editUsername);
        txtPassword = (EditText)findViewById(R.id.editPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtPassword.getText().equals("iam") && txtUsername.getText().equals("sam")) {
                    Intent i = new Intent(MainActivity.this, FlashCards.class);
                    startActivity(i);
                }
            }
        });
    }
}

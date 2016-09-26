package com.example.joewd_000.flashcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUsername, txtPassword;
    String filter = "filter";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        txtUsername = (EditText)findViewById(R.id.editUsername);
        txtPassword = (EditText)findViewById(R.id.editPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Authenticating", Toast.LENGTH_SHORT).show();
                Log.i(filter, "checkpoint1");
                if(txtPassword.getText().equals("iam") && txtUsername.getText().equals("sam")) {
                    Intent i = new Intent(MainActivity.this, FlashCards.class);
                    Log.i(filter, "checkpoint2");
                    startActivity(i);
                } else {
                    Intent i = new Intent(MainActivity.this, FlashCards.class);
                    Log.i(filter, "checkpoint3");
                    startActivity(i);
                }
            }
        });
    }
}

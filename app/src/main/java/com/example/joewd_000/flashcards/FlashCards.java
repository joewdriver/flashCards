package com.example.joewd_000.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FlashCards extends AppCompatActivity {

    String filter = "filter";
    TextView txtNumber1;
    TextView txtNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(filter, "create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);

        txtNumber1 = (TextView)findViewById(R.id.txtNumber1);
        txtNumber2 = (TextView)findViewById(R.id.txtNumber2);
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
    }

    @Override
    protected void onPause() {
        Log.i(filter, "pause");
        super.onPause();
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

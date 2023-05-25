package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PlayersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        Intent intent = getIntent();
        String playerName = intent.getStringExtra("name");

        TextView tx = (TextView) findViewById(R.id.textView);
        tx.setText(playerName);
    }
}
package com.github.dgenoud.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        String name = getIntent().getStringExtra("name");
        TextView textView = findViewById(R.id.greetingMessage);

        String greeting = "Hi " + name + " !";
        textView.setText(greeting);
    }
}
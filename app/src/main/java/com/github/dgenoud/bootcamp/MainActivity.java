package com.github.dgenoud.bootcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToGreet(View view) {
        EditText editText = findViewById(R.id.mainName);

        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra("name", editText.getText().toString());
        startActivity(intent);
    }
}
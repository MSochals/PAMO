package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    private TextView resultTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String bmiMessage = intent.getStringExtra(SecondaryActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        resultTextView2 = (TextView) findViewById(R.id.resultTextView);
        resultTextView2.setText(bmiMessage);
    }
}
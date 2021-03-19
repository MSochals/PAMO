package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText; // for weight and height input
import android.widget.TextView; // for displaying result
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button calculateButton;

    // called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to programmatically manipulated TextViews
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        calculateButton = (Button) findViewById(R.id.calculateButton);

        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);

        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);

        calculateButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View V) {

                String weightStr = weightEditText.getText().toString();
                String heightStr = heightEditText.getText().toString();

                if (heightStr != null && !"".equals(heightStr) && !"0".equals(heightStr)
                        && weightStr != null && !"".equals(weightStr) && !"0".equals(weightStr)) {

                    float height = Float.parseFloat(heightStr) / 100;
                    float weight = Float.parseFloat(weightStr);

                    float bmi = (weight / (height * height));
                    bmi *= 100;
                    bmi = Math.round(bmi);
                    bmi /= 100;

                    String results = "Your BMI: ";
                    results = results + bmi;

                    resultTextView.setText(results);
                }
                else{
                    resultTextView.setText("");
                }
            }
        });
    }
}
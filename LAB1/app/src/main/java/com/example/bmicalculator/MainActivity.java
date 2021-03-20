package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText; // for weight and height input
import android.widget.TextView; // for displaying result
import android.widget.Button; // for a button

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private TextView rangeTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to programmatically manipulated TextView and Button
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        rangeTextView = (TextView) findViewById(R.id.rangeTextView);
        calculateButton = (Button) findViewById(R.id.calculateButton);

        // get references from EditText
        EditText weightEditText =
                (EditText) findViewById(R.id.weightEditText);

        EditText heightEditText =
                (EditText) findViewById(R.id.heightEditText);

        // setting the listener on click the button and take action after click the button
        calculateButton.setOnClickListener(new View.OnClickListener() {

            // before clicking the button
            public void onClick(View V) {

                // get the text from EditText and transform to String
                String weightStr = weightEditText.getText().toString();
                String heightStr = heightEditText.getText().toString();

                // if text was typed in EditText poles and if typed text doesn't equal "0"
                if (heightStr != null && !"".equals(heightStr) && !"0".equals(heightStr)
                        && weightStr != null && !"".equals(weightStr) && !"0".equals(weightStr)) {

                    // transform Strings to floats
                    float height = Float.parseFloat(heightStr) / 100;
                    float weight = Float.parseFloat(weightStr);

                    // calculate the BMI
                    float bmi = (weight / (height * height));
                    bmi *= 100;
                    bmi = Math.round(bmi);
                    bmi /= 100;

                    String results = "Your BMI: ";
                    results = results + bmi;

                    resultTextView.setText(results);
                    classificationBMI(bmi);
                }
                // if the EditText poles are empty or equals "0"
                else{
                    resultTextView.setText("");
                    rangeTextView.setText("");
                }
            }
        });
    }

    // set the range of calculated BMI
    private void classificationBMI(float bmi) {
        String bmiRange = "";

        // below 18.5 - underweight range
        if (Float.compare(bmi, (float) 18.5) < 0) {
            bmiRange = getString(R.string.underweight_range);
        }
        // between 18.5 and 24.9 - normal range
        else if (Float.compare(bmi, (float) 18.5) >= 0 && Float.compare(bmi, (float) 25) <0) {
            bmiRange = getString(R.string.normal_range);
        }
        // between 25 and 29.9 - overweight range
        else if (Float.compare(bmi, (float) 25) >= 0 && Float.compare(bmi, (float) 30) <0) {
            bmiRange = getString(R.string.overweight_range);
        }
        // 30 and above - obese range
        else {
            bmiRange = getString(R.string.obese_range);
        }

        bmiRange = "You're in the " + bmiRange + " range";
        rangeTextView.setText(bmiRange);
    }
}
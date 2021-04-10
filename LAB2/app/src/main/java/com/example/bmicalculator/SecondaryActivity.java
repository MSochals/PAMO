package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText; // for weight and height input
import android.widget.TextView; // for displaying result
import android.widget.Button; // for a button

public class SecondaryActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.bmiCalculator.MESSAGE";

    private EditText weightEditText;
    private EditText heightEditText;
    private EditText sexEditText;
    private EditText ageEditText;
    private TextView errorTextView;
    private Button calculateButton;
    private String bmiRange;
    private String burger_recipe = "Lemony Asparagus Pasta recipe:\n" + "1. " + "Bring a large pot of salted water to a boil. Add penne and cook according to package directions, until al dente. Reserve ½ cup pasta water, then drain. Set aside.\n" +
            "2. " + "Meanwhile, in a large skillet over medium-high heat, heat 1 tablespoon oil. Cook asparagus until crispy, then season with pinch of salt. Transfer to a plate and set aside. \n" +
            "3. " + "Heat remaining 2 tablespoons oil over medium heat. Cook onions and garlic until softened, about 5 minutes. Add heavy cream, white wine, lemon juice, and zest. Bring mixture to a boil, then simmer for 5 minutes. Add in salt, Parmesan, and black pepper. Reduce heat to low and mix until well combined. \n" +
            "4. " + "Turn off heat and mix in pasta, asparagus, and parsley until well coated. Add small amounts of pasta water until you reach desired consistency. Serve with more grated Parmesan, cracked black pepper, and red pepper flakes.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        // get references to programmatically manipulated TextView and Button
        errorTextView = (TextView) findViewById(R.id.errorTextView);
        calculateButton = (Button) findViewById(R.id.calculateButton);

        // get references from EditText
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        heightEditText = (EditText) findViewById(R.id.heightEditText);
        sexEditText = (EditText) findViewById(R.id.sexEditText);
        ageEditText = (EditText) findViewById(R.id.ageEditText);

        // setting the listener on click the button and take action after click the button
        calculateButton.setOnClickListener(new View.OnClickListener() {

            // before clicking the button
            public void onClick(View V) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        // get the text from EditText and transform to String
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();
        String sexStr = sexEditText.getText().toString();
        String ageStr = ageEditText.getText().toString();

        if (heightStr != null && !"".equals(heightStr) && !"0".equals(heightStr)
                && weightStr != null && !"".equals(weightStr) && !"0".equals(weightStr)
                && ageStr != null && !"".equals(ageStr) && !"0".equals(ageStr)
                && sexStr != null && ("W".equals(sexStr) || "M".equals(sexStr)
                || "w".equals(sexStr) || "m".equals(sexStr))) {

            // transform Strings to floats
            float height = Float.parseFloat(heightStr) / 100;
            float heightCm = height * 100;
            float weight = Float.parseFloat(weightStr);
            float age = Float.parseFloat(ageStr);
            float dr = 0;

            if ("W".equals(sexStr) || "w".equals(sexStr)) {
                dr = (float) (655.1 + (9.653 * weight) + (1.85 * heightCm) - (4.676 * age));
            }
            else {
                dr = (float) (66.5 + (13.75 * weight) + (5.003 * heightCm) - (6.775 * age));
            }

            // calculate the BMI
            float bmi = (weight / (height * height));
            bmi *= 100;
            bmi = Math.round(bmi);
            bmi /= 100;

            String results = "Your BMI: ";
            results = results + bmi;

            classificationBMI(bmi);
            results = results + "\n" + bmiRange + "\n" + "Daily Requirements: " + dr + "kcal" + "\n" +burger_recipe;
            intent.putExtra(EXTRA_MESSAGE, results);
            startActivity(intent);
        }
        // if the EditText poles are empty or equals "0"
        else{
            errorTextView.setText("Wrong values!");
        }
    }

    // set the range of calculated BMI
    private void classificationBMI(float bmi) {

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
    }

    private void dailyRequirement(float dr) {

    }

}
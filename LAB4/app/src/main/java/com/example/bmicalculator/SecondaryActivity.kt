package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// for weight and height input
// for displaying result
// for a button
class SecondaryActivity : AppCompatActivity() {
    private var weightEditText: EditText? = null
    private var heightEditText: EditText? = null
    private var sexEditText: EditText? = null
    private var ageEditText: EditText? = null
    private var errorTextView: TextView? = null
    private var calculateButton: Button? = null
    private var bmiRange: String? = null
    var x: Int = 0
    private val pasta_recipe: String = """
         Lemony Asparagus Pasta recipe:
         1. Bring a large pot of salted water to a boil. Add penne and cook according to package directions, until al dente. Reserve ½ cup pasta water, then drain. Set aside.
         2. Meanwhile, in a large skillet over medium-high heat, heat 1 tablespoon oil. Cook asparagus until crispy, then season with pinch of salt. Transfer to a plate and set aside. 
         3. Heat remaining 2 tablespoons oil over medium heat. Cook onions and garlic until softened, about 5 minutes. Add heavy cream, white wine, lemon juice, and zest. Bring mixture to a boil, then simmer for 5 minutes. Add in salt, Parmesan, and black pepper. Reduce heat to low and mix until well combined. 
         4. Turn off heat and mix in pasta, asparagus, and parsley until well coated. Add small amounts of pasta water until you reach desired consistency. Serve with more grated Parmesan, cracked black pepper, and red pepper flakes.
         """.trimIndent()
    private val enchiladas_recipe: String = """
        Vegetarian Enchiladas recipe:
        1. Preheat oven to 350°. In a large skillet over medium heat, heat oil. Add onion and cook until soft, 6 minutes.
        2. Stir in garlic and cook until fragrant, 1 minute more. Add corn and zucchinis and season with salt, chili powder, and cumin. Cook, stirring occasionally, until corn is turning golden and zucchini is tender. Add black beans, a 1/4 cup of enchilada sauce, and lime juice. Cook 2 minutes more.
        3. Pour half the remaining enchilada sauce into a 9"-x-13" baking dish, and spread into a thin layer. Add a large scoop of vegetable mixture into the center of each tortilla and roll up tightly. Place rolled up tortillas side by side in baking dish, then top with remaining enchilada sauce and cheeses.
        4. Bake until cheese is melty, 15 to 18 minutes. 
        5. Garnish with tomatoes, avocado, onion, and cilantro.
        """.trimIndent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        // get references to programmatically manipulated TextView and Button
        errorTextView = findViewById(R.id.errorTextView)
        calculateButton = findViewById(R.id.calculateButton)

        // get references from EditText
        weightEditText = findViewById(R.id.weightEditText)
        heightEditText = findViewById(R.id.heightEditText)
        sexEditText = findViewById(R.id.sexEditText)
        ageEditText = findViewById(R.id.ageEditText)

        // setting the listener on click the button and take action after click the button
        calculateButton!!.setOnClickListener(View.OnClickListener
        // before clicking the button
        { openNewActivity() })
    }

    fun openNewActivity() {
        val intent = Intent(this, DisplayMessageActivity::class.java)

        // get the text from EditText and transform to String
        val weightStr = weightEditText!!.getText().toString()
        val heightStr = heightEditText!!.getText().toString()
        val sexStr = sexEditText!!.getText().toString()
        val ageStr = ageEditText!!.getText().toString()
        if (heightStr != null && "" != heightStr && "0" != heightStr
                && weightStr != null && "" != weightStr && "0" != weightStr
                && ageStr != null && "" != ageStr && "0" != ageStr
                && sexStr != null && ("W" == sexStr || "M" == sexStr || "w" == sexStr || "m" == sexStr)) {

            // transform Strings to floats
            val height = heightStr.toFloat() / 100
            val heightCm = height * 100
            val weight = weightStr.toFloat()
            val age = ageStr.toFloat()
            var dr = 0f

            if ("W" == sexStr || "w" == sexStr) {
                dr = (655.1f + 9.653f * weight + 1.85f * heightCm - 4.676f * age)
            } else {
                dr = (66.5f + 13.75f * weight + 5.003f * heightCm - 6.775f * age)
            }

            // calculate the BMI
            var bmi = weight / (height * height)
            bmi *= 100f
            bmi = Math.round(bmi).toFloat()
            bmi /= 100f

            var results = "Your BMI: "
            results = results + bmi
            classificationBMI(bmi.toFloat())

            var recipe: String? = null

            if (x == 0) {
                recipe = pasta_recipe
            } else {
                recipe = enchiladas_recipe
            }

            results = """
                $results
                $bmiRange
                Daily Requirements: ${dr}kcal
                $recipe
                """.trimIndent()

            intent.putExtra(EXTRA_MESSAGE, results)
            startActivity(intent)
        } else {
            errorTextView!!.setText("Wrong values!")
        }
    }

    // set the range of calculated BMI
    private fun classificationBMI(bmi: Float) {

        // below 18.5 - underweight range
        if (java.lang.Float.compare(bmi, 18.5f) < 0) {
            bmiRange = getString(R.string.underweight_range)
            x = 0
        } else if (java.lang.Float.compare(bmi, 18.5f) >= 0 && java.lang.Float.compare(bmi, 25f) < 0) {
            bmiRange = getString(R.string.normal_range)
            x = 0
        } else if (java.lang.Float.compare(bmi, 25f) >= 0 && java.lang.Float.compare(bmi, 30f) < 0) {
            bmiRange = getString(R.string.overweight_range)
            x = 1
        } else {
            bmiRange = getString(R.string.obese_range)
            x = 1
        }
        bmiRange = "You're in the $bmiRange range"
    }

    private fun dailyRequirement(dr: Float) {}

    companion object {
        val EXTRA_MESSAGE: String = "com.example.bmiCalculator.MESSAGE"
    }
}
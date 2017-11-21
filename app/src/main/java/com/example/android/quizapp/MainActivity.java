package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {

        // Question One
        EditText animalEditText = findViewById(R.id.favourite_animal);
        String animalText = animalEditText.getText().toString();

        try {
            score += checkQuestionOne(animalText);
        }
        catch(Exception e) {
            // do nothing
        }

        // Question Two
        RadioGroup radioCatGroup = findViewById(R.id.radioCatGroup);
        int selectedID = radioCatGroup.getCheckedRadioButtonId();
        RadioButton radioCatButton = findViewById(selectedID);

        try {
            score += checkQuestionTwo(radioCatButton.getText().toString());
        }
        catch(Exception e) {
            // do nothing
        }

        // Question Three
        CheckBox spiderCheckBox = findViewById(R.id.spiderCheckBox);
        CheckBox crabCheckBox = findViewById(R.id.crabCheckBox);
        CheckBox starfishCheckBox = findViewById(R.id.starfishCheckBox);
        CheckBox butterflyCheckBox = findViewById(R.id.butterflyCheckBox);

        try {
            score += checkQuestionThree(spiderCheckBox.isChecked(), crabCheckBox.isChecked(), starfishCheckBox.isChecked(), butterflyCheckBox.isChecked());
        }
        catch(Exception e) {
            // do nothing
        }


        // Question Four
        RadioGroup radioMoonGroup = findViewById(R.id.radioMoonGroup);
        selectedID = radioMoonGroup.getCheckedRadioButtonId();
        RadioButton radioMoonButton = findViewById(selectedID);

        try {
            score += checkQuestionFour(radioMoonButton.getText().toString());
        }
        catch(Exception e) {
            // do nothing
        }

        // Question Five
        RadioGroup radioSquirrel = findViewById(R.id.radioSquirrel);
        selectedID = radioSquirrel.getCheckedRadioButtonId();
        RadioButton radioSquirrelButton = findViewById(selectedID);

        try {
            score += checkQuestionFive(radioSquirrelButton.getText().toString());
        }
        catch(Exception e) {
            // do nothing
        }

        // Show the final score
        Toast toast = Toast.makeText(this, "You scored " + score + "/5", Toast.LENGTH_SHORT);
        toast.show();

        // set score to 0 after displaying it
        score = 0;
    }

    /**
     * This method runs when the Reset button is pressed.
     * It resets score to 0 and then the input fields are reset. Finally, the app scrolls to
     * the top.
     * @param view
     */
    public void reset(View view) {

        score = 0;

        EditText animalEditText = findViewById(R.id.favourite_animal);
        animalEditText.setText("");

        RadioGroup radioCatGroup = findViewById(R.id.radioCatGroup);
        radioCatGroup.clearCheck();

        CheckBox spiderCheckBox = findViewById(R.id.spiderCheckBox);
        spiderCheckBox.setChecked(false);

        CheckBox crabCheckBox = findViewById(R.id.crabCheckBox);
        crabCheckBox.setChecked(false);

        CheckBox starfishCheckBox = findViewById(R.id.starfishCheckBox);
        starfishCheckBox.setChecked(false);

        CheckBox butterflyCheckBox = findViewById(R.id.butterflyCheckBox);
        butterflyCheckBox.setChecked(false);

        RadioGroup radioMoonGroup = findViewById(R.id.radioMoonGroup);
        radioMoonGroup.clearCheck();

        RadioGroup radioSquirrel = findViewById(R.id.radioSquirrel);
        radioSquirrel.clearCheck();

        ScrollView scrollview = findViewById(R.id.scrollview);
        scrollview.smoothScrollTo(0,0);
    }

    /**
     * This method accepts the input the user enters for the first question and then returns the
     * appropriate score: 1 if right, 0 if wrong
     * @param animalText
     * @return int
     */
    private int checkQuestionOne(String animalText) {

        return ((animalText.equalsIgnoreCase("cat"))
                || (animalText.equalsIgnoreCase("cats")))? 1 : 0;

    }

    /**
     * This method accepts the name of the label of the radio button the user has selected for the
     * second question and then returns the appropriate score: 1 if right, 0 if wrong.
     * @param whichCat
     * @return int
     */
    private int checkQuestionTwo(String whichCat) {

        return ((whichCat.equals("Cheetah")))? 1 : 0;

    }

    /**
     * This method accepts the Boolean values of the different checkboxes the user has checked.
     * The right choices are spider, crab, and butterfly. This is why the method looks for
     * true, true, false, true, respectively. It then returns 1 if user gets them right, or 0 if not.
     * @param spiderChecked
     * @param crabChecked
     * @param starfishChecked
     * @param butterflyChecked
     * @return int
     */
    private int checkQuestionThree(Boolean spiderChecked, Boolean crabChecked, Boolean starfishChecked, Boolean butterflyChecked) {

        return ((spiderChecked && crabChecked && !starfishChecked && butterflyChecked))? 1 : 0;

    }

    /**
     * This method accepts the name of the label of the radio button the user has selected for the
     * fourth question and then returns the appropriate score: 1 if right, 0 if wrong.
     * @param moonAnimal
     * @return int
     */
    private int checkQuestionFour(String moonAnimal) {

        return ((moonAnimal.equals("Cow")))? 1 : 0;

    }

    /**
     * This method accepts the name of the label of the radio button the user has selected for the
     * fifth question and then returns the appropriate score: 1 if right, 0 if wrong.
     * @param flyingBool
     * @return
     */
    private int checkQuestionFive(String flyingBool) {

        return ((flyingBool.equals("No")))? 1 : 0;

    }
}


package com.example.android.quizapp;

import android.content.Context;
import android.graphics.Typeface;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.security.KeyStore;

public class ZeldaQuizActivity extends AppCompatActivity {

    TextView quizInstructions;
    Typeface zelda;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zelda_quiz);
        quizInstructions = (TextView) findViewById(R.id.quiz_intsructions);
        zelda = Typeface.createFromAsset(getAssets(), "fonts/Triforce.ttf");
        quizInstructions.setTypeface(zelda);
    }

    //The method below will take the editText answers for questions 1 and 2 (entered by the user)
    // and verify if they are correct
    public int editTextAnswerCheck() {
        int editTextPoints = 0;

        EditText editTextQuestionOne = (EditText) findViewById(R.id.edit_text_question_one);
        EditText editTextQuestionTwo = (EditText) findViewById(R.id.edit_text_question_two);

        String questionOneEditText = editTextQuestionOne.getText().toString();
        String questionTwoEditText = editTextQuestionTwo.getText().toString();

        String questionOneOptionOne = "Zelda\'s Lullaby";
        String questionOneOptionTwo = "Zeldas Lullaby";
        String questionTwoOptionOne = "Six";
        String questionTwoOptionTwo = "6";

        if (questionOneEditText.equals(questionOneOptionOne) || questionOneEditText.equals(questionOneOptionTwo)) {
            editTextPoints = editTextPoints + 1;
        }

        if (questionTwoEditText.equals(questionTwoOptionOne) || questionTwoEditText.equals(questionTwoOptionTwo)) {
            editTextPoints = editTextPoints + 1;
        }
        return editTextPoints;
    }

    //methods below will check answer for all the RadioGroup questions (#3, 4, 7, 9)
    //and verify if they are correct
    //only the CORRECT answers were used for the methods
    public int questionThreeAnswerCheck() {
        int questionThreeFinalPoint = 0;

        RadioButton rbQuestionThreeAnswerA = findViewById(R.id.rb_question_three_answer_a);
        boolean rbQuestionThreeAnswerAStatus = rbQuestionThreeAnswerA.isChecked();

        if (rbQuestionThreeAnswerAStatus) {
            questionThreeFinalPoint = questionThreeFinalPoint + 1;
        }
        return questionThreeFinalPoint;
    }

    public int questionFourAnswerCheck() {
        int questionFourFinalPoint = 0;

        RadioButton rbQuestionFourAnswerC = findViewById(R.id.rb_question_four_answer_c);
        boolean rbQuestionFourAnswerCStatus = rbQuestionFourAnswerC.isChecked();

        if (rbQuestionFourAnswerCStatus) {
            questionFourFinalPoint = questionFourFinalPoint + 1;
        }
        return questionFourFinalPoint;
    }

    public int questionSevenAnswerCheck() {
        int questionSevenFinalPoint = 0;

        RadioButton rbQuestionSevenAnswerD = findViewById(R.id.rb_question_seven_answer_d);
        boolean rbQuestionSevenAnswerDStatus = rbQuestionSevenAnswerD.isChecked();

        if (rbQuestionSevenAnswerDStatus) {
            questionSevenFinalPoint = questionSevenFinalPoint + 1;
        }
        return questionSevenFinalPoint;
    }

    public int questionNineAnswerCheck() {
        int questionNineFinalPoint = 0;

        RadioButton rbQuestionNineAnswerB = findViewById(R.id.rb_question_nine_answer_b);
        boolean rbQuestionNineAnswerBStatus = rbQuestionNineAnswerB.isChecked();

        if (rbQuestionNineAnswerBStatus) {
            questionNineFinalPoint = questionNineFinalPoint + 1;
        }
        return questionNineFinalPoint;
    }

    //methods below will check the answers for all the checkbox questions (#5, 6, 8, 10)
    //and verify if they are correct
    public int questionFiveAnswerCheck() {
        //checkbox answers must have all possible correct answers checked to receive a point for the question
        //Ex: question 5 has three answers, thus, one point will be added ONLY IF answers A, B, and D are all checked
        int questionFiveCheckBoxes = 0, questionFiveFinalPoint = 0;

        //checks whether or not question 5 answers A, B, and D is checked
        CheckBox questionFiveAnswerA = findViewById(R.id.cb_question_five_answer_a);
        CheckBox questionFiveAnswerB = findViewById(R.id.cb_question_five_answer_b);
        CheckBox questionFiveAnswerC = findViewById(R.id.cb_question_five_answer_c);
        CheckBox questionFiveAnswerD = findViewById(R.id.cb_question_five_answer_d);

        boolean questionFiveAnswerAStatus = questionFiveAnswerA.isChecked();
        boolean questionFiveAnswerBStatus = questionFiveAnswerB.isChecked();
        boolean questionFiveAnswerCStatus = questionFiveAnswerC.isChecked();
        boolean questionFiveAnswerDStatus = questionFiveAnswerD.isChecked();

        //the following if statements will add ONE point to questionSixCheckBoxes per each CORRECT
        //checkbox that was checked by the user. FOUR points will be added for each INCORRECT
        //checkbox that was checked by the user
        if (questionFiveAnswerAStatus) {
            questionFiveCheckBoxes = questionFiveCheckBoxes + 1;
        }

        if (questionFiveAnswerBStatus) {
            questionFiveCheckBoxes = questionFiveCheckBoxes + 1;
        }

        if (questionFiveAnswerCStatus) {
            questionFiveCheckBoxes = questionFiveCheckBoxes + 4;
        }

        if (questionFiveAnswerDStatus) {
            questionFiveCheckBoxes = questionFiveCheckBoxes + 1;
        }

        //This if statement checks for the total points in questionFiveCheckBoxes.
        // This variable must equal '3' for the user to get one point for the entire question
        if (questionFiveCheckBoxes == 3) {
            questionFiveFinalPoint = questionFiveFinalPoint + 1;
            return questionFiveFinalPoint;
        } else {
            return questionFiveFinalPoint;
        }
    }

    public int questionSixAnswerCheck() {
        //checkbox answers must have all possible correct answers checked to receive a point for the question
        //Ex: question 5 has three answers, thus, one point will be added ONLY IF answers A, B, and D are all checked
        int questionSixCheckBoxes = 0, questionSixFinalPoint = 0;

        //checks whether or not question 5 answers are checked
        CheckBox questionSixAnswerA = findViewById(R.id.cb_question_six_answer_a);
        CheckBox questionSixAnswerB = findViewById(R.id.cb_question_six_answer_b);
        CheckBox questionSixAnswerC = findViewById(R.id.cb_question_six_answer_c);
        CheckBox questionSixAnswerD = findViewById(R.id.cb_question_six_answer_d);

        boolean questionSixAnswerAStatus = questionSixAnswerA.isChecked();
        boolean questionSixAnswerBStatus = questionSixAnswerB.isChecked();
        boolean questionSixAnswerCStatus = questionSixAnswerC.isChecked();
        boolean questionSixAnswerDStatus = questionSixAnswerD.isChecked();

        //the following if statements will add ONE point to questionSixCheckBoxes per each CORRECT
        //checkbox that was checked by the user. THREE points will be added for each INCORRECT
        //checkbox that was checked by the user
        if (questionSixAnswerAStatus) {
            questionSixCheckBoxes = questionSixCheckBoxes + 3;
        }

        if (questionSixAnswerBStatus) {
            questionSixCheckBoxes = questionSixCheckBoxes + 1;
        }

        if (questionSixAnswerCStatus) {
            questionSixCheckBoxes = questionSixCheckBoxes + 3;
        }

        if (questionSixAnswerDStatus) {
            questionSixCheckBoxes = questionSixCheckBoxes + 1;
        }

        //This if statement checks for the total points in questionFiveCheckBoxes.
        // This variable must equal '2' for the user to get one point for the entire question
        if (questionSixCheckBoxes == 2) {
            questionSixFinalPoint = questionSixFinalPoint + 1;
            return questionSixFinalPoint;
        } else {
            return questionSixFinalPoint;
        }
    }

    public int questionEightAnswerCheck() {
        //checkbox answers must have all possible correct answers checked to receive a point for the question
        //Ex: question 5 has three answers, thus, one point will be added ONLY IF answers A, B, and D are all checked
        int questionEightCheckBoxes = 0, questionEightFinalPoint = 0;

        //checks whether or not question eight answers are checked
        CheckBox questionEightAnswerA = findViewById(R.id.cb_question_eight_answer_a);
        CheckBox questionEightAnswerB = findViewById(R.id.cb_question_eight_answer_b);
        CheckBox questionEightAnswerC = findViewById(R.id.cb_question_eight_answer_c);
        CheckBox questionEightAnswerD = findViewById(R.id.cb_question_eight_answer_d);

        boolean questionEightAnswerAStatus = questionEightAnswerA.isChecked();
        boolean questionEightAnswerBStatus = questionEightAnswerB.isChecked();
        boolean questionEightAnswerCStatus = questionEightAnswerC.isChecked();
        boolean questionEightAnswerDStatus = questionEightAnswerD.isChecked();

        //the following if statements will add ONE point to questionSixCheckBoxes per each CORRECT
        //checkbox that was checked by the user. FOUR points will be added for each INCORRECT
        //checkbox that was checked by the user
        if (questionEightAnswerAStatus) {
            questionEightCheckBoxes = questionEightCheckBoxes + 1;
        }

        if (questionEightAnswerBStatus) {
            questionEightCheckBoxes = questionEightCheckBoxes + 4;
        }

        if (questionEightAnswerCStatus) {
            questionEightCheckBoxes = questionEightCheckBoxes + 1;
        }

        if (questionEightAnswerDStatus) {
            questionEightCheckBoxes = questionEightCheckBoxes + 1;
        }

        //This if statement checks for the total points in questionEightCheckBoxes.
        // This variable must equal '3' for the user to get one point for the entire question
        if (questionEightCheckBoxes == 3) {
            questionEightFinalPoint = questionEightFinalPoint + 1;
            return questionEightFinalPoint;
        } else {
            return questionEightFinalPoint;
        }
    }

    public int questionTenAnswerCheck() {
        //checkbox answers must have all possible correct answers checked to receive a point for the question
        //Ex: question 5 has three answers, thus, one point will be added ONLY IF answers A, B, and D are all checked
        int questionTenCheckBoxes = 0, questionTenFinalPoint = 0;

        //checks whether or not question TEN answers are checked
        CheckBox questionTenAnswerA = findViewById(R.id.cb_question_ten_answer_a);
        CheckBox questionTenAnswerB = findViewById(R.id.cb_question_ten_answer_b);
        CheckBox questionTenAnswerC = findViewById(R.id.cb_question_ten_answer_c);
        CheckBox questionTenAnswerD = findViewById(R.id.cb_question_ten_answer_d);

        boolean questionTenAnswerAStatus = questionTenAnswerA.isChecked();
        boolean questionTenAnswerBStatus = questionTenAnswerB.isChecked();
        boolean questionTenAnswerCStatus = questionTenAnswerC.isChecked();
        boolean questionTenAnswerDStatus = questionTenAnswerD.isChecked();

        //the following if statements will add ONE point to questionSixCheckBoxes per each CORRECT
        //checkbox that was checked by the user. THREE points will be added for each INCORRECT
        //checkbox that was checked by the user
        if (questionTenAnswerAStatus) {
            questionTenCheckBoxes = questionTenCheckBoxes + 1;
        }

        if (questionTenAnswerBStatus) {
            questionTenCheckBoxes = questionTenCheckBoxes + 3;
        }

        if (questionTenAnswerCStatus) {
            questionTenCheckBoxes = questionTenCheckBoxes + 3;
        }

        if (questionTenAnswerDStatus) {
            questionTenCheckBoxes = questionTenCheckBoxes + 1;
        }

        //This if statement checks for the total points in questionTenCheckBoxes.
        // This variable must equal '2' for the user to get one point for the entire question
        if (questionTenCheckBoxes == 2) {
            questionTenFinalPoint = questionTenFinalPoint + 1;
            return questionTenFinalPoint;
        } else {
            return questionTenFinalPoint;
        }
    }

    //this method will call the previously stated methods and add their values to score. A Toast
    // message will appear, which displays the user's score. The program will also reset the score
    // after each time the "SUBMIT" button is pressed
    public void submitQuiz(View view) {
        score = score + editTextAnswerCheck() + questionThreeAnswerCheck() + questionFourAnswerCheck()
                + questionFiveAnswerCheck() + questionSixAnswerCheck()
                + questionSevenAnswerCheck() + questionEightAnswerCheck()
                + questionNineAnswerCheck() + questionTenAnswerCheck();

        Context quizContext = getApplicationContext();
        String passMessage = "Congrats! You passed with a score of: " + score + "/10";
        String failMessage = "Total score: " + score + "/10 \nSorry, you failed";
        int duration = Toast.LENGTH_LONG;
        Toast passingScore = Toast.makeText(quizContext, passMessage, duration);
        Toast failingScore = Toast.makeText(quizContext, failMessage, duration);

        if (score >= 7) {
            passingScore.show();
            score = 0;
        } else {
            failingScore.show();
            score = 0;
        }
    }
}

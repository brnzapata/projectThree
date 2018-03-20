package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.graphics.Typeface;

public class HomeActivity extends AppCompatActivity {

    TextView welcomeMessage;
    Typeface zelda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        welcomeMessage = (TextView) findViewById(R.id.home_activity_quiz_intro);
        zelda = Typeface.createFromAsset(getAssets(), "fonts/Triforce.ttf");
        welcomeMessage.setTypeface(zelda);
    }

    public void startQuiz(View view) {
        Intent startTheQuiz = new Intent(HomeActivity.this, ZeldaQuizActivity.class);
        startActivity(startTheQuiz);
    }
}
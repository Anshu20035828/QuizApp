package digi.coders.quizapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import digi.coders.quizapp.R;
import digi.coders.quizapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainxml;
//   CardView quizs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        mainxml =  ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainxml.getRoot());

//        quizs = findViewById(R.id.quiz);


        mainxml.quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QuizSolveActivity.class));
            }
        });
    }
}
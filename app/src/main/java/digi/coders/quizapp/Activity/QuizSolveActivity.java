package digi.coders.quizapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonArray;

import com.google.gson.JsonObject;

import digi.coders.quizapp.GetRetrofit;
import digi.coders.quizapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizSolveActivity extends AppCompatActivity {
    TextView questions, ques_1, ques_2, ques_3, ques_4, ques_5, ques_6;
    Button previousButton, NextButton;
    private int currentQuestionIndex = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_solve);

        String quizes = "yjoKm41lqBBPTbS4iRnlyMmMtF5bZNKTtvxa9T9O";

        questions = findViewById(R.id.question);
        ques_1 = findViewById(R.id.ques_1);
        ques_2 = findViewById(R.id.ques_2);
        ques_3 = findViewById(R.id.ques_3);
        ques_4 = findViewById(R.id.ques_4);
        ques_5 = findViewById(R.id.ques_5);
        ques_6 = findViewById(R.id.ques_6);

        previousButton = findViewById(R.id.previousButton);
        NextButton = findViewById(R.id.NextButton);

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetQuizsSolevAllQuestion(quizes);
            }
        });



        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;  // Move to the previous question
                    GetQuizsSolevAllQuestion(quizes);
                    Log.d("previous",""+currentQuestionIndex);
                } else {
                    // Handle the case where there are no previous questions
                    // You may want to show a message or disable the previous button
                }
            }
        });


    }

    void GetQuizsSolevAllQuestion(String XApiKey) {
        // ... (other code)

        GetRetrofit.QuizSolve().getQuiz(XApiKey).enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                try {
                    if (response.isSuccessful()) {
                        JsonArray jsonArray = response.body();
                        Log.d("QuizsSolevAllQuestion", "isSuccessful" + response.body());

                        JsonObject jsonObject = jsonArray.get(currentQuestionIndex).getAsJsonObject();

                        String question = jsonObject.get("question").getAsString();
                        questions.setText(question);

                        setAnswerToTextView(jsonObject, "answer_a", ques_1);
                        setAnswerToTextView(jsonObject, "answer_b", ques_2);
                        setAnswerToTextView(jsonObject, "answer_c", ques_3);
                        setAnswerToTextView(jsonObject, "answer_d", ques_4);
                        setAnswerToTextView(jsonObject, "answer_e", ques_5);
                        setAnswerToTextView(jsonObject, "answer_f", ques_6);

                        // Check and set visibility after setting all answers
                        checkAndSetVisibility(ques_1);
                        checkAndSetVisibility(ques_2);
                        checkAndSetVisibility(ques_3);
                        checkAndSetVisibility(ques_4);
                        checkAndSetVisibility(ques_5);
                        checkAndSetVisibility(ques_6);

                    } else {
                        Log.d("QuizsSolevAllQuestion", "is not Successful");
                    }
                } catch (Exception e) {
                    Log.d("QuizsSolevAllQuestion", "isSuccessful" + e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("QuizsSolevAllQuestion", "isSuccessful" + t.getMessage());
            }
        });
    }

    private void setAnswerToTextView(JsonObject jsonObject, String answerKey, TextView textView) {
        String answer = jsonObject.get("answers").getAsJsonObject().get(answerKey).getAsString();

        if (answer == null || answer.trim().isEmpty()) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(answer);
        }
    }

    private void checkAndSetVisibility(TextView textView) {
        if (textView.getVisibility() == View.VISIBLE && textView.getText().toString().trim().isEmpty()) {
            textView.setVisibility(View.GONE);
        }
    }



}

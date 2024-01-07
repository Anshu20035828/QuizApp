package digi.coders.quizapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import digi.coders.quizapp.R;
import digi.coders.quizapp.SharedPref;

public class LoginActivity extends AppCompatActivity {

    TextView signUp;
    TextInputEditText usernamelogin,passwordlogin;
    Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signUp = findViewById(R.id.signUp);
        usernamelogin = findViewById(R.id.usernamelogin);
        passwordlogin = findViewById(R.id.passwordlogin);
        loginbtn = findViewById(R.id.loginbtn);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       Boolean login= SharedPref.getInstance(LoginActivity.this).isLoggedIn();
       if(login){
           Intent a=new Intent(LoginActivity.this, MainActivity.class);
           startActivity(a);
       }





    }
}
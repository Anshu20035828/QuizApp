package digi.coders.quizapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import digi.coders.quizapp.Models.Model;
import digi.coders.quizapp.R;
import digi.coders.quizapp.SharedPref;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText signUsers, signEmail, signpassword;
    Button signbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUsers = findViewById(R.id.signUsername);
        signEmail = findViewById(R.id.signEmail);
        signpassword = findViewById(R.id.signpassword);

        signbtn = findViewById(R.id.signbtn);


       signbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String signName = signUsers.getText().toString().trim();
               String signEmails = signEmail.getText().toString().trim();
               String signpasswords = signpassword.getText().toString().trim();

               if (signName.equalsIgnoreCase("") || signName == null) {
                   Toast.makeText(SignUpActivity.this, "Enter you Name", Toast.LENGTH_SHORT).show();
               }
               if (signEmails.equalsIgnoreCase("") || signEmails == null) {
                   Toast.makeText(SignUpActivity.this, "Enter you Email", Toast.LENGTH_SHORT).show();
               }
               if (signpasswords.equalsIgnoreCase("") || signpasswords == null) {
                   Toast.makeText(SignUpActivity.this, "Enter you Password", Toast.LENGTH_SHORT).show();
               }


               SharedPref.getInstance(SignUpActivity.this).setuser(new Model(signName,signEmails,signpasswords));
              // startActivity(new Intent(SignUpActivity.this, MainActivity.class));

           }
       });
    }
}
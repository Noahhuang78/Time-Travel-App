package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

import com.google.android.material.button.MaterialButton;
public class SignupPage extends AppCompatActivity {

    EditText createUsername;
    EditText createPassword;
    EditText confirmPassword;
    EditText Email;
    MaterialButton createAccount;
    MaterialButton goBack;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        createUsername = findViewById(R.id.username_create);
        createPassword = findViewById(R.id.password_create);
        confirmPassword = findViewById(R.id.confirm_password);
        Email = findViewById(R.id.email);
        createAccount = findViewById(R.id.create_account);
        goBack = findViewById(R.id.go_back);
        createAccount.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //TODO 1.0 email address valid check
                if (Email.getText().toString().isEmpty()) {
                    Toast.makeText(SignupPage.this, "please enter a valid email address", Toast.LENGTH_SHORT).show();
                } else if (createUsername.getText().toString().isEmpty()) {
                    Toast.makeText(SignupPage.this, "please enter a username", Toast.LENGTH_SHORT).show();
                }
                //TODO 1.1 replace "user" with account usernames inside the database for username taken
                else if ((createUsername.getText().toString().equals("user"))) {
                    Toast.makeText(SignupPage.this, "username taken", Toast.LENGTH_SHORT).show();
                } else if (createPassword.getText().toString().isEmpty()) {
                    Toast.makeText(SignupPage.this, "please enter a password", Toast.LENGTH_SHORT).show();
                } else if (!(confirmPassword.getText().toString().equals(createPassword.getText().toString()))) {
                    Toast.makeText(SignupPage.this, "your password and confirmation password must match", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignupPage.this, "account created successfully", Toast.LENGTH_SHORT).show();
                    String user = createUsername.getText().toString();
                    String password = createPassword.getText().toString();
                    String email = Email.getText().toString();
                    Log.d(LoginPage.myuserkey, "sub" + user);
                    Log.d(LoginPage.mypasswordkey, "sub" + password);
                    Log.d(LoginPage.myemailkey, "sub" + email);
                    Intent intent = new Intent();
                    intent.putExtra(LoginPage.myuserkey, user);
                    intent.putExtra(LoginPage.mypasswordkey, password);
                    intent.putExtra(LoginPage.myemailkey, email);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(Activity.RESULT_OK, intent);
                intent.putExtra(LoginPage.myuserkey, false);
                finish();



                }
        });
    }
}
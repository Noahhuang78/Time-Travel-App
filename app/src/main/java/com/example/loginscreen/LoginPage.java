package com.example.loginscreen;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import com.google.android.material.button.MaterialButton;

public class LoginPage extends AppCompatActivity {
    EditText usernameInput;
    EditText passwordInput;
    MaterialButton loginbtn;
    MaterialButton signupbtn;
    public static String myuserkey = "User:";
    public static String mypasswordkey = "Password:";
    public static String myemailkey = "Email:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        signupbtn = findViewById(R.id.sign_up);
        loginbtn = findViewById(R.id.login);
        final ActivityResultLauncher<Intent> launcherActivity = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Bundle b = result.getData().getExtras();
                        String user = b.getString(myuserkey);
                        String password = b.getString(mypasswordkey);
                        String email = b.getString(myemailkey);
                        Log.d(LoginPage.myuserkey, "main" + user);
                        Log.d(LoginPage.mypasswordkey, "main" + password);
                        Log.d(LoginPage.myemailkey, "main" + email);
                    }
                }
        );
        loginbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //TODO 1.1 replace "user" and "passwword" with account's actual username and password
                if (usernameInput.getText().toString().equals("user") && passwordInput.getText().toString().equals("password")) {
                    Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginPage.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
                Log.d("Test Credentials", "User:" + usernameInput.getText().toString());
            }
        });
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new  Intent ( LoginPage.this, SignupPage.class);
                launcherActivity.launch(intent);



                Log.d("Test Credentials", "User:" + usernameInput.getText().toString());
            }
        });
    }
}
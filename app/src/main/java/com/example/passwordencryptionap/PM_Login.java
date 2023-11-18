package com.example.passwordencryptionap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PM_Login extends AppCompatActivity {
    //declare variables
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "password";

    //set view activity_login
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //linking variables into layout ID
        editTextUsername = findViewById(R.id.pm_loginEmail);
        editTextPassword = findViewById(R.id.pm_loginPassword);
        buttonLogin = findViewById(R.id.pm_signinButton);

        //on click method
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticateUser();
            }
        });
    }

    //validates username and password
    private void authenticateUser() {
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            // Authentication successful
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();

            // proceeds to menu
            Intent intent = new Intent(PM_Login.this, PM_Menu.class);
            startActivity(intent);
            finish(); // Close the login activity
        } else {
            // Authentication failed
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
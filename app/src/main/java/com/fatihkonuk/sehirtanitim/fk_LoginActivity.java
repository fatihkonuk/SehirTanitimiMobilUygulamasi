package com.fatihkonuk.sehirtanitim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class fk_LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,password;
    private Button loginBtn,registerBtn;
    private String txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fk_login);
        init();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fk_registerIntent = new Intent(fk_LoginActivity.this, fk_RegisterActivity.class);
                startActivity(fk_registerIntent);
            }
        });
    }

    private void init() {
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.loginButton);
        registerBtn = findViewById(R.id.registerBtn);
    }

    private void login() {
        txtEmail = email.getText().toString();
        txtPassword = password.getText().toString();
        if (!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword)) {
            mAuth.signInWithEmailAndPassword(txtEmail,txtPassword)
                    .addOnSuccessListener(authResult -> {
                        Toast.makeText(this, "Giriş Başarılı", Toast.LENGTH_LONG).show();
                        Intent fk_mainMenuIntent = new Intent(fk_LoginActivity.this, fk_MainMenuActivity.class);
                        startActivity(fk_mainMenuIntent);
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
                    });
        }else {
            Toast.makeText(this,"Email ve Şifre Boş Olamaz", Toast.LENGTH_SHORT).show();
        }
    }
}
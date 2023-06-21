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

public class fk_RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,password;
    private Button loginBtn,registerBtn;
    private String txtEmail, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fk_register);
        init();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fk_loginIntent = new Intent(fk_RegisterActivity.this, fk_LoginActivity.class);
                startActivity(fk_loginIntent);
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void init() {
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);
    }

    private void register() {
        txtEmail = email.getText().toString();
        txtPassword = password.getText().toString();

        if (!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword)) {
            mAuth.createUserWithEmailAndPassword(txtEmail,txtPassword)
                    .addOnSuccessListener(authResult -> {
                        Toast.makeText(this, "Kayıt İşlemi Başarılı", Toast.LENGTH_LONG).show();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Intent fk_loginIntent = new Intent(fk_RegisterActivity.this, fk_LoginActivity.class);
                        startActivity(fk_loginIntent);
                    })
                    .addOnFailureListener(exception -> {
                        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        }else {
            Toast.makeText(this, "Email ve Şifre Boş Olamaz", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    protected EditText login;
    protected EditText password;

    protected String passwordStr;
    protected String loginStr;


    protected Button enter;
    protected ImageButton showPass;

    protected TextView ForgotPass;
    protected TextView toCreateAc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.addMail);
        password = findViewById(R.id.addPassForAddMail);

//        loginStr = login.getText().toString();
//        passwordStr = password.getText().toString();

        enter = findViewById(R.id.enter);
        showPass = findViewById(R.id.eye);

        oneStep();//для error
        btnShowPass(); // для показа пароля
    }

    public void oneStep() {
        enter.setOnClickListener(v -> {
            if (login.length() <= 0) {
                login.setError("Введите логин ! ");
            }
            if (password.length() <= 0) {
                password.setError("Введите пароль ! ");
            }
        });
    }

    public void btnShowPass() {
        showPass.setOnClickListener(v -> {
            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//показать пароль
            new java.util.Timer().schedule(new java.util.TimerTask() {
                                               @Override
                                               public void run() {
                                                   password.setTransformationMethod(new PasswordTransformationMethod());//скрыть через тайм
                                               }
                                           }, 3000
            );
        });
    }
}

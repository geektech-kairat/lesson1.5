package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
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

        loginStr = login.getText().toString();
        passwordStr = password.getText().toString();

        enter = findViewById(R.id.enter);
        showPass = findViewById(R.id.eye);

        oneStep();
        btnShowPass();
    }

    public void oneStep() {


        enter.setOnClickListener(v -> {
            if (login.length() <= 0 ) {
                login.setError("Введите логин ! ");
//                login.setHintTextColor(Color.RED);
//                    Toast toast = Toast.makeText(MainActivity.this, "hiiii", Toast.LENGTH_LONG);
//                    toast.setGravity(Gravity.CENTER, 0 , 0);
//                    toast.show();

//                    login.setOnClickListener(v1 -> {
//                        login.setHintTextColor(Color.GRAY);
//                    });
//                }if(passStr.equals("")){
//                    password.setHintTextColor(Color.RED);
//                }
            }if (password.length() <= 0) {
                password.setError("Введите пароль ! ");
            }

        });


    }

    public void btnShowPass() {
        showPass.setOnClickListener(v -> {
            password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
//            Toast.makeText(this, password.getText(), Toast.LENGTH_LONG).show();
//            password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
//            Timer timer = new Timer();
            new java.util.Timer().schedule(new java.util.TimerTask(){

                @Override
                public void run() {
                    password.setTransformationMethod(new PasswordTransformationMethod());
                }
            },3000
            );

        });

//        showPass.setOnClickListener(v -> {
//            password.setTransformationMethod(new PasswordTransformationMethod());
//        });


    }
}

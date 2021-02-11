package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    protected EditText login;
    protected EditText password;

    protected String passwordStr;
    protected String loginStr;

    protected String regex = "[а-яёА-ЯЁ]+";


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

        oneStep();//для error
        btnShowPass(); // для показа пароля
    }

    public void oneStep() {
        enter.setOnClickListener(v -> {
            String str1 = login.getText().toString();// через глобальный не получилось сделать пришлось
            // создовать одтельный стригновый перенный и здесь проверить на латинь
            String str2 = password.getText().toString();

            Pattern pattern = Pattern.compile(regex);
            Matcher m1 = pattern.matcher(str1);
            Matcher m2 = pattern.matcher(str2);
            if (m1.find()){
                login.setError("Используйте только латинские буквы и цифры!");
            }if (m2.find()){
                login.setError("используйте только латинские буквы и цифры! ");
            }

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


package com.shunico.newshapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by a on 5/28/2018.
 */

public class Login extends Activity {

    AppCompatEditText edt_number;
    AppCompatEditText edt_pass;
    TextInputLayout TIL_number;
    TextInputLayout TIL_pass;
    Typeface tf;
    TextView text_register;
    TextView text_shoar;
    Button btn_enter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        tf = Typeface.createFromAsset(getResources().getAssets() , "IranSans.ttf");



        edt_number = findViewById(R.id.edt_number);
        edt_pass = findViewById(R.id.edt_pass);

        TIL_number = findViewById(R.id.til_number);
        TIL_pass = findViewById(R.id.til_pass);

        text_register = findViewById(R.id.txt_register);
        text_shoar = findViewById(R.id.txt_shoar);
        btn_enter = findViewById(R.id.btn_enter);

        edt_number.setTypeface(tf);
        edt_pass.setTypeface(tf);
        TIL_number.setTypeface(tf);
        TIL_pass.setTypeface(tf);
        text_register.setTypeface(tf);
        text_shoar.setTypeface(tf);
        btn_enter.setTypeface(tf);


        text_register.setText(Html.fromHtml("جهت ثبت نام  <b> اینجا </b> را کلیک کنید."));

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this , Main_Register.class));
            }
        });

    }
}

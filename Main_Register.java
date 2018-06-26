package com.shunico.newshapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

/**
 * Created by a on 5/29/2018.
 */

public class Main_Register extends FragmentActivity {

    static FragmentManager fm;

    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;

    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_register);

        Typeface tf = Typeface.createFromAsset(getResources().getAssets() , "IranSans.ttf");


        text1 = findViewById(R.id.s1);
        text2 = findViewById(R.id.s2);
        text3 = findViewById(R.id.s3);
        text4 = findViewById(R.id.s4);
        text5 = findViewById(R.id.s5);

        txt1 = findViewById(R.id.t1);
        txt2 = findViewById(R.id.t2);
        txt3 = findViewById(R.id.t3);
        txt4 = findViewById(R.id.t4);
        txt5 = findViewById(R.id.t5);

        text1.setTypeface(tf);
        text2.setTypeface(tf);
        text3.setTypeface(tf);
        text4.setTypeface(tf);
        text5.setTypeface(tf);

        txt1.setTypeface(tf);
        txt2.setTypeface(tf);
        txt3.setTypeface(tf);
        txt4.setTypeface(tf);
        txt5.setTypeface(tf);


        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.content_layout);
        if (fragment == null)
        {
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.content_layout , new Step1());
            ft.commit();
        }


    }


}

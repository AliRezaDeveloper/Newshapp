package com.shunico.newshapp;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by a on 5/30/2018.
 */

public class Step3 extends Fragment {


    Button btn_next;
    View v;
    /////////////STEP1////////////

    TextView Text_titr;
    AppCompatCheckBox CB_ezafe;
    AppCompatRadioButton RB_bazo;
    AppCompatRadioButton RB_ran;
    AppCompatRadioButton RB_basan;
    AppCompatRadioButton RB_shekam;
    AppCompatRadioButton RB_diabet;


    ////////////STEP2/////////////



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if (Step2.MOSHAVERE.equals("TANASOB"))
        {
           v = inflater.inflate(R.layout.step3_1, container , false);
        }
        if (Step2.MOSHAVERE.equals("DIABET"))
        {
           v = inflater.inflate(R.layout.step3_2, container , false);
        }
        if (Step2.MOSHAVERE.equals("ZAKHM"))
        {
           v = inflater.inflate(R.layout.step3_3, container , false);
        }
        if (Step2.MOSHAVERE.equals("KABED")) {
            v = inflater.inflate(R.layout.step3_4, container, false);
        }


        Typeface tf = Typeface.createFromAsset(getResources().getAssets() , "IranSans.ttf");

        btn_next = v.findViewById(R.id.btn_next);
        Text_titr =v.findViewById(R.id.txt_titr);

        CB_ezafe = v.findViewById(R.id.cb_ezafe);
        RB_bazo = v.findViewById(R.id.rb_bazo);
        RB_basan = v.findViewById(R.id.rb_basan);
        RB_ran = v.findViewById(R.id.rb_ran);
        RB_shekam = v.findViewById(R.id.rb_shekam);

        btn_next.setTypeface(tf);
        Text_titr.setTypeface(tf);
        CB_ezafe.setTypeface(tf);
        RB_shekam.setTypeface(tf);
        RB_ran.setTypeface(tf);
        RB_basan.setTypeface(tf);
        RB_bazo.setTypeface(tf);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentTransaction ft = Main_Register.fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_in_left, R.anim.exit_to_right, R.anim.enter_in_right, R.anim.exit_to_left);
                ft.replace(R.id.content_layout , new Step4());
                ft.addToBackStack("a");
                ft.commit();
            }
        });

        return v;
    }
}

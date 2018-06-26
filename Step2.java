package com.shunico.newshapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by a on 5/30/2018.
 */

public class Step2 extends Fragment {


    Button btn_next;
    TextView text_faaliat;
    TextView text_moshavere;
    TextView text_tozihat;

    RadioGroup rg_moshavere1;
    RadioGroup rg_moshavere2;
    RadioGroup rg_faaliat1;
    RadioGroup rg_faaliat2;

    AppCompatRadioButton rb_diabet;
    AppCompatRadioButton rb_zakhmmede;
    AppCompatRadioButton rb_tanasob;
    AppCompatRadioButton rb_kabed;

    AppCompatRadioButton rb_very_kam;
    AppCompatRadioButton rb_kam;
    AppCompatRadioButton rb_motevaset;
    AppCompatRadioButton rb_ziad;
    AppCompatRadioButton rb_very_ziad;

    static String MOSHAVERE = "";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.step2 , container , false);

        Typeface tf = Typeface.createFromAsset(getResources().getAssets() , "IranSans.ttf");

        btn_next = v.findViewById(R.id.btn_next);
        text_faaliat = v.findViewById(R.id.txt_faaliat);
        text_moshavere = v.findViewById(R.id.txt_moshavere);
        text_tozihat = v.findViewById(R.id.txt_tozihat_faaliat);

        rg_moshavere1 = v.findViewById(R.id.rg_moshavere1);
        rg_moshavere2 = v.findViewById(R.id.rg_moshavere2);
        rg_faaliat1 = v.findViewById(R.id.rg_faaliat1);
        rg_faaliat2 = v.findViewById(R.id.rg_faaliat2);

        rb_diabet = v.findViewById(R.id.rb_diabet);
        rb_zakhmmede = v.findViewById(R.id.rb_zakhmede);
        rb_tanasob = v.findViewById(R.id.rb_tanasob);
        rb_kabed = v.findViewById(R.id.rb_kabed);

        rb_very_kam = v.findViewById(R.id.rb_very_kam);
        rb_kam = v.findViewById(R.id.rb_kam);
        rb_motevaset = v.findViewById(R.id.rb_motavaset);
        rb_ziad = v.findViewById(R.id.rb_ziad);
        rb_very_ziad = v.findViewById(R.id.rb_very_ziad);

        btn_next.setTypeface(tf);
        text_moshavere.setTypeface(tf , 1);
        text_faaliat.setTypeface(tf , 1);
        text_tozihat.setTypeface(tf);

        rb_zakhmmede.setTypeface(tf);
        rb_tanasob.setTypeface(tf);
        rb_kabed.setTypeface(tf);
        rb_diabet.setTypeface(tf);

        rb_very_kam.setTypeface(tf);
        rb_kam.setTypeface(tf);
        rb_motevaset.setTypeface(tf);
        rb_ziad.setTypeface(tf);
        rb_very_ziad.setTypeface(tf);


        rg_moshavere1.clearCheck();
        rg_moshavere2.clearCheck();

        rg_faaliat1.clearCheck();
        rg_faaliat2.clearCheck();


        rg_moshavere1.setOnCheckedChangeListener(listener_moshavere1);
        rg_moshavere2.setOnCheckedChangeListener(listener_moshavere2);

        rg_faaliat1.setOnCheckedChangeListener(listener_faaliat1);
        rg_faaliat2.setOnCheckedChangeListener(listener_faaliat2);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!MOSHAVERE.equals(""))
                {
                    FragmentTransaction ft = Main_Register.fm.beginTransaction();
                    ft.setCustomAnimations(R.anim.enter_in_left, R.anim.exit_to_right, R.anim.enter_in_right, R.anim.exit_to_left);
                    ft.replace(R.id.content_layout , new Step3());
                    ft.addToBackStack("a");
                    ft.commit();
                }
                else
                    Toast.makeText(getContext(), "sdv;lmsvl;,", Toast.LENGTH_SHORT).show();

            }
        });

        return v;
    }



    private RadioGroup.OnCheckedChangeListener listener_moshavere1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg_moshavere2.setOnCheckedChangeListener(null);
                rg_moshavere2.clearCheck();
                rg_moshavere2.setOnCheckedChangeListener(listener_moshavere2);
            }


            switch (checkedId)
            {
                case R.id.rb_tanasob:
                    Log.e("RG" , "tanasob");
                    MOSHAVERE = "TANASOB";
                break;

                case R.id.rb_diabet:
                    Log.e("RG" , "diabet");
                    MOSHAVERE = "DIABET";
                break;
            }




        }
    };

    private RadioGroup.OnCheckedChangeListener listener_moshavere2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg_moshavere1.setOnCheckedChangeListener(null);
                rg_moshavere1.clearCheck();
                rg_moshavere1.setOnCheckedChangeListener(listener_moshavere1);
            }


            switch (checkedId)
            {
                case R.id.rb_kabed:
                    Log.e("RG" , "kabed");
                    MOSHAVERE = "KABED";
                    break;

                case R.id.rb_zakhmede:
                    Log.e("RG" , "zakhm");
                    MOSHAVERE = "ZAKHM";
                    break;
            }

        }
    };

    private RadioGroup.OnCheckedChangeListener listener_faaliat1 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg_faaliat2.setOnCheckedChangeListener(null);
                rg_faaliat2.clearCheck();
                rg_faaliat2.setOnCheckedChangeListener(listener_faaliat2);
            }


            switch (checkedId)
            {
                case R.id.rb_very_kam:
                    Log.e("RG" , "kh kam");
                    text_tozihat.setText("شامل فعالیت های روزانه و ورزش کمتر از 1 ساعت در هفته");
                    break;

                case R.id.rb_kam:
                    Log.e("RG" , "kam");
                    text_tozihat.setText("شامل فعالیت های روزانه و ورزش 1 روز در هفته ");
                    break;

                case R.id.rb_motavaset:
                    Log.e("RG" , "mot");
                    text_tozihat.setText("شامل ورزش کردن تقریبا 3 روز در هفته");
                    break;
            }

        }
    };

    private RadioGroup.OnCheckedChangeListener listener_faaliat2 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1) {
                rg_faaliat1.setOnCheckedChangeListener(null);
                rg_faaliat1.clearCheck();
                rg_faaliat1.setOnCheckedChangeListener(listener_faaliat1);
            }


            switch (checkedId)
            {
                case R.id.rb_ziad:
                    Log.e("RG" , "ziad");
                    text_tozihat.setText("شامل فعالیت های روزانه و ورزش کردن 2 تا 4 روز در هفته");
                    break;

                case R.id.rb_very_ziad:
                    Log.e("RG" , "kh ziad");
                    text_tozihat.setText("شامل ورزش های منظم و روزانه بین 1 تا 2 ساعت ورزش");
                    break;
            }

        }
    };
}

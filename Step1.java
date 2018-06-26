package com.shunico.newshapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
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

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

/**
 * Created by a on 5/29/2018.
 */

public class Step1 extends Fragment {

    com.shawnlin.numberpicker.NumberPicker numberPicker_vazn;
    com.shawnlin.numberpicker.NumberPicker numberPicker_vazn_ashar;
    com.shawnlin.numberpicker.NumberPicker numberPicker_shakhes;
    com.shawnlin.numberpicker.NumberPicker numberPicker_qad;

    TextView text_vazn;
    TextView text_qad;
    TextView text_jens;

    RadioGroup rg;
    AppCompatRadioButton rb_man;
    AppCompatRadioButton rb_woman;

    Button birthday;
    Button btn_next;

    PersianCalendar initDate;
    PersianDatePickerDialog picker;

    Typeface tf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.step1, container, false);


         tf = Typeface.createFromAsset(getResources().getAssets() , "IranSans.ttf");

        String[] vazn_ashar = getActivity().getResources().getStringArray(R.array.vazn_ashar);
        String[] shakhes = {"کیلوگرم"};


        numberPicker_vazn_ashar = v.findViewById(R.id.numberpicker_vaznashar);
        numberPicker_vazn = v.findViewById(R.id.numberpicker_vazn);
        numberPicker_shakhes = v.findViewById(R.id.numberpicker_shakhes);
        numberPicker_qad = v.findViewById(R.id.numberpicker_qad);

        numberPicker_vazn_ashar.setDisplayedValues(vazn_ashar);
        numberPicker_vazn_ashar.setMaxValue(vazn_ashar.length);

        numberPicker_shakhes.setDisplayedValues(shakhes);
        numberPicker_shakhes.setMaxValue(shakhes.length);

        text_vazn = v.findViewById(R.id.txt_vazn);
        text_qad = v.findViewById(R.id.txt_qad);
        text_jens = v.findViewById(R.id.txt_jens);


        rb_man = v.findViewById(R.id.rb_man);
        rb_woman = v.findViewById(R.id.rb_woman);

        rg = v.findViewById(R.id.rg);

        birthday = v.findViewById(R.id.birthday);
        btn_next = v.findViewById(R.id.btn_next);

        numberPicker_vazn_ashar.setTypeface(tf);
        numberPicker_vazn.setTypeface(tf);
        numberPicker_shakhes.setTypeface(tf);
        numberPicker_qad.setTypeface(tf);


        text_vazn.setTypeface(tf);
        text_qad.setTypeface(tf);
        text_jens.setTypeface(tf);


        rb_man.setTypeface(tf);
        rb_woman.setTypeface(tf);

        birthday.setTypeface(tf);
        btn_next.setTypeface(tf);



        rg.setOnCheckedChangeListener(listener3);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                FragmentTransaction ft = Main_Register.fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_in_left, R.anim.exit_to_right, R.anim.enter_in_right, R.anim.exit_to_left);
                ft.replace(R.id.content_layout , new Step2() , "MY_FRAGMENT");
                ft.addToBackStack("a");
                ft.commit();
            }
        });


        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCalendar();
            }
        });




        return v;
    }


    private RadioGroup.OnCheckedChangeListener listener3 = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId)
            {
                case R.id.rb_man:
                    Log.e("JENS" , rb_man.getText().toString()+ "");
                    break;
                case R.id.rb_woman:
                    Log.e("JENS" , rb_woman.getText().toString()+ "");

                    break;
                default:
                    break;
            }

        }
    };




    public void showCalendar() {

        initDate = new PersianCalendar();
        initDate.setPersianDate(1370, 1, 1);



        picker = new PersianDatePickerDialog(getContext())
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setMinYear(1300)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setInitDate(initDate)
                .setActionTextColor(Color.GRAY)
                .setTypeFace(tf)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {

                            birthday.setText( persianCalendar.getPersianYear() + "/" +
                                    persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay());
                            birthday.setTypeface(tf , 1);
                    }

                    @Override
                    public void onDismissed() {

                    }
                });

        picker.show();
    }
}

package com.shunico.newshapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import Lib.CircularProgressBar;

/**
 * Created by a on 6/5/2018.
 */

public class Step4 extends Fragment {


    CircularProgressBar c1 ,c2 , c3 ,c4 , c5 , c6;
    Button btn_next;
    TextView status;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.step4, container, false);


        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "IranSans.ttf");

        btn_next = v.findViewById(R.id.btn_next);

        btn_next.setTypeface(tf);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentTransaction ft = Main_Register.fm.beginTransaction();
                ft.setCustomAnimations(R.anim.enter_in_left, R.anim.exit_to_right, R.anim.enter_in_right, R.anim.exit_to_left);
                ft.replace(R.id.content_layout, new Step5());
                ft.addToBackStack("a");
                ft.commit();
            }
        });


        c1 = (CircularProgressBar) v.findViewById(R.id.circularprogressbar1);
        c2 = (CircularProgressBar) v.findViewById(R.id.circularprogressbar2);
        c3 = (CircularProgressBar) v.findViewById(R.id.circularprogressbar3);
        c4 = (CircularProgressBar) v.findViewById(R.id.circularprogressbar4);
        c5 = (CircularProgressBar) v.findViewById(R.id.circularprogressbar5);
        c6 = (CircularProgressBar) v.findViewById(R.id.circularprogressbar6);

        c1.animateProgressTo(0, 47, new CircularProgressBar.ProgressAnimationListener() {

            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationProgress(int progress) {
                c1.setTitle(progress + "");
            }

            @Override
            public void onAnimationFinish() {
                c1.setSubTitle("....");
            }
        });

        c2.animateProgressTo(0, 53, new CircularProgressBar.ProgressAnimationListener() {

            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationProgress(int progress) {
                c2.setTitle(progress + "");
            }

            @Override
            public void onAnimationFinish() {
                c2.setSubTitle("....");
            }
        });

        c3.animateProgressTo(0, 22, new CircularProgressBar.ProgressAnimationListener() {

            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationProgress(int progress) {
                c3.setTitle(progress + "");
            }

            @Override
            public void onAnimationFinish() {
                c3.setSubTitle("توده حجمی");
            }
        });

        c4.animateProgressTo(0, 28, new CircularProgressBar.ProgressAnimationListener() {

            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationProgress(int progress) {
                c4.setTitle(progress + "");
            }

            @Override
            public void onAnimationFinish() {
                c4.setSubTitle("سن");
            }
        });
        c5.animateProgressTo(0, 87, new CircularProgressBar.ProgressAnimationListener() {

            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationProgress(int progress) {
                c5.setTitle(progress + "");
            }

            @Override
            public void onAnimationFinish() {
                c5.setSubTitle("وزن");
            }
        });
        c6.animateProgressTo(0, 176, new CircularProgressBar.ProgressAnimationListener() {

            @Override
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationProgress(int progress) {
                c6.setTitle(progress + "");
            }

            @Override
            public void onAnimationFinish() {
                c6.setSubTitle("قد");
            }
        });


        status = v.findViewById(R.id.txt_status);
        status.setText("شما در سلامتی کامل به سر می برید");
        status.setTypeface(tf);

        return v;

    }
}

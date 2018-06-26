package com.shunico.newshapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by a on 6/5/2018.
 */

public class Step5 extends Fragment {

    Button btn_end;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.step5 , container , false);


        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "IranSans.ttf");

        btn_end = v.findViewById(R.id.btn_next);

        btn_end.setTypeface(tf);


        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity() , MainActivity.class));
//
//                FragmentTransaction ft = Main_Register.fm.beginTransaction();
//                ft.setCustomAnimations(R.anim.enter_in_left, R.anim.exit_to_right, R.anim.enter_in_right, R.anim.exit_to_left);
//                ft.replace(R.id.content_layout, new Step5());
//                ft.addToBackStack("a");
//                ft.commit();
            }
        });


        return v;
    }
}

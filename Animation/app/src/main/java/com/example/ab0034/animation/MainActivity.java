package com.example.ab0034.animation;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView BtnAnim;
    Animation animFadeIn, animFadeOut, downtoup, uptodown, zoom_in, img_one, img_two, img_three;
    View Dialogview;
    int Cananimate = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BtnAnim = (ImageView) findViewById(R.id.BtnAnim);


//        s.start();
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);
        downtoup = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.downtoup);
        uptodown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.uptodown);
        zoom_in = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoon_in);
        img_one = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.img_one);
        img_two = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.img_two);
        img_three = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.img_three);
        BtnAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Popup();
            }
        });
    }

    private void Popup() {
        AlertDialog.Builder Dialogbuilder = new AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog);
        LayoutInflater layoutInflater = (LayoutInflater) getLayoutInflater();
        View Dialogview = layoutInflater.inflate(R.layout.popup, null);
        Dialogbuilder.setView(Dialogview);
        TextView Test = (TextView) Dialogview.findViewById(R.id.Test);
        final ImageView Img1, Img2, Img3;

        Img1 = (ImageView) Dialogview.findViewById(R.id.Img1);

        Img2 = (ImageView) Dialogview.findViewById(R.id.Img2);
        Img3 = (ImageView) Dialogview.findViewById(R.id.Img3);
////        main.setAnimation(downtoup);

        Img1.startAnimation(img_one);

        img_one.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Img1.setVisibility(View.VISIBLE);
                switch (Cananimate) {
                    case -1:
                        Img1.setVisibility(View.VISIBLE);
                        Cananimate++;
                        break;
                    case 0:
                        Img2.setVisibility(View.VISIBLE);
                        Cananimate++;
                        break;
                    case 1:
                        Img3.setVisibility(View.VISIBLE);
                        Cananimate = -1;
                        break;
                }

            }

            @Override
            public void onAnimationEnd(Animation animation) {

//                switch (Cananimate){
//                    case 0:
                if (Cananimate == 0) {
                    Img1.clearAnimation();
                    Img2.setVisibility(View.VISIBLE);
                    Img2.startAnimation(img_one);
//                        break;
                } else if (Cananimate == 1) {
//                    case 1:
                    Img2.clearAnimation();
                    Img3.setVisibility(View.VISIBLE);
                    Img3.startAnimation(img_one);
//                        break;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//
//                Img2.setAnimation(img_one);
//
//                Img3.setAnimation(img_one);
//            }
//        },500);
//
//        Img2.setAnimation(img_two);
//
//
//        Img3.setAnimation(img_three);
//

        final AlertDialog alertDialog = Dialogbuilder.create();
        Window window = alertDialog.getWindow();
        alertDialog.getWindow().setBackgroundDrawable(
                getResources().getDrawable(R.drawable.bg));
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.animationdialog;
//        alertDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        alertDialog.show();
        Img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Issue Book", Toast.LENGTH_SHORT).show();
            }
        });
        Img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        Img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Collect Book", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

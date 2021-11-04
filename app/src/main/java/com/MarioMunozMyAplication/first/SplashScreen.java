package com.MarioMunozMyAplication.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //openApp(true);

        //implementar animacion
        ImageView mBolt= findViewById(R.id.bolt);
        /*Animation myanim= AnimationUtils.loadAnimation(this, R.anim.fadein);
        mBolt.startAnimation(myanim);*/

        Animation rotate= AnimationUtils.loadAnimation(this, R.anim.rotate_animation1);
        mBolt.startAnimation(rotate);

        openApp(true);

        //implementar fondo del splash, cargandolo desde una URL
        ImageView mBack= findViewById(R.id.fondoSplash);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1444080748397-f442aa95c3e5?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1032&q=80")
                //.load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia)))
                //.circleCrop()
                .into(mBack);
    }

   /*
        public void clickSplash(View view) {
        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);
    }*/

    //Esta clase sirve para abrir directamente el login
    private  void openApp(boolean locationPermission){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
            }
        },2000);
    }

}
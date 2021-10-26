package com.MarioMunozMyAplication.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView mBolt= findViewById(R.id.bolt);
    }

    public void clickSplash(View view) {
        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);
    }


}
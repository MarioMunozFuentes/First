package com.MarioMunozMyAplication.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;


/**
 * @author MarioMuñozFuentes
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //glide for loading girls
        ImageView mGirl= findViewById(R.id.girl);

        Glide.with(this)
                .load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(400))
                //.load("https://images.unsplash.com/photo-1459802071246-377c0346da93?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=409&q=80")
                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia)))
                .into(mGirl);


    }



    public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openSingUp(View v) {
        Intent intent = new Intent(LoginActivity.this, SingUp.class);
        startActivity(intent);

    }
}


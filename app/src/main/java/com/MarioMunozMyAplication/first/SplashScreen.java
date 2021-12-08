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

/**
 * @author Asier97am
 * trabajando en mejora de animación a
 */

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen); //referenciamos este documento de java al xml asociado
        openApp(true);

        //implementar animacion
        //.load carga un drawable para el fondo
        //.placeholder si no consigue cargar la foto te pone un fondo (ejemplo de instagram)
        // .centerCrop me rellena todoo
        //  //.into indica donde se aplican los atributos
        ImageView mMuscle= findViewById(R.id.muscle);
        /*Animation myanim= AnimationUtils.loadAnimation(this, R.anim.fadein);
        mBolt.startAnimation(myanim);*/
        Animation rotate= AnimationUtils.loadAnimation(this, R.anim.rotate_animation1);
        mMuscle.startAnimation(rotate);

        //implementar fondo del splash, cargandolo desde una URL
        ImageView mBack= findViewById(R.id.fondoSplash);
        Glide.with(this)
                .load(R.drawable.gymfondo)
                //.load(R.drawable.girl)
                .transition(DrawableTransitionOptions.withCrossFade(100))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.fucsia)))
                //.circleCrop()
                .into(mBack);
    }



    //Esta clase sirve para abrir directamente el login
    private  void openApp(boolean locationPermission){
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() { //si queremos poner banderas para que no se pueda volver al Splash irian dentro del run
                Intent intent= new Intent(SplashScreen.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //creamos bandera
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); //limpiamos para no poder volver
                startActivity(intent); //con esto vamos al la siguiente ventana indicandolo conintent
            }
        },2000); //espeamos 2 segundos en la animacion
    }

    /* sirve para pinchar el logo e ir al main
        public void clickSplash(View view) {
        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);
    }*/

}
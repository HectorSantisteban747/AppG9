package com.example.appg9;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {
    public static final long  SPLASH_SCREEN_DALEY=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //Bloquear rotacion de pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //ocultar barra de notificaciones
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //ocultar actionbar
        getSupportActionBar().hide();
        //Temporizacion
        TimerTask timerTask= new TimerTask() {
            @Override
            public void run() {
                Intent newIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(newIntent);

            }
        };
        Timer timer= new Timer();
        timer.schedule(timerTask, SPLASH_SCREEN_DALEY);
    }
}
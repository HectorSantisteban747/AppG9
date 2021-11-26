package com.example.appg9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.appg9.databinding.ActivityMapsBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> datos;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.i("información","onCreate");

        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        recycler .setLayoutManager(new LinearLayoutManager(this));
        datos = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datos.add("dato #: " + i);
        }
        AdapterEvents adapterEvents = new AdapterEvents(datos);
        recycler.setAdapter(adapterEvents);
    }
    public void gotoActivityLogin(View view){
        Intent newIntent = new Intent(this , activity_login.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(newIntent);
    }
    public void gotoActivityMap(View view){
        Intent newIntent = new Intent(this , MapsActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(newIntent);
    }
    @Override
    protected void onStart(){
        super.onStart();

    }
    @Override
    protected void onResume(){
        super.onResume();

    }

    @Override
    protected void onPause(){
        super.onPause();

    }

    @Override
    protected void onStop(){
        super.onStop();

    }
    @Override
    protected void onRestart(){
        super.onRestart();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
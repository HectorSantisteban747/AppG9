package com.example.appg9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    ArrayList<Event> eventList;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.i("información","onCreate");

        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        recycler .setLayoutManager(new LinearLayoutManager(this));
        eventList = new ArrayList<>();
        addEvent();
        AdapterEvents adapterEvents = new AdapterEvents(eventList);
        recycler.setAdapter(adapterEvents);

//        FloatingActionButton ubication = (FloatingActionButton) findViewById()
    }

    private void addEvent() {
        eventList.add(new Event(R.drawable.one,"evento 1", "generico", new Date(), new Date(), "contacto", 10.000));
        eventList.add(new Event(R.drawable.two,"evento 2", "generico", new Date(), new Date(), "contacto2", 20.000));
        eventList.add(new Event(R.drawable.one,"evento 1", "generico", new Date(), new Date(), "contacto", 10.000));
        eventList.add(new Event(R.drawable.two,"evento 2", "generico", new Date(), new Date(), "contacto2", 20.000));

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
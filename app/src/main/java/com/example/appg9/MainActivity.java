package com.example.appg9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.appg9.databinding.ActivityMapsBinding;
import com.example.appg9.utilities.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    ArrayList<Event> eventList;
    RecyclerView recycler;
    ConnexionSqlLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.i("información","onCreate");

        conn = new ConnexionSqlLiteHelper(getApplicationContext(), "db_events", null, 1);
        eventList = new ArrayList<>();

        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        recycler .setLayoutManager(new LinearLayoutManager(this));
        addEvent();

        AdapterEvents adapterEvents = new AdapterEvents(eventList);
        recycler.setAdapter(adapterEvents);
        try {
            consultarEventos();
        } catch (ParseException e) {
            Toast.makeText(getApplicationContext(), "NO hay datos en la db", Toast.LENGTH_SHORT).show();
        }
    }

    private void consultarEventos() throws ParseException {
        SQLiteDatabase db = conn.getReadableDatabase();

        Event event = null;
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilities.TABLA_EVENTS, null);
        while(cursor.moveToNext()){
           //Date date = new SimpleDateFormat("dd/mm/yyyy").parse(cursor.getString(3));
           //Date time = new SimpleDateFormat("dd/mm/yyyy").parse(cursor.getString(4));

            event = new Event(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getString(4), cursor.getLong(5) );

            eventList.add(event);

            AdapterEvents adapterEvents = new AdapterEvents(eventList);
            recycler.setAdapter(adapterEvents);
        }
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

    public void goToFormNewEvent(View view){
        Intent newIntent = new Intent(this , CreateEvent.class);
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
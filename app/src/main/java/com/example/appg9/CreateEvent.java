package com.example.appg9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appg9.utilities.Utilities;

public class CreateEvent extends AppCompatActivity {

    ImageView img;
    EditText name_event, type, time, date, value, contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        img = (ImageView) findViewById(R.id.new_img_form);
        name_event = (EditText) findViewById(R.id.event_form_id);
        type = (EditText) findViewById(R.id.type_form_id);
        time = (EditText) findViewById(R.id.time_form_id);
        date = (EditText) findViewById(R.id.date_form_id);
        value = (EditText) findViewById(R.id.value_form_id);
        contact = (EditText) findViewById(R.id.contact_form_id);
    }

    public void crearteEvent(View view){
        registrarUsuario();
        Intent newIntent = new Intent(this , MainActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(newIntent);
    }

    private void registrarUsuario(){
        ConnexionSqlLiteHelper conn = new ConnexionSqlLiteHelper(this, "db_events", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(Utilities.CAMPO_IMG,);
        values.put(Utilities.CAMPO_EVENT, name_event.getText().toString());

        Long idResult = db.insert(Utilities.TABLA_EVENTS, Utilities.CAMPO_CONTACT, values);
        Toast.makeText(getApplicationContext(), "Evento Creado" + idResult, Toast.LENGTH_SHORT).show();
        db.close();
    }

    public void gotoActivityMap(View view) {
        Intent newIntent = new Intent(this,MapsActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(newIntent);
    }

    public void loagImg(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleccione La aplicacion"), 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri path = data.getData();
            img.setImageURI(path);
        }
    }
}
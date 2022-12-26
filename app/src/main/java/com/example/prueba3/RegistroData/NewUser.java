package com.example.prueba3.RegistroData;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.example.prueba3.DataBase.DBHelper;
import com.example.prueba3.MainActivity;
import com.example.prueba3.R;

public class NewUser extends AppCompatActivity {
    EditText Etusurname, EtPass, renewpass;
    TextInputLayout inputLayout;
    TextInputEditText inputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Etusurname = (EditText) findViewById(R.id.eduserparented);
        EtPass = (EditText) findViewById(R.id.edcontranewed);
        renewpass = (EditText) findViewById(R.id.edcontranewedoption);
        inputLayout = (TextInputLayout) findViewById(R.id.edcolorfavorito);
        inputEditText = (TextInputEditText) findViewById(R.id.edrespuestacolor);
    }

/*Metodo Para registrar los datos del usuario*/
public void RegistrarDataUser(View v) {
/*creamos un objeto de la clase DBHelper
 inicializamos el constructor
 nombramos la base de datos
 version de la base de datos*/
    DBHelper admin = new DBHelper(this, "prueba3.db", null, 1);
/*Abrimos la base de datos para escritura*/
            SQLiteDatabase db = admin.getWritableDatabase();
/*creamos dos variables string
 inicializamos y convertimos*/
    String UserName = Etusurname.getText().toString();
    String PassUser = EtPass.getText().toString();
    String renewspasw = renewpass.getText().toString();
    String colorFavorito = inputEditText.getText().toString();
    Log.v("Error", "pass1" + PassUser + " pass 2" + renewspasw);
    if (!EtPass.getText().toString().equals(renewspasw)) {
        EtPass.setError("Valores tienen que conincidir");
        renewpass.setError("Valores tienen que conincidir");
    } else if (EtPass.getText().toString().equals(renewspasw)) {
/*Creamos un objeto contentvalues y instanciamos*/
        ContentValues values = new ContentValues();
/*capturamos valores*/
        values.put ("username", UserName);
        values.put("clave_user", PassUser);
        values.put("color_favorito", colorFavorito);
/*llamamos al insert damos el nombre de la base de datos
                y los valores*/
        db.insert("userstable", null, values);
/*cerramos la base de datos*/
                db.close();
/*Lanzamos una notificacion toast*/
        Toast ToastMens = Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT);
/*mostramos el toast*/
                ToastMens.show();
/*lanzamos la actividad*/
                Intent intent = new Intent(this, MainActivity.class);
/*iniciamos la actividad*/
                startActivity(intent);
        finish();
    }
}
}


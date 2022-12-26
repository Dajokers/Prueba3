package com.example.prueba3.restablecer;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba3.R;
import com.google.android.material.textfield.TextInputEditText;

public class Recuperar extends AppCompatActivity {

    // Creamos una variable para el edittext donde se escribira la respuesta
    TextInputEditText etrespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        // Emparejamos la variable con el id del edittext
        etrespuesta = (TextInputEditText) findViewById(R.id.edrespuestacolor);
    }

    /**
     * Método que se ejecutará cuando se haga clic en el botón
     */
    public void RegistrarDataUser(View view) {
// Obtenemos el valor del edittext
        String respuesta = etrespuesta.getText().toString();
        // Realizamos alguna acción con la respuesta, como por ejemplo, enviarla a una base de datos o verificar si es correcta
        //// Tu código aquí
        if (respuesta.equals("")) {
            //// Si la respuesta es correcta, mostramos un mensaje de éxito al usuario
            Toast.makeText(this, "La respuesta es correcta", Toast.LENGTH_LONG).show();
        } else {
            //// Si la respuesta es incorrecta, mostramos un mensaje de error al usuario
            Toast.makeText(this, "La respuesta es incorrecta", Toast.LENGTH_LONG).show();
        }
    }
}

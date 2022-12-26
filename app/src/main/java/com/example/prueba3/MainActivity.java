package com.example.prueba3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prueba3.DataBase.DBHelper;
import com.example.prueba3.Principal.Index;
import com.example.prueba3.RegistroData.NewUser;
import com.example.prueba3.restablecer.Recuperar;

public class MainActivity extends AppCompatActivity {
    //creamos la variables locales que utlizaremos
    //Editext
    EditText et1, et2;
    //Cursor
    private Cursor fila;
    String usua;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //emparejamos las variable con el xml editText usuario y password
        et1 = (EditText) findViewById(R.id.edusername);
        et2 = (EditText) findViewById(R.id.edcontra);
    }
    /**metodo para el boton entrar*/
    public void entrar(View v) {
        DBHelper admin = new DBHelper(this, "prueba3.db", null, 1);
        /*Abrimos la base de datos como escritura*/
        SQLiteDatabase db = admin.getWritableDatabase();
        String usuario = et1.getText().toString();
        String contrasena = et2.getText().toString();
        fila = db.rawQuery("select id_user,username,clave_user from userstable where username='" +
                usuario + " and clave_user='" + contrasena + "'", null);
        try {
            /*Condicional if preguntamos si cursor tiene algun dato*/
            if (fila.moveToFirst()) {
                //capturamos los valores del cursor y lo almacenamos en variable
                usua = fila.getString(1);
                pass = fila.getString(2);
                Log.d("QUERY", "Usuario" + usua + " password " + pass);
                //preguntamos si los datos ingresados son iguales
                if (usuario.equals(usua) && contrasena.equals(pass)) {
                    //si son iguales entonces vamos a otra ventana
                    //Menu es una nueva actividad empty
                    Intent ven = new Intent(this, Index.class);
//lanzamos la actividad
                    startActivity(ven);
                }
            }//si la primera condicion no cumple entonces que envie un mensaje toast
            else {
                Toast toast = Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG);
//mostramos el toast
                toast.show();
            }
        } catch (Exception e) {//capturamos los errores que ubieran
            Toast toast = Toast.makeText(this, "Error" + e.getMessage(), Toast.LENGTH_LONG);
//mostramos el mensaje
            toast.show();
        }
    }
    /**metodo para el boton entrar*/
    public void RegistroData(View v) {
        //creamos una variables e instanciamos al intent para que me muestra la clase
        Intent rdata = new Intent(this, NewUser.class);
        //lanzamos la actividad
        startActivity(rdata);
    }
    /**metodo para el boton restablecer*/
    public void restablecer(View v) {
        //creamos una variables e instanciamos al intent para que me muestra la clase
        Intent rdata = new Intent(this, Recuperar.class);
        //lanzamos la actividad
        startActivity(rdata);
    }
}

//<intent-filter>
//                <action android:name="android.intent.action.MAIN" />
//                <category android:name="android.intent.category.LAUNCHER" />
//            </intent-filter>
//            <intent-filter>
//                <action android:name="com.example.prueba3.REGISTER_USER" />
//                <category android:name="android.intent.category.DEFAULT" />
//            </intent-filter>
// pal androidManifest





















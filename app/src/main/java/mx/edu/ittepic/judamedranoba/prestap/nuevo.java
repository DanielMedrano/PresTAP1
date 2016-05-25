package mx.edu.ittepic.judamedranoba.prestap;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class nuevo extends Activity {
    private int año;
    private int mes;
    private int dia;
    private TextView campoFecha;
    private Button botonFecha;
    private TextView fechasis;
    private static final int ID_DIALOGO=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        campoFecha=(TextView) findViewById(R.id.campoFecha);
        botonFecha=(Button) findViewById(R.id.butonFecha);
        fechasis=(TextView) findViewById(R.id.fechaSis);
        Calendar calendario= Calendar.getInstance();
        año=calendario.get(Calendar.YEAR);
        mes=calendario.get(Calendar.MONTH);
        dia=calendario.get(Calendar.DAY_OF_MONTH);
        mostrarSis();
        oyenteSelectorFecha=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
               año=year;
                mes=monthOfYear;
                dia=dayOfMonth;
                mostrarFecha();
            }
        };

    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this,oyenteSelectorFecha,año,mes,dia);
        }
        return null;

    }

        public void mostrarcalendario(View control){
            showDialog(ID_DIALOGO);
        }
    public void mostrarFecha(){
        campoFecha.setText(año+"/"+(mes+1)+"/"+dia);
    }
    public void mostrarSis(){
        fechasis.setText(año+"/"+(mes+1)+"/"+dia);
    }


        }






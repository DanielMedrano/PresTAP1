package mx.edu.ittepic.judamedranoba.prestap;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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

    DBHelper dbHelper;
    EditText nombrePre;
    EditText nombreobj;
    EditText descrip;
    String status = "Prestado";

    private int año;
    private int mes;
    private int dia;
    private int año1;
    private int mes1;
    private int dia1;
    private TextView campoFecha;
    private Button botonFecha;
    private TextView fechasis;
    private static final int ID_DIALOGO=0;
    private static DatePickerDialog.OnDateSetListener oyenteSelectorFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);
        dbHelper = new DBHelper(this);
        nombrePre = (EditText) findViewById(R.id.nombrePre);
        nombreobj = (EditText) findViewById(R.id.nombreObj);
        descrip = (EditText) findViewById(R.id.descrip);
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
               año1=year;
                mes1=monthOfYear;
                dia1=dayOfMonth;
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
        campoFecha.setText(año1+"/"+(mes1+1)+"/"+dia1);
    }
    public void mostrarSis(){
        fechasis.setText(año+"/"+(mes+1)+"/"+dia);
    }

      public void guardar(View view){

          if(ValidarCam()) {
              if (ValidarFecha()){
               Prestamo prestamo = new Prestamo(nombreobj.getText().toString(), descrip.getText().toString(), fechasis.getText().toString(), campoFecha.getText().toString(), status, nombrePre.getText().toString());
              dbHelper.addprestamo(prestamo);
              confirmacion();
                  limpiarpantalla();
              }
            else{
                  Toast.makeText(this,"Fecha invalida",
                          Toast.LENGTH_LONG).show();
              }
          } else{
              Toast.makeText(this,"Ha dejado campos vacios ",
                      Toast.LENGTH_LONG).show();

          }

      }
    public  boolean ValidarCam(){
        String campoFecha=this.campoFecha.getText().toString();
        if (TextUtils.isEmpty(campoFecha)){
            return false;
        }
        String nombrePre=this.nombrePre.getText().toString();
        if (TextUtils.isEmpty(nombrePre)){
            return false;
        }
        String nombreObj=this.nombreobj.getText().toString();
        if (TextUtils.isEmpty(nombreObj)){
            return false;
        }
        String descrip= this.descrip.getText().toString();
        if(TextUtils.isEmpty(descrip)){
            return false;
        }
        return true;
    }
    public boolean ValidarFecha(){


        if(this.año1 >= this.año && this.mes1 > this.mes ){
            return  true;
        }
        if (this.año1 >=this.año && this.mes1== this.mes && this.dia1 > this.dia ){
            return true;
        }

        return false;
    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha agregado exitosamente!");
        dlgAlert.setTitle("Agregar Objeto");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
public void limpiarpantalla(){
    nombreobj.setText("");
    nombrePre.setText("");
    descrip.setText("");
    campoFecha.setText("");
}
        }






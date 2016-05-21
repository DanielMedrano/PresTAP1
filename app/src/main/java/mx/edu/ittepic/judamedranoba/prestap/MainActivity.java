package mx.edu.ittepic.judamedranoba.prestap;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;


public class MainActivity extends Activity {

    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     mydb = new DBHelper(this);


    }

    public void acerca(View view){
        Intent intent = new Intent(this,acerca.class);
        startActivity(intent);
    }

    public void nuevo(View view){
        Intent intent = new Intent(this,nuevo.class);
        startActivity(intent);
    }

    public void consultaprestamo(View view){
        Intent intent = new Intent(this,consulta_prestamo.class);
        startActivity(intent);
    }

}

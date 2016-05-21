package mx.edu.ittepic.judamedranoba.prestap;

import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class nuevo_prestamo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo);
/*
        final DatePicker dp =(DatePicker)findViewById(R.id.dp);
        final Button setBtn=(Button)findViewById(R.id.set);

        setBtn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(nuevo_prestamo.this,dp.getDayOfMonth()+ " " + dp.getMonth() + " " + dp.getYear(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }


}

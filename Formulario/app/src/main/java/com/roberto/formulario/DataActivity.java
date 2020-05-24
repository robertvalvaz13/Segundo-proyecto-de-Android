package com.roberto.formulario;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class DataActivity extends AppCompatActivity {
    private TextView nombre, fecha, telefono, correo, desc;
    private String fechaNaci;

    private MaterialButton editar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        nombre = findViewById(R.id.nombre);
        telefono = findViewById(R.id.telefono);
        correo = findViewById(R.id.correo);
        desc = findViewById(R.id.descrip);
        fecha = findViewById(R.id.fecha);

        editar = findViewById(R.id.editData);

        nombre.setText(MainActivity.name.getEditableText());
        telefono.setText(MainActivity.phone.getEditableText());
        correo.setText(MainActivity.email.getEditableText());
        desc.setText(MainActivity.description.getEditableText());

        fechaNaci = MainActivity.bday.getDayOfMonth() + "/" + MainActivity.bday.getMonth() + "/" + MainActivity.bday.getYear();
        fecha.setText(fechaNaci);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}

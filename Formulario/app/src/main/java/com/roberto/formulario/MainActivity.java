package com.roberto.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private MaterialButton next;
    public static DatePicker bday;
    public static TextInputEditText name, phone, email, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        bday = findViewById(R.id.date);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        description = findViewById(R.id.description);

        name.addTextChangedListener(twManager);
        phone.addTextChangedListener(twManager);
        email.addTextChangedListener(twManager);

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarDatos();
            }
        });
    }

    TextWatcher twManager = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(name.hasFocus()){
                name.setError(null);
            }else if(phone.hasFocus()){
                phone.setError(null);
            }else if(email.hasFocus()){
                email.setError(null);
            }
        }
        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private boolean validarNombre(String nombre) {
        Pattern patron = Pattern.compile("^[a-zA-Z áéíóú ÁÉÍÓÚ ]+$");
        if(!patron.matcher(nombre).matches() || nombre.length() > 30){
            name.setError("Nombre Inválido");
            return false;
        }else{
            name.setError(null);
            return true;
        }
    }

    private boolean validarTelefono(String telefono) {
        if(!Patterns.PHONE.matcher(telefono).matches()){
            phone.setError("Número Inválido");
            return false;
        }else{
            phone.setError(null);
            return true;
        }
    }

    private boolean isEmailValido(String correo) {
        if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
            email.setError("Correo Inválido");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }

    private void validarDatos() {
        String nameTxt = name.getText().toString();
        String phoneTxt = phone.getText().toString();
        String emailTxt = email.getText().toString();

        boolean a = validarNombre(nameTxt);
        boolean b = validarTelefono(phoneTxt);
        boolean c = isEmailValido(emailTxt);
        if (a && b && c) {
            Intent datos = new Intent(this, DataActivity.class);
            startActivity(datos);
        }
    }
}

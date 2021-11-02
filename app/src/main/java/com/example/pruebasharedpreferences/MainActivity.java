package com.example.pruebasharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.pruebasharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Primero en el Gradle modules agregar el binding
    // Crear la variable del binding
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Esto engancha el java con el xml, con binding cambia
        // setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // Para enganchar el xml al java con Binding
        setContentView(binding.getRoot());

        binding.idBTBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Se hace con constantes no con literales de strings

                // Se crea la Preferencia
                SharedPreferences sharedPreferences = getSharedPreferences("misPreferencias", Context.MODE_PRIVATE);
                // Crear un editor
                SharedPreferences.Editor editor = sharedPreferences.edit();
                // Introducir los datos en el editor
                editor.putString("texto",binding.idETTexto.getText().toString());
                editor.putInt("numero",Integer.parseInt(binding.idETNumero.getText().toString()));
                // Hacer un commit para guardarlo
                editor.commit();

                // Hacer al salto al otro activity
                startActivity(new Intent(view.getContext(), SegundoActivity.class));
            }
        });
    }
}
package com.example.pruebasharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.pruebasharedpreferences.databinding.ActivityMainBinding;
import com.example.pruebasharedpreferences.databinding.ActivitySegundoBinding;

public class SegundoActivity extends AppCompatActivity {
    private ActivitySegundoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundoBinding.inflate(getLayoutInflater());
        // Para enganchar el xml al java con Binding
        setContentView(binding.getRoot());

        // Para recuperar los datos

        // Crear el sharedPreferences del mismo tipo del envio
        SharedPreferences sharedPreferences = getSharedPreferences("misPreferencias", Context.MODE_PRIVATE);
        // Asignar los valores del sharedPreferences a los elementos
        binding.idTVTexto.setText(sharedPreferences.getString("texto",""));
        binding.idTVNumero.setText(sharedPreferences.getInt("numero",0));
    }
}
package com.martin.rastrillamartinparcialexamen3.ui.cargar;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.martin.rastrillamartinparcialexamen3.MainActivity;
import com.martin.rastrillamartinparcialexamen3.model.Auto;

import java.util.List;

public class CargarViewModel extends AndroidViewModel {

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public void cargarAuto(String patente, String marca, String modelo, String precio) {
        // Verificar si algún campo está vacío
        if (patente.isEmpty() || marca.isEmpty() || modelo.isEmpty() || precio.isEmpty()) {
            Toast.makeText(getApplication(), "Faltaron campos por llenar", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar si la patente ya existe
        for (Auto auto : MainActivity.listaAutos) {
            if (auto.getPatente().equals(patente)) {
                Toast.makeText(getApplication(), "Esta patente ya pertenece a un auto cargado", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        // Verificar si el campo 'modelo' es un número entero
        int modeloInt;
        try {
            modeloInt = Integer.parseInt(modelo);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplication(), "Sólo se permiten números en Modelo", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar si el campo 'precio' es un número decimal
        double precioDouble;
        try {
            precioDouble = Double.parseDouble(precio);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplication(), "Sólo se permiten números en Precio", Toast.LENGTH_SHORT).show();
            return;
        }

        // Si todas las validaciones pasan, proceder a cargar el auto
        Auto auto = new Auto(patente, marca, modeloInt, precioDouble);
        MainActivity.listaAutos.add(auto);

        // Ordenar la lista de autos de mayor a menor según el precio (más simple usando lambda)
        MainActivity.listaAutos.sort((auto1, auto2) -> Double.compare(auto2.getPrecio(), auto1.getPrecio()));

        //Muestra msj de éxitos
        Toast.makeText(getApplication(), "¡Auto cargado con éxito!", Toast.LENGTH_SHORT).show();
    }


}
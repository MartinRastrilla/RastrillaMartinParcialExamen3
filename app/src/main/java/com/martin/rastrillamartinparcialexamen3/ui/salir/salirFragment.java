package com.martin.rastrillamartinparcialexamen3.ui.salir;

import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martin.rastrillamartinparcialexamen3.R;
import com.martin.rastrillamartinparcialexamen3.databinding.FragmentSalirBinding;

public class salirFragment extends Fragment {

    private FragmentSalirBinding binding;


    public static salirFragment newInstance() {
        return new salirFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mostrarMensaje();

        return root;
    }

    private void mostrarMensaje() {
        new AlertDialog.Builder(getContext())
                .setTitle("Está saliendo de la App")
                .setMessage("¿Desea irse de cargar autos? :c")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        getActivity().finishAffinity(); // Cierra la aplicación si elige "Sí"
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NavController navController = NavHostFragment.findNavController(salirFragment.this);
                        navController.navigate(R.id.action_nav_salir_to_nav_listar); // Redirige a Listar Autos en caso de seleccionar "No"
                    }
                })
                .show();
    }

}
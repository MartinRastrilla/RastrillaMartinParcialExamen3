package com.martin.rastrillamartinparcialexamen3.ui.cargar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martin.rastrillamartinparcialexamen3.R;
import com.martin.rastrillamartinparcialexamen3.databinding.FragmentCargarBinding;
import com.martin.rastrillamartinparcialexamen3.model.Auto;

public class CargarFragment extends Fragment {

    private CargarViewModel mViewModel;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String patente =binding.etPatente.getText().toString();
                String marca =binding.etMarca.getText().toString();
                String modelo = binding.etModelo.getText().toString();
                String precio = binding.etPrecio.getText().toString();
                mViewModel.cargarAuto(patente,marca,modelo,precio);
                binding.etPatente.setText("");
                binding.etMarca.setText("");
                binding.etModelo.setText("");
                binding.etPrecio.setText("");
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CargarViewModel.class);
        // TODO: Use the ViewModel
    }

}
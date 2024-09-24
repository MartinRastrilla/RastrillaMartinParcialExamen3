package com.martin.rastrillamartinparcialexamen3.ui.listar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martin.rastrillamartinparcialexamen3.MainActivity;
import com.martin.rastrillamartinparcialexamen3.R;
import com.martin.rastrillamartinparcialexamen3.databinding.FragmentAutosBinding;

public class AutosFragment extends Fragment {

    private AutosViewModel mViewModel;
    private FragmentAutosBinding binding;

    public static AutosFragment newInstance() {
        return new AutosFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        AutosViewModel autosViewModel = new ViewModelProvider(this).get(AutosViewModel.class);
        binding = FragmentAutosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        autosViewModel.getMListAutos().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                AutoAdapter adapter = new AutoAdapter(MainActivity.listaAutos, inflater);
                GridLayoutManager glm = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.listaAutos.setAdapter(adapter);
                binding.listaAutos.setLayoutManager(glm);
            }
        });
        autosViewModel.obtenerListaAutos();
        return root;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AutosViewModel.class);
        // TODO: Use the ViewModel
    }

}
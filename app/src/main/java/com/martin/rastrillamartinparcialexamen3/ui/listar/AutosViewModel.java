package com.martin.rastrillamartinparcialexamen3.ui.listar;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.martin.rastrillamartinparcialexamen3.MainActivity;
import com.martin.rastrillamartinparcialexamen3.model.Auto;

import java.util.List;

public class AutosViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> mListaAutos;

    public AutosViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getMListAutos(){
        if (mListaAutos==null){
            mListaAutos=new MutableLiveData<>();
        }
        return mListaAutos;
    }

    public void obtenerListaAutos() {
        if (MainActivity.listaAutos.size()>0){
            mListaAutos.setValue(true);
        }else{
            Toast.makeText(getApplication(), "Aún no hay autos cargados", Toast.LENGTH_LONG).show();
        }
    }
}
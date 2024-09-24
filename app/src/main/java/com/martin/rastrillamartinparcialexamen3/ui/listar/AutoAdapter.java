package com.martin.rastrillamartinparcialexamen3.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.martin.rastrillamartinparcialexamen3.R;
import com.martin.rastrillamartinparcialexamen3.model.Auto;

import java.util.List;

public class AutoAdapter extends RecyclerView.Adapter<AutoAdapter.ViewHolderAuto>{

    private List<Auto> listaAutos;
    private LayoutInflater li;

    public AutoAdapter(List<Auto> autos, LayoutInflater li){
        this.listaAutos=autos;
        this.li=li;
    }

    @NonNull
    @Override
    public ViewHolderAuto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.tarjeta, parent, false);
        return new ViewHolderAuto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAuto holder, int position) {
        Auto auto = listaAutos.get(position);
        holder.tvPatente.setText(auto.getPatente());
        holder.tvMarca.setText(auto.getMarca());
        holder.tvModelo.setText(auto.getModelo()+"");
        holder.tvPrecio.setText("$"+auto.getPrecio()+"");
    }

    @Override
    public int getItemCount() {
        return listaAutos.size();
    }

    public class ViewHolderAuto extends RecyclerView.ViewHolder {
        TextView tvPatente;
        TextView tvMarca;
        TextView tvModelo;
        TextView tvPrecio;

        public ViewHolderAuto(@NonNull View itemView) {
            super(itemView);

            tvPatente=itemView.findViewById(R.id.tvPatente);
            tvMarca=itemView.findViewById(R.id.tvMarca);
            tvModelo=itemView.findViewById(R.id.tvModelo);
            tvPrecio=itemView.findViewById(R.id.textView9);
        }
    }
}

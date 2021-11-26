package com.example.appg9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterEvents extends RecyclerView.Adapter<AdapterEvents.ViewHolderEvents> {
    ArrayList<String> datos;

    public AdapterEvents(ArrayList<String> datos) {
        this.datos = datos;
    }

    /**
     * Enlaza este adaptador con el archivo item_list
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolderEvents onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null, false);
        return new ViewHolderEvents(view);
    }

    /**
     * Establece comunicacion entre Adaptador y la clase ViewHolderEvents
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolderEvents holder, int position) {
        holder.asignarDatos(datos.get(position));
    }

    /**
     *
     * @return size list
     */
    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ViewHolderEvents extends RecyclerView.ViewHolder {

        TextView dato;

        public ViewHolderEvents(@NonNull View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
}

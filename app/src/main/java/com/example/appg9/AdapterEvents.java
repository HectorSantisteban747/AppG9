package com.example.appg9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class AdapterEvents extends RecyclerView.Adapter<AdapterEvents.ViewHolderEvents> {
    ArrayList<Event> eventList;

    public AdapterEvents(ArrayList<Event> eventList) {
        this.eventList = eventList;
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
        holder.img.setImageResource(eventList.get(position).getImg());
        holder.event.setText(eventList.get(position).getEvent());
        holder.type.setText(eventList.get(position).getType());
        holder.date.setText(eventList.get(position).getDate().toString());
        holder.time.setText(eventList.get(position).getTime().toString());
        holder.contact.setText(eventList.get(position).getContact());
        holder.value.setText(String.valueOf( eventList.get(position).getValue()));
    }

    /**
     *
     * @return size list
     */
    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class ViewHolderEvents extends RecyclerView.ViewHolder {

        ImageView img;
        TextView event, type, date, time, contact, value;


        public ViewHolderEvents(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_id);
            event = (TextView) itemView.findViewById(R.id.event_info_id);
            type = (TextView) itemView.findViewById(R.id.type_info_id);
            date = (TextView) itemView.findViewById(R.id.date_info_id);
            time = (TextView) itemView.findViewById(R.id.time_info_id);
            contact = (TextView) itemView.findViewById(R.id.contac_info_id);
            value = (TextView) itemView.findViewById(R.id.value_info_id);

        }

        public void asignarDatos(int img, String event, String type, Date date, Date time, String contact, double value) {
            this.img.setImageResource(img);
        }
    }
}

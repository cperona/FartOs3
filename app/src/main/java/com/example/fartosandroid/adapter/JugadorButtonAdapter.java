package com.example.fartosandroid.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fartosandroid.R;
import com.example.fartosandroid.listener.SelectListenerJugador;
import com.example.fartosandroid.objects.Jugador;

import java.util.List;

public class JugadorButtonAdapter extends RecyclerView.Adapter<JugadorButtonAdapter.MyViewHolder> {
    private List<Jugador> playerList;
    SelectListenerJugador listenerJugador;

    public JugadorButtonAdapter(List<Jugador> playerList, SelectListenerJugador listenerJugador) {
        this.playerList = playerList;
        this.listenerJugador = listenerJugador;
    }

    @NonNull
    @Override
    public JugadorButtonAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JugadorButtonAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.buton_cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorButtonAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindData(playerList.get(position),position);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerJugador.onItemClicked(playerList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView btn;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            btn = itemView.findViewById(R.id.jugadorButton);
            cardView = itemView.findViewById(R.id.cardViewBtn);
        }

        void bindData(final Jugador jugador, int position){
            btn.setImageResource(jugador.getIconResource());
        }
    }
}

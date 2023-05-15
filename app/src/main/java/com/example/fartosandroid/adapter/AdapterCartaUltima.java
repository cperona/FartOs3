package com.example.fartosandroid.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fartosandroid.R;
import com.example.fartosandroid.listener.SelectListenerCarta;
import com.example.fartosandroid.objects.CartaUltima;

import java.util.List;

public class AdapterCartaUltima extends RecyclerView.Adapter<AdapterCartaUltima.MyViewHolder> {

    private List<CartaUltima> cartaUltimaList;
    private SelectListenerCarta listenerCarta;

    public AdapterCartaUltima(List<CartaUltima> cartaUltimaList, SelectListenerCarta listenerCarta){
        this.cartaUltimaList = cartaUltimaList;
        this.listenerCarta = listenerCarta;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindData(cartaUltimaList.get(position));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerCarta.onItemClicked(cartaUltimaList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartaUltimaList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView cartaImg;
        TextView nomCarta;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            cartaImg = itemView.findViewById(R.id.carta);
            cardView = itemView.findViewById(R.id.cv_card);

        }

        void bindData(final CartaUltima cartaUltima){
            cartaImg.setImageResource(cartaUltima.getSkinResource());
            //nomCarta.setText(cartaV.getNom());
        }
    }
}

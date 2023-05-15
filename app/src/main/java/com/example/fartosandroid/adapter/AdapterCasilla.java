package com.example.fartosandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fartosandroid.R;
import com.example.fartosandroid.objects.Casella;

import java.util.List;

public class AdapterCasilla extends RecyclerView.Adapter<AdapterCasilla.MyViewHolder> {
    private List<Casella> casellaList;

    public AdapterCasilla(List<Casella> casellaList) {
        this.casellaList = casellaList;
    }

    @NonNull
    @Override
    public AdapterCasilla.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterCasilla.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_casillas, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCasilla.MyViewHolder holder, int position) {
        holder.bindData(casellaList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return casellaList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView spriteP1ImageView;
        ImageView spriteP2ImageView;
        TextView casellaTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spriteP1ImageView = itemView.findViewById(R.id.p1);
            spriteP2ImageView = itemView.findViewById(R.id.p2);
            casellaTextView = itemView.findViewById(R.id.casillaN);

        }

        void bindData(final Casella casella, int position) {
            position = position+1;
            casellaTextView.setText("Casella "+ casella.getNom());
                spriteP1ImageView.setImageResource(casella.getP1());
                spriteP2ImageView.setImageResource(casella.getP2());

        }
    }
}

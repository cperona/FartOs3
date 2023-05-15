package com.example.fartosandroid;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fartosandroid.LayoutManager.ScaleCenterItemLayoutManager;
import com.example.fartosandroid.adapter.JugadorButtonAdapter;
import com.example.fartosandroid.listener.SelectListenerJugador;
import com.example.fartosandroid.objects.CartaUltima;
import com.example.fartosandroid.objects.Casella;
import com.example.fartosandroid.objects.Jugador;

import java.util.ArrayList;
import java.util.List;

public class CartaDialogFragment extends DialogFragment implements SelectListenerJugador {
    Jugador selectedJugador;
    CartaUltima cartaUltima;
    RecyclerView buttonRecyclerView;
    JugadorButtonAdapter jugadorButtonAdapter;
    List<Jugador> jugadors = new ArrayList<>();
    List<Casella> casellas = new ArrayList<>();
    Jugador user;
    Casella lastCasella;
    boolean isJugador = false;
    boolean first8 = true;
    boolean broma = false;

    @SuppressLint("MissingInflatedId")
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Inflem el layout
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_fragment, null);

        //Recuperem les dades del MainActivity
        Bundle bundle = getArguments();
        cartaUltima = (CartaUltima) bundle.getSerializable("carta");
        jugadors = (List<Jugador>) bundle.getSerializable("jugadors");
        casellas = (List<Casella>) bundle.getSerializable("caselles");
        user = (Jugador) bundle.getSerializable("jugador");

        ImageView imageView = view.findViewById(R.id.cartaInFragment);
        buttonRecyclerView = view.findViewById(R.id.buttonsRecyclerView);
        imageView.setImageResource(cartaUltima.getSkinResource());

        init();
        builder.setView(view);
        return builder.create();
    }

    public void init(){
        jugadorButtonAdapter = new JugadorButtonAdapter(jugadors,this);
        buttonRecyclerView.setHasFixedSize(true);
        buttonRecyclerView.setLayoutManager(new ScaleCenterItemLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        buttonRecyclerView.setAdapter(jugadorButtonAdapter);
    }

    @Override
    public void onItemClicked(Jugador jugador) {
        selectedJugador = jugador;
        isJugador = false;
        int mou = 0;
        if (selectedJugador.equals(user)){
            isJugador = true;
        }
        if (selectedJugador.isPatada() && isJugador){
            mou = mou -1;
            selectedJugador.setPatada(false);
        }

        if (cartaUltima.getTipus() == 1){
            if (isJugador){
                ((MainActivity) getActivity()).move(selectedJugador,mou + 1);
            } else {
                ((MainActivity) getActivity()).move(selectedJugador,mou - 1);
            }
        }
        if (cartaUltima.getTipus() == 2){
            if (isJugador){
                ((MainActivity) getActivity()).move(selectedJugador,mou + 2);
            } else {
                ((MainActivity) getActivity()).move(selectedJugador,mou - 2);
            }
        }
        if (cartaUltima.getTipus() == 3){
            if (isJugador){
                ((MainActivity) getActivity()).move(selectedJugador,mou + 3);
            } else {
                ((MainActivity) getActivity()).move(selectedJugador,mou - 3);
            }
        }
        if (cartaUltima.getTipus()==4){
            ((MainActivity) getActivity()).teleport(user,selectedJugador);
        }
        if (cartaUltima.getTipus()==5){
            ((MainActivity) getActivity()).zancadilla(selectedJugador);
        }
        if (cartaUltima.getTipus()==6){
            ((MainActivity) getActivity()).patada(selectedJugador);
        }
        if (cartaUltima.getTipus()==7){
            ((MainActivity) getActivity()).hundimiento(selectedJugador);

        }
        if (cartaUltima.getTipus()==8){
            broma = true;
            ((MainActivity) getActivity()).broma(user,selectedJugador);
        }
        if (selectedJugador.getNumCasella() == 7 && first8){
            first8 = false;
            ((MainActivity) getActivity()).casilla8(user);
        }

        boolean trobada = false;
        int posTrob = -1;
        int pos = 0;

        for (CartaUltima c: user.ma) {
            if (c.getTipus()== cartaUltima.getTipus() && !trobada){
                posTrob = pos;
                trobada = true;
                //user.ma.remove(pos);
            }
            pos = pos +1;
        }

        lastCasella = casellas.get(casellas.size()-1);
        if (!(user.ma.size() <= 0) && !broma) {
            user.ma.remove(posTrob);
            broma = false;
        }
        if (lastCasella.getRonda() >= 3){
            lastCasella.setRonda(lastCasella.getRonda()+1);
            ((MainActivity) getActivity()).deleteCasilla();
            init();
        }
        ((MainActivity) getActivity()).haGuanyat(selectedJugador);
        ((MainActivity) getActivity()).recyclerMa();

        dismiss();
    }

}

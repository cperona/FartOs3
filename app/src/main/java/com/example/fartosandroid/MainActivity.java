package com.example.fartosandroid;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fartosandroid.LayoutManager.ScaleCenterItemLayoutManager;
import com.example.fartosandroid.adapter.AdapterCartaUltima;
import com.example.fartosandroid.adapter.AdapterCasilla;
import com.example.fartosandroid.listener.SelectListenerCarta;
import com.example.fartosandroid.objects.CartaUltima;
import com.example.fartosandroid.objects.Casella;
import com.example.fartosandroid.objects.Jugador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListenerCarta {
    Jugador jugador;
    Casella lastCasella;
    AdapterCasilla adapterCasilla;
    CartaUltima selectedCarta;
    AdapterCartaUltima adapterCartaUltima;
    List<CartaUltima> baralla = new ArrayList<>();
    List<CartaUltima> ma = new ArrayList<>();
    List<Casella> caselles = new ArrayList<>();
    List<Jugador> jugadors = new ArrayList<>();
    RecyclerView cartaRecyclerView;
    RecyclerView casellaRecyclerView;
    ScaleCenterItemLayoutManager linearLayoutManager;
    Drawable trans;
    int tranInt;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cartaRecyclerView = findViewById(R.id.cartesRecyclerView);
        trans = ContextCompat.getDrawable(this,R.drawable.trans);
        tranInt =R.drawable.trans;
        initJugadors();
        jugador = jugadors.get(0);
        initMap();
        initBaralla();
        actualitzaMa();

    }

    public void initJugadors(){
        jugadors.add(new Jugador("Goku",R.drawable.sprite_robot,R.drawable.icon_robot));
        jugadors.add(new Jugador("Lucario",R.drawable.sprite_skeleton,R.drawable.icon_skeleton));
        jugadors.add(new Jugador("Luffy",R.drawable.sprite_wiz,R.drawable.icon_wiz));
    }

    public void actualitzaMa(){
        for (Jugador j: jugadors) {
            if (jugadors.size() >= 5){
                for (int i = 0; i < 5; i++) {
                    j.ma.add(baralla.get(0));
                    baralla.remove(0);
                }
            } else {
                for (int i = 0; i < 6; i++) {
                    j.ma.add(baralla.get(0));
                    baralla.remove(0);
                }
            }
        }
        recyclerMa();
    }

    public void recyclerMa(){
        ma = jugador.ma;
        if (ma.isEmpty()){
            cartaRecyclerView.setVisibility(View.GONE);
            Toast.makeText(this, "T'has quedat sense cartes", Toast.LENGTH_SHORT).show();
            initBaralla();
            actualitzaMa();
            Toast.makeText(this, "Ronda finalitzada "+ lastCasella.getRonda(), Toast.LENGTH_SHORT).show();
            if (lastCasella.getRonda() < 3) {
                lastCasella.setRonda(lastCasella.getRonda() + 1);
            }

        } else {
            cartaRecyclerView.setVisibility(View.VISIBLE);
            adapterCartaUltima = new AdapterCartaUltima(ma, this);
            linearLayoutManager = new ScaleCenterItemLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            cartaRecyclerView.setHasFixedSize(true);
            cartaRecyclerView.setLayoutManager(linearLayoutManager);
            cartaRecyclerView.setAdapter(adapterCartaUltima);
        }
    }

    public void recyclerCaselles(){
        adapterCasilla = new AdapterCasilla(caselles);
        casellaRecyclerView.setHasFixedSize(true);
        casellaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        casellaRecyclerView.setAdapter(adapterCasilla);
    }

    public void initBaralla(){
        baralla = new ArrayList<>();
        for (int i = 0; i < 28; i++) {
            baralla.add(new CartaUltima("Moure 1",R.drawable.moure_1,1));
        }
        for (int i = 0; i < 18; i++) {
            baralla.add(new CartaUltima("Moure2",R.drawable.moure_2,2));
        }
        for (int i = 0; i < 10; i++) {
            baralla.add(new CartaUltima("Moure3",R.drawable.moure_3,3));
        }
        for (int i = 0; i < 3; i++) {
            baralla.add(new CartaUltima("Teleport",R.drawable.teleport,4));
        }
        for (int i = 0; i < 4; i++) {
            baralla.add(new CartaUltima("Zancadilla",R.drawable.zancadilla,5));
        }
        for (int i = 0; i < 3; i++) {
            baralla.add(new CartaUltima("Patada",R.drawable.patada,6));
        }
        for (int i = 0; i < 2; i++) {
            baralla.add(new CartaUltima("Hundimiento",R.drawable.hundimiento,7));
        }
        for (int i = 0; i < 2; i++) {
            baralla.add(new CartaUltima("Broma",R.drawable.trollface,8));
        }
        Collections.shuffle(baralla);
    }


    public void initMap(){
        casellaRecyclerView = findViewById(R.id.casellesRecyclerView);
        caselles.add(new Casella("1",1,tranInt,tranInt));
        caselles.add(new Casella("2",2,tranInt,tranInt));
        caselles.add(new Casella("3",3,tranInt,tranInt));
        caselles.add(new Casella("4",4,tranInt,tranInt));
        caselles.add(new Casella("5",5,tranInt,tranInt));
        caselles.add(new Casella("6",6,tranInt,tranInt));
        caselles.add(new Casella("7",7,tranInt,tranInt));
        caselles.add(new Casella("8",8,tranInt,tranInt));
        caselles.add(new Casella("9",9,tranInt,tranInt));
        caselles.add(new Casella("10",10,tranInt,tranInt));
        caselles.add(new Casella("11",11,tranInt,tranInt));
        caselles.add(new Casella("12",12,tranInt,tranInt));
        caselles.add(new Casella("13",13,tranInt,tranInt));
        caselles.add(new Casella("14",14,tranInt,tranInt));
        caselles.add(new Casella("15",15,tranInt,tranInt));
        lastCasella = caselles.get(caselles.size()-1);
        recyclerCaselles();

        move(jugadors.get(0),0);
        move(jugadors.get(1),1);
        move(jugadors.get(2),4);

    }
    public void move(Jugador jugador,int move){

        int nCasilla1 = Math.max(jugador.getNumCasella(), 0);
        int nCasilla2 = nCasilla1+move;
        if (nCasilla2 <= 0){
            nCasilla2 = 0;
        }
        if (nCasilla2 >= caselles.size()-1){
            nCasilla2 = caselles.size()-1;
        }
        jugador.setNumCasella(nCasilla2);

        if (caselles.get(nCasilla2).getP1() == tranInt){
            if (jugador.isP()){
                Log.d("trans","P1,P1 "+ nCasilla1 + jugador.getNom());
                caselles.get(nCasilla1).setP1(tranInt);
            } else {
                Log.d("trans","P1,P2 "+nCasilla1 + jugador.getNom());
                caselles.get(nCasilla1).setP2(tranInt);
            }
            Log.d("trans","set P1 sprite");
            caselles.get(nCasilla2).setP1(jugador.getSprite());
            Log.d("trans","set P1 sprite " + nCasilla2 + jugador.getNom());
            jugador.setP(true);
        } else if (caselles.get(nCasilla2).getP2() == tranInt){
            if (jugador.isP()){
                Log.d("trans","P2,P1");
                caselles.get(nCasilla1).setP1(tranInt);
            } else {
                Log.d("trans","P2,P2");
                caselles.get(nCasilla1).setP2(tranInt);
            }
            Log.d("trans","set P2 sprite");
            caselles.get(nCasilla2).setP2(jugador.getSprite());
            jugador.setP(false);
        } else {
            //Toast.makeText(this, "Ya hay 2 jugadores en esa casilla!", Toast.LENGTH_LONG).show();
        }
        casellaRecyclerView.setAdapter(adapterCasilla);
    }

    public void teleport(Jugador user, Jugador selectedJugador){
        int casillaUser = user.getNumCasella();
        boolean pUser = user.isP();
        int casillaSelectedJugador = selectedJugador.getNumCasella();
        boolean pSelectedJugador = selectedJugador.isP();
        user.setNumCasella(casillaSelectedJugador);
        user.setP(pSelectedJugador);
        selectedJugador.setNumCasella(casillaUser);
        selectedJugador.setP(pUser);

        if (user.isP()){
            caselles.get(user.getNumCasella()).setP1(user.getSprite());
        } else {
            caselles.get(user.getNumCasella()).setP2(user.getSprite());
        }
        if (selectedJugador.isP()){
            caselles.get(selectedJugador.getNumCasella()).setP1(tranInt);
            caselles.get(selectedJugador.getNumCasella()).setP1(selectedJugador.getSprite());
        } else {
            caselles.get(selectedJugador.getNumCasella()).setP2(selectedJugador.getSprite());
        }
        recyclerCaselles();
    }

    public void zancadilla(Jugador jugador){
        jugador.ma.remove((int)(Math.random() * jugador.ma.size()));
    }
    public void patada(Jugador jugador){
        jugador.setPatada(true);
    }
    public void hundimiento(Jugador jugador){
        int move = jugador.getNumCasella();
        move(jugador,-move);
    }

    public void broma(Jugador user, Jugador selectedJugador){
        int posTrob = -1;
        boolean trobada = false;
        int pos = 0;
        for (CartaUltima c: user.ma) {
            if (c.getTipus()== 8 && !trobada){
                posTrob = pos;
                trobada = true;
                //user.ma.remove(pos);
            }
            pos = pos +1;
        }
        if (!(user.ma.size() <= 0)) {
            user.ma.remove(posTrob);
        }
        List<CartaUltima> handUser = user.ma;
        List<CartaUltima> handSelectedJugador = selectedJugador.ma;
        user.setMa(handSelectedJugador);
        selectedJugador.setMa(handUser);

        recyclerMa();
    }

    public void casilla8(Jugador user){
        C8DialogFragment c8DialogFragment = new C8DialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("user",user);
        bundle.putSerializable("jugadors", (Serializable) jugadors);
        c8DialogFragment.setArguments(bundle);
        c8DialogFragment.show(getSupportFragmentManager(),"Casilla 8 Fragment");
    }

    public void deleteCasilla(){
        jugadors.removeIf(jugador -> jugador.getNumCasella() == 0);
        for (Jugador j: jugadors) {
            j.setNumCasella(j.getNumCasella()-1);
        }
        caselles.remove(0);

    }
    public void haGuanyat(Jugador jugador){
        if (jugador.getNumCasella() == caselles.size()-1){
            Toast.makeText(this, "Ganador " + jugador.getNom() + "!", Toast.LENGTH_SHORT).show();
        }
        if (jugadors.size()==1){
            Toast.makeText(this, "Ganador " + jugadors.get(0).getNom() + "!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClicked(CartaUltima cartaUltima) {
        selectedCarta = cartaUltima;
        Jugador jugador = jugadors.get(0);
        CartaDialogFragment cartaDialogFragment = new CartaDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("carta",selectedCarta);
        bundle.putSerializable("jugadors", (Serializable) jugadors);
        bundle.putSerializable("jugador",jugador);
        bundle.putSerializable("caselles", (Serializable) caselles);
        cartaDialogFragment.setArguments(bundle);
        cartaDialogFragment.show(getSupportFragmentManager(),"Carta Fragment");
    }
}
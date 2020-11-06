package com.cursodeandroid.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cursodeandroid.recyclerview.RecyclerItemClickListener;
import com.cursodeandroid.recyclerview.adapter.Adapter;
import com.cursodeandroid.recyclerview.model.Filme;
import com.cursodeandroid.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); sem viewBinding

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Chamar lista de filmes p/ onCreate
        this.criarFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter( listaFilmes );

        //configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        binding.recyclerView.setAdapter(adapter);

        //Evento de click
        binding.recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener( getApplicationContext(), binding.recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filmeClicado = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(),
                                filmeClicado.getTituloFilme() + " selecionado!",
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filmeClicado = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(),
                                "Ano: " + filmeClicado.getAno(),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                })
        );
    }

    public void criarFilmes(){

        Filme filme = new Filme("48 Hrs", "1982", "Comédia de Ação");
        listaFilmes.add(filme);

        filme = new Filme("Beverly Hills Cop", "1984", "Comédia de Ação");
        listaFilmes.add(filme);

        filme = new Filme("Lethal Weapon", "1987", "Comédia de Ação");
        listaFilmes.add(filme);

        filme = new Filme("Midnight Run", "1988", "Comédia de Ação");
        listaFilmes.add(filme);

        filme = new Filme("Bad Boys", "1995", "Comédia de Ação");
        listaFilmes.add(filme);

        filme = new Filme("Rush Hour", "1998", "Comédia de Ação");
        listaFilmes.add(filme);

        filme = new Filme("The Rundown", "2003", "Comédia de Ação");
        listaFilmes.add(filme);

        filme = new Filme("Hot Fuzzy", "2007", "Comédia de Ação");
        listaFilmes.add(filme);

        filme = new Filme("The Nice Guys", "2016", "Comédia de Ação");
        listaFilmes.add(filme);

        filme = new Filme("Mata Hari", "1932", "Espionagem");
        listaFilmes.add(filme);

        filme = new Filme("Funeral em Berlim", "1966", "Espionagem");
        listaFilmes.add(filme);

        filme = new Filme("O espião que veio do frio", "1965", "Espionagem");
        listaFilmes.add(filme);

    }

}
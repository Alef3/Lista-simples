package com.cursodeandroid.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cursodeandroid.recyclerview.model.Filme;
import com.cursodeandroid.recyclerview.databinding.AdapterListaBinding;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private AdapterListaBinding itemBinding;

    private final List<Filme> listaFilmes;
    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }


    @NonNull
    @Override //INICIO - Implementando métodos da classe Adapter (omCreateViewHolder, onBindViewHolder, getItemCount)
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //sem viewBinding
        //View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista, parent, false);

        itemBinding = AdapterListaBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        View itemLista = itemBinding.getRoot();

        return new MyViewHolder(itemLista);
    }

    //OnBindViewHolder é chamado n vezes: de acordo com o tamanho n do getItemCount()
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme = listaFilmes.get(position);
        holder.getBindingHolder().textTitulo.setText(filme.getTituloFilme());
        holder.getBindingHolder().textGenero.setText(filme.getGenero());
        holder.getBindingHolder().textAno.setText(filme.getAno());
    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }//Fim da Implementacao de métodos

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public AdapterListaBinding getBindingHolder(){
            return itemBinding;
        }

    }

}

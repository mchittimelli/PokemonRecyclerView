package com.test.myfirst.pokemonrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PokemonRecycleAdapter extends RecyclerView.Adapter<PokemonRecycleAdapter.Viewholder> {
    private ArrayList<Pokemon> pokemonArrayList;
    private Context c;
    private View.OnClickListener pokemonClickListener;

    public PokemonRecycleAdapter(ArrayList<Pokemon> pokemonArrayList, Context c) {
        this.pokemonArrayList = pokemonArrayList;
        this.c = c;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Glide.with(c).asBitmap().load(pokemonArrayList.get(position).getImage()).into(holder.pokemonImage);
        holder.pokemonName.setText(pokemonArrayList.get(position).getName());
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener){
        pokemonClickListener=itemClickListener;
    }

    @Override
    public int getItemCount() {
        return pokemonArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{


        ImageView pokemonImage;
        TextView pokemonName;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            pokemonImage=itemView.findViewById(R.id.poke_image);
            pokemonName=itemView.findViewById(R.id.poke_name);

            itemView.setTag(this);
            itemView.setOnClickListener(pokemonClickListener);


        }
    }
}

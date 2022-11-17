package com.gasca1234.solocomsupodelaapiexamen.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gasca1234.solocomsupodelaapiexamen.R;
import com.gasca1234.solocomsupodelaapiexamen.ganadores;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adaptador  extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private List<ganadores> ganadoresList;



    private Context context;
    public Adaptador(Context context) {
        this.context = context;
        ganadoresList = new ArrayList<>();
    }
    public Adaptador(List<ganadores>ganadoresList){this.ganadoresList = ganadoresList;}
    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        holder.setData(ganadoresList.get(position));
        ganadores g=ganadoresList.get(position);
        Picasso.get().load("https://fer-uig.glitch.me/"+position).into(holder.Imagen);
    }

    @Override
    public int getItemCount() {
        return ganadoresList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView Imagen;
        public TextView elnombre;
        public TextView cantidad;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            elnombre=(TextView) itemView.findViewById(R.id.nombre);
            cantidad=(TextView) itemView.findViewById(R.id.cantidad);
            Imagen=(ImageView) itemView.findViewById(R.id.imageView);
        }

        public void setData(ganadores ganadores) {
            elnombre.setText(ganadores.getNombre());
            cantidad.setText(ganadores.getNumero());
           // Imagen.setImageAlpha(ganadores.getUrlImg());
        }
    }
}

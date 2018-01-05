package com.oliver.vezbarestorani.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.oliver.vezbarestorani.Modeli.Restorani;
import com.oliver.vezbarestorani.Modeli.RestoraniModel;
import com.oliver.vezbarestorani.R;
import com.oliver.vezbarestorani.RestoraniOnClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Oliver on 1/5/2018.
 */

public class RV_RestoraniAdapter extends RecyclerView.Adapter<RV_RestoraniAdapter.ViewHolder> {

    RestoraniModel model = new RestoraniModel();
    Context context;
    RestoraniOnClickListener restoraniOnClickListener;

    public void setItems(ArrayList<Restorani> restaurants) {
        model.restaurants = restaurants;
    }

    public RV_RestoraniAdapter(Context context,RestoraniOnClickListener onClickListener) {
        this.context = context;
        this.restoraniOnClickListener = onClickListener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       Context context = parent.getContext();
       LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Restorani restorani = model.restaurants.get(position);
        holder.textView.setText("Name :" + restorani.getName());
        holder.textView2.setText("City :" + restorani.getCity());
        holder.textView3.setText("Rating :" + restorani.getRating());

        Picasso.with(context).load(restorani.getLogo()).fit().centerInside().into(holder.slika);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restoraniOnClickListener.onRowClick(restorani,position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return model.restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.slika)
        ImageView slika;
        @BindView(R.id.text)
        TextView textView;
        @BindView(R.id.text2)
        TextView textView2;
        @BindView(R.id.text3)
        TextView textView3;
        @BindView(R.id.linear)
        LinearLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

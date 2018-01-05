package com.oliver.vezbarestorani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.oliver.vezbarestorani.Adapters.RV_RestoraniAdapter;
import com.oliver.vezbarestorani.Modeli.Restorani;
import com.oliver.vezbarestorani.Modeli.RestoraniModel;
import com.oliver.vezbarestorani.SharedPreferences.RestoraniPreferences;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.kopce)
    Button kopceAdd;
    RV_RestoraniAdapter adapter;
    RestoraniModel model = new RestoraniModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter=new RV_RestoraniAdapter(this, new RestoraniOnClickListener() {
            @Override
            public void onRowClick(Restorani restaurants, int position) {
                Intent intent;
                intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("extra",restaurants);
                intent.putExtra("pozicija",position);
                startActivity(intent);

            }
        });
        adapter.setItems(getList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(adapter);
    }

    ArrayList<Restorani> getList() {
         model = RestoraniPreferences.getRestaurants(this);
        return model.restaurants;
    }
}

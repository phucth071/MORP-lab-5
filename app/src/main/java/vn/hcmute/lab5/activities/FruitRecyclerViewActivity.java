package vn.hcmute.lab5.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import vn.hcmute.lab5.R;
import vn.hcmute.lab5.adapters.FruitRVAdapter;
import vn.hcmute.lab5.models.Fruit;

public class FruitRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvFruit;
    private List<Fruit> fruitList;
    private FruitRVAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_recycler_view);

        viewMapping();
        fruitAdapter = new FruitRVAdapter(fruitList, this, getLayoutInflater());
        rvFruit.setAdapter(fruitAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvFruit.setLayoutManager(linearLayoutManager);
    }

    public void viewMapping() {
        rvFruit = findViewById(R.id.recyclerview_fruit);
        fruitList = new ArrayList<>();
        fruitList.add(new Fruit("Apple", "An apple a day keeps the doctor away", R.drawable.apple));
        fruitList.add(new Fruit("Banana", "Eat banana to keep your energy up", R.drawable.banana));
        fruitList.add(new Fruit("Orange", "Orange is good for your skin", R.drawable.orange));
        fruitList.add(new Fruit("Cherry", "Cherry is good for your heart", R.drawable.cherry));
        fruitList.add(new Fruit("Grape", "Grape is good for your brain", R.drawable.grape));
        fruitList.add(new Fruit("Avocado", "Avocado is good for your eyes", R.drawable.avocado));
        fruitList.add(new Fruit("Papaya", "Papaya is good for your digestion", R.drawable.papaya));
    }
}
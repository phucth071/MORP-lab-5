package vn.hcmute.lab5.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import vn.hcmute.lab5.R;
import vn.hcmute.lab5.adapters.FruitAdapter;
import vn.hcmute.lab5.models.Fruit;

public class FruitListViewActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Fruit> fruitList = new ArrayList<>();
    FruitAdapter fruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list_view);

        anhXa();
        fruitAdapter = new FruitAdapter(this, R.layout.fruit_item, fruitList);
        Log.d("FruitListViewActivity", "onCreate: " + fruitList.size());
        listView.setAdapter(fruitAdapter);
    }

    private void anhXa() {
        listView = findViewById(R.id.listview_fruit);
        fruitList = new ArrayList<>();
        fruitList.add(new Fruit("Apple", "apple apple apple", R.drawable.apple));
        fruitList.add(new Fruit("Banana", "banana banana", R.drawable.banana));
        fruitList.add(new Fruit("Cherry", "cherry cherry cheery", R.drawable.cherry));
        fruitList.add(new Fruit("Grape", "grape grape grape", R.drawable.grape));
        fruitList.add(new Fruit("Papaya", "papaya papaya papaya", R.drawable.papaya));
        fruitList.add(new Fruit("Orange", "orange orange orange", R.drawable.orange));
        fruitList.add(new Fruit("Avocado", "avocado avocado avocado", R.drawable.avocado));
    }
}
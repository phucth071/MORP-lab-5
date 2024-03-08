package vn.hcmute.lab5.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.hcmute.lab5.R;
import vn.hcmute.lab5.models.Fruit;

public class FruitRVAdapter extends RecyclerView.Adapter<FruitRVAdapter.FruitViewHolder>{

    private static final String TAG = "FruitRVAdapter";
    private List<Fruit> fruitList;
    private Context context;
    private LayoutInflater inflater;

    public FruitRVAdapter(List<Fruit> fruitList, Context context, LayoutInflater inflater) {
        this.fruitList = fruitList;
        this.context = context;
        this.inflater = inflater;
    }

    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.fruit_item, parent, false);
        return new FruitViewHolder(itemView);
    };

    @Override
    public void onBindViewHolder(FruitRVAdapter.FruitViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Fruit fruit = fruitList.get(position);

        holder.fruitname.setText(fruit.getName());
        holder.fruitdesc.setText(fruit.getDesc());
        holder.fruitimage.setImageResource(fruit.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fruit selectedFruit = fruitList.get(position);
                Toast.makeText(context, "Your select: " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    };

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {
        TextView fruitname, fruitdesc;
        ImageView fruitimage;
        public FruitViewHolder(View itemView) {
            super(itemView);

            fruitname = itemView.findViewById(R.id.textview_fruit_name);
            fruitdesc = itemView.findViewById(R.id.textview_fruit_desc);
            fruitimage = itemView.findViewById(R.id.imageview_fruit);

        }
    }
}

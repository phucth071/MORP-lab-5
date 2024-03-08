package vn.hcmute.lab5.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.hcmute.lab5.models.Fruit;

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Fruit> fruitList;

    public FruitAdapter(Context context, int layout, List<Fruit> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return fruitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView == null) {
            holder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtName = convertView.findViewById(vn.hcmute.lab5.R.id.textview_fruit_name);
            holder.txtDesc = convertView.findViewById(vn.hcmute.lab5.R.id.textview_fruit_desc);
            holder.img = convertView.findViewById(vn.hcmute.lab5.R.id.imageview_fruit);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }

        // Gán giá trị
        Fruit fruit = fruitList.get(position);
        holder.txtName.setText(fruit.getName());
        holder.txtDesc.setText(fruit.getDesc());
        holder.img.setImageResource(fruit.getImage());

        return convertView;
    }

    private class viewHolder {
        TextView txtName;
        TextView txtDesc;
        ImageView img;
    }
}

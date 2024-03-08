package vn.hcmute.lab5.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import vn.hcmute.lab5.R;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> listItem;
    EditText inputField;
    Button btnAdd;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Ánh xạ các view từ layout
        listView = findViewById(R.id.listview_simple);
        inputField = findViewById(R.id.edittext_input);
        btnAdd = findViewById(R.id.button_add);
        btnUpdate = findViewById(R.id.button_update);
        listItem = new ArrayList<>(Arrays.asList("Java", "C#", "PHP", "Javascript", "Python", "Kotlin"));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);

        // Gán adapter cho listview
        listView.setAdapter(adapter);

        final int[] itemIndex = {-1};

        // Bắt sự kiện click item trên listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = listItem.get(position);
                itemIndex[0] = position;
                inputField.setText(item);
            }
        });

        // Bắt sự kiện long click item trên listview
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete item")
                        .setMessage("Are you sure you want to delete this item?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Delete the item
                                listItem.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = inputField.getText().toString();
                if (item.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter item", Toast.LENGTH_SHORT).show();
                    return;
                }
                addItemToList(adapter, item);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = inputField.getText().toString();
                if (item.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter item", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (itemIndex[0] == -1) {
                    Toast.makeText(MainActivity.this, "Please select item to update", Toast.LENGTH_SHORT).show();
                    return;
                }
                listItem.set(itemIndex[0], item);
                adapter.notifyDataSetChanged();
                itemIndex[0] = -1;
            }
        });
    }

    private void addItemToList(ArrayAdapter adapter, String item) {
        listItem.add(item);
        // Cập nhật lại adapter
        adapter.notifyDataSetChanged();
    }

}
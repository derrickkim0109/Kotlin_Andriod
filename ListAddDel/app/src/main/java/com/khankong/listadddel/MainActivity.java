package com.khankong.listadddel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> Items;
    ArrayAdapter<String> Adapter;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Items = new ArrayList<String>();
        Items.add("First");
        Items.add("Second");
        Items.add("Third");

        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, Items);
        list = findViewById(R.id.list);
        list.setAdapter(Adapter);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        list.setOnItemClickListener(mItemClickListener);
        findViewById(R.id.add).setOnClickListener(mClickListener);
        findViewById(R.id.delete).setOnClickListener(mClickListener);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText ed = findViewById(R.id.newitem);
            switch (v.getId()){
                case R.id.add:
                    String text = ed.getText().toString();
                    if(text.length() != 0){
                        Items.add(text);
                        ed.setText("");
                        Adapter.notifyDataSetChanged();
                    }
                    break;
                case R.id.delete:
                    int id;
                    id = list.getCheckedItemPosition();
                    if(id != ListView.INVALID_POSITION){
                        Items.remove(id);
                        list.clearChoices();
                        Adapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    };

    AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String mes;
            mes = "Select Item = " + Items.get(position);
            Toast.makeText(MainActivity.this, mes, Toast.LENGTH_SHORT).show();

        }
    };

} // -----
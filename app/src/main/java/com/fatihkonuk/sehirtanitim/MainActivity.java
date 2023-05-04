package com.fatihkonuk.sehirtanitim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView fk_listView;
    private ArrayAdapter<String> fk_arrayAdapter;
    private ArrayList<String> fk_menu;
    private ArrayList<fk_Section> fk_sections;
    private fk_Repository fk_repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Ana Menü");
        init();

        fk_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent fk_intent;
                if (position == 0){
                    fk_intent = new Intent(MainActivity.this, fk_ContentActivity.class);
                    fk_intent.putExtra("parentId", 0);
                }
                else{
                    fk_intent = new Intent(MainActivity.this, fk_SubSectionActivity.class);
                    fk_intent.putExtra("parentId", fk_sections.get(position).id);
                }
                fk_intent.putExtra("sectionName", fk_sections.get(position).name);
                startActivity(fk_intent);
            }
        });
    }
    public void init() {
        fk_menu = new ArrayList<>();
        fk_repository = new fk_Repository();
        fk_sections = fk_repository.getAllSections();
        fk_sections.forEach(section -> fk_menu.add(section.name));

        fk_listView = findViewById(R.id.listView);
        fk_arrayAdapter = new ArrayAdapter<>(this, R.layout.row, fk_menu);
        fk_listView.setAdapter(fk_arrayAdapter);
    }
}
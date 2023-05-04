package com.fatihkonuk.sehirtanitim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class fk_SubSectionActivity extends AppCompatActivity {
    private ListView fk_listView;
    private ArrayAdapter<String> fk_arrayAdapter;
    private ArrayList<String> fk_menu;
    private ArrayList<fk_SubSection> fk_subSections;
    private fk_Repository fk_repository;
    private Intent fk_parentIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fk_sub_section);
        setTitle(getIntent().getStringExtra("sectionName"));
        init();

        fk_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(fk_SubSectionActivity.this, fk_ContentActivity.class);
                intent.putExtra("parentId", fk_subSections.get(position).id);
                startActivity(intent);
            }
        });
    }

    public void init() {
        fk_parentIntent = getIntent();
        fk_menu = new ArrayList<>();
        fk_repository = new fk_Repository();
        fk_subSections = fk_repository.getSubSectionsByParentId(fk_parentIntent.getIntExtra("parentId",-1));
        fk_subSections.forEach(section -> fk_menu.add(section.name));

        fk_listView = findViewById(R.id.subSectionlistView);
        fk_arrayAdapter = new ArrayAdapter<>(fk_SubSectionActivity.this, R.layout.row, fk_menu);
        fk_listView.setAdapter(fk_arrayAdapter);
    }
}
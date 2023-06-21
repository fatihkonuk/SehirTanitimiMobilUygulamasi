package com.fatihkonuk.sehirtanitim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class fk_MainMenuActivity extends AppCompatActivity {
    private ListView fk_listView;
    private ArrayAdapter<String> fk_arrayAdapter;
    private ArrayList<String> fk_menu;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fk_main_menu);
        this.setTitle("Ana Menü");
        init();
        db = FirebaseFirestore.getInstance();
        db.collection("sections")
                .orderBy("menuIndex")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document: task.getResult()) {
                                String fk_sectionName = document.get("name").toString();
                                fk_menu.add(fk_sectionName);
                                fk_arrayAdapter = new ArrayAdapter<>(fk_MainMenuActivity.this, R.layout.row, fk_menu);
                                fk_listView.setAdapter(fk_arrayAdapter);
                            }
                        }
                    }
                });
        fk_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    db.collection("contents")
                        .whereEqualTo("parentId","FsDm1A3GGar2dGssyNdX")
                        .limit(1)
                        .get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot querySnapshot) {
                            if (!querySnapshot.isEmpty()) {
                                DocumentSnapshot document = querySnapshot.getDocuments().get(0);
                                Intent fk_intent = new Intent(fk_MainMenuActivity.this, fk_ContentActivity.class);
                                fk_intent.putExtra("docId", document.getId());
                                fk_intent.putExtra("sectionName", document.get("name").toString());
                                startActivity(fk_intent);

                            } else {
                                // Belge bulunamadı
                            }
                        }
                    });
                }else {
                    db.collection("sections")
                    .whereEqualTo("menuIndex", position)
                    .limit(1)
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot querySnapshot) {
                            if (!querySnapshot.isEmpty()) {
                                DocumentSnapshot document = querySnapshot.getDocuments().get(0);
                                Intent fk_intent = new Intent(fk_MainMenuActivity.this, fk_SubSectionActivity.class);
                                fk_intent.putExtra("parentId", document.getId());
                                fk_intent.putExtra("sectionName", document.get("name").toString());
                                startActivity(fk_intent);

                            } else {
                                // Belge bulunamadı
                            }
                        }
                    });
                }
            }
        });
    }

    public void init() {
        fk_menu = new ArrayList<>();
        fk_listView = findViewById(R.id.listView);
    }
}
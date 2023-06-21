package com.fatihkonuk.sehirtanitim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class fk_SubSectionActivity extends AppCompatActivity {
    private ListView fk_listView;
    private ArrayAdapter<String> fk_arrayAdapter;
    private ArrayList<String> fk_menu;
    private Intent fk_parentIntent;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fk_sub_section);
        setTitle(getIntent().getStringExtra("sectionName"));
        init();
        String parentId = fk_parentIntent.getStringExtra("parentId");
        db.collection("contents")
                .whereEqualTo("parentId", parentId)
                .orderBy("menuIndex")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {
                        for (QueryDocumentSnapshot document : querySnapshot) {
                            String fk_sectionName = document.get("name").toString();
                            fk_menu.add(fk_sectionName);
                            fk_arrayAdapter = new ArrayAdapter<>(fk_SubSectionActivity.this, R.layout.row, fk_menu);
                            fk_listView.setAdapter(fk_arrayAdapter);
                        }
                        fk_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                db.collection("contents")
                                .whereEqualTo("menuIndex", position)
                                .whereEqualTo("parentId", parentId)
                                .limit(1)
                                .get()
                                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                    @Override
                                    public void onSuccess(QuerySnapshot querySnapshot) {
                                        if (!querySnapshot.isEmpty()) {
                                            DocumentSnapshot document = querySnapshot.getDocuments().get(0);
                                            Intent fk_intent = new Intent(fk_SubSectionActivity.this, fk_ContentActivity.class);
                                            fk_intent.putExtra("docId", document.getId());
                                            fk_intent.putExtra("sectionName", document.get("name").toString());
                                            startActivity(fk_intent);
                                        } else {
                                            // Belge bulunamadı
                                        }
                                    }
                                });
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Hata durumunda burada işlemler yapabilirsiniz
                    }
                });


    }

    public void init() {
        db = FirebaseFirestore.getInstance();
        fk_parentIntent = getIntent();
        fk_menu = new ArrayList<>();
        fk_listView = findViewById(R.id.subSectionlistView);
    }
}
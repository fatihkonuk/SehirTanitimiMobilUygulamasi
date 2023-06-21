package com.fatihkonuk.sehirtanitim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

public class fk_ContentActivity extends AppCompatActivity {
    private TextView fk_contentNameTxt,fk_contentDetailsTxt;
    private ImageView fk_contentImageView;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fk_content);
        setTitle(getIntent().getStringExtra("sectionName"));
        init();

        db.collection("contents")
                .document(getIntent().getStringExtra("docId"))
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        String name = documentSnapshot.get("name").toString();
                        String details = documentSnapshot.get("details").toString();
                        String fixedString = details.replace("\\n", "\n");
                        String imgUrl = documentSnapshot.get("imgUrl").toString();

                        fk_contentNameTxt.setText(name);
                        fk_contentDetailsTxt.setText(fixedString);
                        Picasso.get().load(imgUrl).into(fk_contentImageView);
                    }
                });
    }
    public void init() {
        fk_contentNameTxt = findViewById(R.id.contentNameTextView);
        fk_contentDetailsTxt = findViewById(R.id.contentDetailsTextView);
        fk_contentImageView = findViewById(R.id.contentImageView);
        //Database
        db = FirebaseFirestore.getInstance();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.header_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            startActivity(new Intent(fk_ContentActivity.this,fk_AddActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
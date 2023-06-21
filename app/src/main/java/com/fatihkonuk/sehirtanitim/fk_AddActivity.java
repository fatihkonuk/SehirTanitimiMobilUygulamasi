package com.fatihkonuk.sehirtanitim;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class fk_AddActivity extends AppCompatActivity {
    EditText editName,editDescription;
    Button saveBtn, uploadBtn;
    ImageView imgView;
    String txtName,txtDesc;
    RadioGroup radioGroup;
    RadioButton radioBtn1,radioBtn2,radioBtn3;
    String parentId;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fk_add);
        init();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        parentId = "pZ9WypuVmKd802hrHYtj";
                        break;
                    case R.id.radioButton2:
                        parentId = "odDrI2AsLCHGJiqxqyb5";
                        break;
                    case R.id.radioButton3:
                        parentId = "odmUnZYRS9AX92MYbKfO";
                        break;
                }
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName = editName.getText().toString();
                txtDesc = editDescription.getText().toString();
                if (!TextUtils.isEmpty(txtName) && !TextUtils.isEmpty(txtDesc)) {
                    db.collection("contents")
                    .whereEqualTo("parentId",parentId)
                    .orderBy("menuIndex")
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            int lastIndex = -1;
                            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                                lastIndex = (Integer) document.get("menuIndex");
                            }
                            HashMap<String,Object> mData = new HashMap<>();
                            mData.put("name",txtName);
                            mData.put("description",txtDesc);
                            mData.put("parentId",parentId);
                            mData.put("menuIndex",lastIndex+1);

                            db.collection("contents").document().set(mData)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(fk_AddActivity.this, "Başarılı Şekilde Eklendi", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(fk_AddActivity.this,fk_MainMenuActivity.class);
                                    startActivity(intent);
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(fk_AddActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });

                }else {
                    Toast.makeText(fk_AddActivity.this, "Lütfen Tüm Alanları Doldurun", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        editName = findViewById(R.id.editTextName);
        editDescription = findViewById(R.id.editTextDesc);
        saveBtn = findViewById(R.id.saveBtn);
        uploadBtn = findViewById(R.id.uploadBtn);
        imgView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);
        radioBtn1 = findViewById(R.id.radioButton);
        radioBtn2 = findViewById(R.id.radioButton2);
        radioBtn3 = findViewById(R.id.radioButton3);
        db = FirebaseFirestore.getInstance();
    }

    public void uploadImg(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                Uri selectedImageUri = data.getData();
                ImageView ds = findViewById(R.id.imageView);
                ds.setImageURI(selectedImageUri);
            }
        }
    }

}
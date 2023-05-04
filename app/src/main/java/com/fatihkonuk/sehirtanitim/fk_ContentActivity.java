package com.fatihkonuk.sehirtanitim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class fk_ContentActivity extends AppCompatActivity {
    private Intent fk_intent;
    private TextView fk_contentNameTxt,fk_contentDetailsTxt;
    private ImageView fk_contentImageView;
    private fk_Content fk_content;
    private fk_Repository fk_repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fk_content);
        init();

        if (fk_content != null) {
            setTitle(fk_content.name);
            fk_contentNameTxt.setText(fk_content.name);
            fk_contentDetailsTxt.setText(fk_content.details);
            fk_contentImageView.setImageResource(fk_content.img);
        }
    }
    public void init() {
        fk_intent = getIntent();
        fk_contentNameTxt = findViewById(R.id.contentNameTextView);
        fk_contentDetailsTxt = findViewById(R.id.contentDetailsTextView);
        fk_contentImageView = findViewById(R.id.contentImageView);
        //İçerik
        fk_repository = new fk_Repository();
        fk_content = fk_repository.getContentByParentId(fk_intent.getIntExtra("parentId",-1));
    }
}
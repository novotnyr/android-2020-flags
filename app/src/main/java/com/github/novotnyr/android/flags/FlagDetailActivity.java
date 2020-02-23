package com.github.novotnyr.android.flags;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FlagDetailActivity extends AppCompatActivity {

    private ImageView flagImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_detail);

        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Flag flag = (Flag) intent.getSerializableExtra("flag");
        if (flag == null) {
            return;
        }
        setTitle(flag.getCountry());
        flagImageView = findViewById(R.id.flagImageView);
        flagImageView.setImageResource(flag.getResource());
    }
}

package com.github.novotnyr.android.flags;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements FlagOnClickListener {
    private RecyclerView flagsRecyclerView;

    private FlagsViewModel flagsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FlagAdapter flagAdapter = new FlagAdapter(this);

        flagsRecyclerView = findViewById(R.id.flagsRecyclerView);
        flagsRecyclerView.setAdapter(flagAdapter);
        flagsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        flagsViewModel = new ViewModelProvider(this).get(FlagsViewModel.class);
        flagsViewModel.getFlags().observe(this, new Observer<List<Flag>>() {
            @Override
            public void onChanged(List<Flag> flags) {
                flagAdapter.setFlags(flags);
            }
        });
    }


    @Override
    public void onFlagClick(Flag flag) {
        Intent showFlagIntent = new Intent(this, FlagDetailActivity.class);
        showFlagIntent.putExtra("flag", flag);
        startActivity(showFlagIntent);
    }
}

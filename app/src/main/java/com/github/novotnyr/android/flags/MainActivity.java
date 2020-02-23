package com.github.novotnyr.android.flags;

import java.util.List;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity {
    private RecyclerView flagsRecyclerView;

    private FlagsViewModel flagsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FlagAdapter flagAdapter = new FlagAdapter();

        flagsRecyclerView = findViewById(R.id.flagsRecyclerView);
        flagsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        flagsRecyclerView.setAdapter(flagAdapter);

        flagsViewModel = new ViewModelProvider(this).get(FlagsViewModel.class);
        flagsViewModel.getFlags().observe(this, new Observer<List<Flag>>() {
            @Override
            public void onChanged(List<Flag> flags) {
                flagAdapter.setFlags(flags);
            }
        });
    }
}

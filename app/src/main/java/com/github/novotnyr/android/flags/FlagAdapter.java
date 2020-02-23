package com.github.novotnyr.android.flags;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FlagAdapter extends RecyclerView.Adapter<FlagViewHolder> {
    private List<Flag> flags = new ArrayList<>();

    @NonNull
    @Override
    public FlagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);

        return new FlagViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull FlagViewHolder holder, int position) {
        holder.bind(flags.get(position));
    }

    @Override
    public int getItemCount() {
        return flags.size();
    }

    public void setFlags(List<Flag> flags) {
        this.flags = flags;
        notifyDataSetChanged();
    }
}

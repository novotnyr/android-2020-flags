package com.github.novotnyr.android.flags;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class FlagListAdapter extends ListAdapter<Flag, FlagViewHolder> {
    private FlagOnClickListener flagOnClickListener;

    public FlagListAdapter(FlagOnClickListener flagOnClickListener) {
        super(flagDiff);
        this.flagOnClickListener = flagOnClickListener;
    }

    @NonNull
    @Override
    public FlagViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);

        return new FlagViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull FlagViewHolder holder, int position) {
        holder.bind(getItem(position), flagOnClickListener);
    }

    private static DiffUtil.ItemCallback<Flag> flagDiff = new DiffUtil.ItemCallback<Flag>() {
        @Override
        public boolean areItemsTheSame(@NonNull Flag oldItem, @NonNull Flag newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Flag oldItem, @NonNull Flag newItem) {
            return oldItem.equals(newItem);
        }
    };

    public void setFlags(List<Flag> flags) {
        submitList(flags);
    }
}

package com.github.novotnyr.android.flags;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class FlagViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public FlagViewHolder(View layout) {
        super(layout);
        textView = layout.findViewById(android.R.id.text1);
    }

    public void bind(final Flag flag) {
        this.textView.setText(flag.getCountry());
    }
}


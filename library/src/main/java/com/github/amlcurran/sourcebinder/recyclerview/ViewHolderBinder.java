package com.github.amlcurran.sourcebinder.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface ViewHolderBinder<Item, Holder extends RecyclerView.ViewHolder> {

    public Holder createViewHolder(ViewGroup viewGroup, int viewType);

    void bindViewHolder(Holder viewHolder, Item item);

    int getItemViewHolderType(int position, Item item);
}

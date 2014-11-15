package com.github.amlcurran.sourcebinder.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.github.amlcurran.sourcebinder.Source;

public class RecyclerSourceBinderAdapter<Item, Holder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<Holder> {

    private final Source<Item> source;
    private final ViewHolderBinder<Item, Holder> viewHolderBinder;

    public RecyclerSourceBinderAdapter(Source<Item> source, ViewHolderBinder<Item, Holder> viewHolderBinder) {
        this.source = source;
        this.source.setSourceChangeListener(new UpdateSelfListener());
        this.viewHolderBinder = viewHolderBinder;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        return viewHolderBinder.createViewHolder(viewGroup, viewType);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        viewHolderBinder.bindViewHolder(viewHolder, source.getAtPosition(position));
    }

    @Override
    public int getItemCount() {
        return source.getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return viewHolderBinder.getItemViewHolderType(position, source.getAtPosition(position));
    }

    private class UpdateSelfListener implements Source.SourceChangeListener {
        @Override
        public void sourceChanged() {
            notifyDataSetChanged();
        }
    }
}

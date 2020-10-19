package com.example.lab3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final List<UnnecessaryContent.UnnecessaryItem> mValues;
    FragmentManager fm;
    Fragment fragment;

    public RecyclerAdapter(List<UnnecessaryContent.UnnecessaryItem> items, FragmentManager fm) {
        mValues = items;
        this.fm = fm;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_useless, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.id.setText(mValues.get(position).id);
        holder.mContent.setText("Элемент " + mValues.get(position).id);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction()
                        .replace(R.id.fragment_container, new MetaFragment())
                        .commit();
                MetaFragment.pos = position;
            }
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public TextView id;
        public TextView mContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            id = (TextView) itemView.findViewById(R.id.tv_num);
            mContent = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}

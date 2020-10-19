package com.example.lab3;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final List<UnnecessaryContent.UnnecessaryItem> mValues;
    FragmentManager fm;
    MetaFragment fragment;
    final int TYPE;

    public RecyclerAdapter(List<UnnecessaryContent.UnnecessaryItem> items, FragmentManager fm, int TYPE) {
        if (TYPE == 0) {
            fragment = new MetaFragment();
        }
        mValues = items;
        this.fm = fm;
        this.TYPE = TYPE;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (TYPE) {
            case 0:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_useless, parent, false);
                return new ViewHolder(view);
            case 1:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_meta, parent, false);
                return new ViewHolder(view);
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        switch (TYPE) {
            case 0:
                holder.id.setText(mValues.get(position).id);
                holder.mContent.setText("Элемент " + mValues.get(position).id);
                holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        fm.beginTransaction()
                                .replace(R.id.fragment_container, fragment)
                                .commit();
                        fragment.setPos(position);
                     }
                });
                break;
            case 1:
                if (position > 0){
                    holder.detailInform.setText("Детальная информация");

                } else {
                    holder.about_El.setText("Информация об элементе " + fragment.getPos());
                    holder.detailInform.setText("Детальная информация");
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public TextView id;
        public TextView mContent;
        public TextView detailInform;
        public TextView about_El;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            id = (TextView) itemView.findViewById(R.id.tv_num);
            mContent = (TextView) itemView.findViewById(R.id.tv_content);
            detailInform = (TextView) itemView.findViewById(R.id.some_inf_);
            about_El = (TextView) itemView.findViewById(R.id.data_of_el);
        }
    }
}

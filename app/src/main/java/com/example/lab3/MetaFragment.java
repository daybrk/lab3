package com.example.lab3;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MetaFragment extends Fragment implements BackPressedForFragments {

    TextView id;
    private static int pos = 0;

    public static int getPos() {
        return pos;
    }

    public static void setPos(int pos) {
        MetaFragment.pos = pos;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_useless_list, container, false);

        FragmentManager fragmentManager = getFragmentManager();

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new RecyclerAdapter(UnnecessaryContent.ITEMS_2, fragmentManager, 1));

        return view;
    }


    @Override
    public void onBackPressed() {
    }
}
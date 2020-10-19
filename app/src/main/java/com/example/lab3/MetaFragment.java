package com.example.lab3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MetaFragment extends Fragment implements BackPressedForFragments {

    TextView id;
    public static Integer pos = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meta, container, false);

        id = (TextView) view.findViewById(R.id.data_of_el);
        id.setText(id.getText() + " " + pos);
        return view;
    }


    @Override
    public void onBackPressed() {
    }
}
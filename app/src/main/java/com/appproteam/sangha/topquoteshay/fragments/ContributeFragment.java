package com.appproteam.sangha.topquoteshay.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appproteam.sangha.topquoteshay.R;


public class ContributeFragment extends Fragment {
    public static ContributeFragment contributeFragment;






    public static ContributeFragment getInstance() {
        if(contributeFragment==null)
            contributeFragment = new ContributeFragment();

        return contributeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contribute, container, false);
        return view;
    }

}

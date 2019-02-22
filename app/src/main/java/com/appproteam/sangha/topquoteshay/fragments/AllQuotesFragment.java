package com.appproteam.sangha.topquoteshay.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appproteam.sangha.topquoteshay.CustomListView.AdapterQuotes;
import com.appproteam.sangha.topquoteshay.CustomListView.ObjectQuotes;
import com.appproteam.sangha.topquoteshay.R;
import com.appproteam.sangha.topquoteshay.TotalQuotesData;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllQuotesFragment extends Fragment {

    public static AllQuotesFragment allQuotesFragment=null;
    View view;
    RecyclerView recyclerView;
    public static AllQuotesFragment getInstance() {

        if(allQuotesFragment==null)
             allQuotesFragment = new AllQuotesFragment();
        return AllQuotesFragment.allQuotesFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view =inflater.inflate(R.layout.fragment_all_quotes, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_topquotes);
        List<ObjectQuotes> currentListQuotes = TotalQuotesData.getInstance().getListQuotesType(0);
        AdapterQuotes adapterQuotes = new AdapterQuotes(getContext(),currentListQuotes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapterQuotes);

        return view;
    }

}

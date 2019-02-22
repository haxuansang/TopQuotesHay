package com.appproteam.sangha.topquoteshay.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import com.appproteam.sangha.topquoteshay.CustomListView.CustomAdapterNew;
import com.appproteam.sangha.topquoteshay.CustomListView.ObjectQuotes;
import com.appproteam.sangha.topquoteshay.ListActivity;
import com.appproteam.sangha.topquoteshay.MainActivity;
import com.appproteam.sangha.topquoteshay.R;
import com.appproteam.sangha.topquoteshay.TotalQuotesData;

import java.util.ArrayList;

/**
 * Created by SangHa on 2/23/2018.
 */

public class QuotesFragment extends Fragment {

    public static QuotesFragment quotesFragment;
    //public static  CustomAdapterNew adapterCase
    ListView customListview;
     ViewPager viewPager;
     TabLayout tabLayout;

    public static QuotesFragment getInstance()
    {
        if(quotesFragment==null) {
            quotesFragment = new QuotesFragment();

        }
        return  quotesFragment;

    }


    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.quotesfragment,container,false);
        //customListview =(ListView)view.findViewById(R.id.customListView);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        //adapterCase = new CustomAdapterNew(view.getContext(),R.layout.listview_layout, TotalQuotesData.getInstance().getListQuotesType(ListActivity.position));
       // customListview.setAdapter(adapterCase);
        setUpTabLayout();

        return view;


    }

    private void setUpTabLayout() {

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getChildFragmentManager());
        viewPagerAdapter.addFragment(new AllQuotesFragment());
        viewPagerAdapter.addFragment(new AllQuotesFragment());
        viewPagerAdapter.addFragment(new AllQuotesFragment());
        viewPagerAdapter.addFragment(new AllQuotesFragment());
        viewPagerAdapter.addFragment(new AllQuotesFragment());
        viewPagerAdapter.addFragment(new AllQuotesFragment());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabsFromPagerAdapter(viewPagerAdapter);
    }


}

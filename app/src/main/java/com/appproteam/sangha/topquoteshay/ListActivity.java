package com.appproteam.sangha.topquoteshay;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.appproteam.sangha.topquoteshay.CustomListView.ObjectQuotes;
import com.appproteam.sangha.topquoteshay.fragments.CheckFragment;
import com.appproteam.sangha.topquoteshay.fragments.ContributeFragment;
import com.appproteam.sangha.topquoteshay.fragments.QuotesFragment;
import com.appproteam.sangha.topquoteshay.fragments.ViewPagerAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    RelativeLayout linearLayout;
    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    public static int position;
    FragmentTransaction fragmentTransaction;
    Fragment quoteFragment;
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        linearLayout=(RelativeLayout) findViewById(R.id.listviewLayout);
        bottomNavigationView= (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentManager=getSupportFragmentManager();;
        fragmentTransaction.add(R.id.frame_layout, QuotesFragment.getInstance());

        fragmentTransaction.commit();






        if(TotalQuotesData.getInstance().getSizeOfListQuote(position)==0)
            Toast.makeText(this, "Please check the internet connection", Toast.LENGTH_SHORT).show();

                linearLayout.setBackground(getResources().getDrawable(R.drawable.family));


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        fragmentTransaction= getSupportFragmentManager().beginTransaction();
        switch (item.getItemId())
        {
            case R.id.item_quotepage:
                fragmentTransaction.replace(R.id.frame_layout,QuotesFragment.getInstance());
                break;
            case R.id.item_favorite_bottom:
                fragmentTransaction.replace(R.id.frame_layout, CheckFragment.getInstance());
                break;
            case  R.id.item_contribute:
                fragmentTransaction.replace(R.id.frame_layout, ContributeFragment.getInstance());
                break;


        }
        fragmentTransaction.commit();
        return true;
    }
}

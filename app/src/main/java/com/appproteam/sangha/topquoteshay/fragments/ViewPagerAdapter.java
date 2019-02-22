package com.appproteam.sangha.topquoteshay.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SangHa on 2/23/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position)
    {
        return mFragmentList.get(position);

    }
    public void addFragment(Fragment mFragment)

    {
        mFragmentList.add(mFragment);
    }
    @Override
    public int getCount()
    {
        return 6;

    }
    @Override
    public CharSequence getPageTitle(int position)
    {
        String title="";
        switch(position)
        {
            case 0:
                title="Tất cả";
                break;
            case 1:
                title="Cuộc sống";
                break;
            case 2:
                title="Tình Yêu";
                break;
            case 3:
                title="Gia Đình";
                break;
            case 4:
                title="Sự Nghiệp";
                break;
            case 5:
                title="Tình Bạn";
                break;

        }
        return title;
    }

}

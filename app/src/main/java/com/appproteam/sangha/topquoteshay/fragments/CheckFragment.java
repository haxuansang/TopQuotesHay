package com.appproteam.sangha.topquoteshay.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.appproteam.sangha.topquoteshay.CustomListView.CustomAdapterNew;
import com.appproteam.sangha.topquoteshay.MainActivity;
import com.appproteam.sangha.topquoteshay.R;

/**
 * Created by SangHa on 2/23/2018.
 */

public class CheckFragment extends Fragment {
    public static CheckFragment checkFragment;
   ListView lvCheckedQuotes;
   public  static View view;
   public static CustomAdapterNew adapterCustomChecked;



    public static CheckFragment getInstance()
    {
        if(checkFragment==null)
            checkFragment = new CheckFragment();
        return  checkFragment;
    }
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {

       view =inflater.inflate(R.layout.checkedfragment,container,false);
       lvCheckedQuotes=(ListView)view.findViewById(R.id.checkedListView);
       adapterCustomChecked=new CustomAdapterNew(view.getContext(),R.layout.listview_layout,MainActivity.CheckedQuotes);
       lvCheckedQuotes.setAdapter(adapterCustomChecked);
       return view;

   }


}

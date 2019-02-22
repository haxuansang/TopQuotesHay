package com.appproteam.sangha.topquoteshay;

import com.appproteam.sangha.topquoteshay.CustomListView.ObjectQuotes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TotalQuotesData  {
    private static TotalQuotesData totalQuotesData;
    private HashMap<String,List<ObjectQuotes>> totalDataHashMap=new HashMap<>();

    public  static synchronized  TotalQuotesData getInstance()
    {
        if (totalQuotesData==null) {
            totalQuotesData = new TotalQuotesData();
            List<ObjectQuotes> listTopQuotes=  new ArrayList<>();
            List<ObjectQuotes> listLifeQuotes = new ArrayList<>();
            List<ObjectQuotes> listLoveQuotes = new ArrayList<>();
            List<ObjectQuotes> listFamilyQuotes = new ArrayList<>();
            List<ObjectQuotes> listJobQuotes = new ArrayList<>();
            List<ObjectQuotes> listFriendQuotes = new ArrayList<>();
            totalQuotesData.totalDataHashMap.put("topquote",listTopQuotes);
            totalQuotesData.totalDataHashMap.put("lifequote",listLifeQuotes);
            totalQuotesData.totalDataHashMap.put("lovequote",listLoveQuotes);
            totalQuotesData.totalDataHashMap.put("familyquote",listFamilyQuotes);
            totalQuotesData.totalDataHashMap.put("jobquote",listJobQuotes);
            totalQuotesData.totalDataHashMap.put("friendquote",listFriendQuotes);

        }

        return totalQuotesData;


    }
    public List<ObjectQuotes> getListQuotesType(int i)
    {
        switch (i)
        {
            case 0:
                return this.totalDataHashMap.get("topquote");
            case 1:
                return this.totalDataHashMap.get("lifequote");
            case 2:
                return this.totalDataHashMap.get("lovequote");
            case 3:
                return this.totalDataHashMap.get("familyquote");
            case 4:
                return this.totalDataHashMap.get("jobquote");
            case 5:
                return this.totalDataHashMap.get("friendquote");


        }
        return null;
    }
    public void addListToTotalQuotesList(List<ObjectQuotes> currentList,int i)
    {
        getListQuotesType(i).addAll(currentList);

    }
    public int getSizeOfListQuote(int i)
    {
        return getListQuotesType(i).size();
    }
}

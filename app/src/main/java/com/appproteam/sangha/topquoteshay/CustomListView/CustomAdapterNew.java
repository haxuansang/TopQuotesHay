package com.appproteam.sangha.topquoteshay.CustomListView;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.appproteam.sangha.topquoteshay.ListActivity;
import com.appproteam.sangha.topquoteshay.MainActivity;
import com.appproteam.sangha.topquoteshay.R;
import com.appproteam.sangha.topquoteshay.TotalQuotesData;
import com.appproteam.sangha.topquoteshay.fragments.CheckFragment;
import com.appproteam.sangha.topquoteshay.fragments.QuotesFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SangHa on 4/2/2018.
 */

public class CustomAdapterNew extends ArrayAdapter {
    Context context;
    int resource;
    List<ObjectQuotes> arrObjectQuotes ;
    public CustomAdapterNew( Context context, int resource, List<ObjectQuotes> objects) {
        super(context, resource, objects);
        this.context= context;
        this.resource= resource;
        this.arrObjectQuotes=objects;
    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        MainActivity.sqLiteDatabase = MainActivity.myDBHelper.getWritableDatabase();
        
        if (convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.listview_layout,parent,false);
            viewHolder= new ViewHolder();
            viewHolder.tvQuotes= (TextView)convertView.findViewById(R.id.tvQuotes);
            viewHolder.tvWriters= (TextView)convertView.findViewById(R.id.tvWriters);
            viewHolder.imbStars= (ImageButton) convertView.findViewById(R.id.imbStar);
            viewHolder.imbCopy= (ImageButton) convertView.findViewById(R.id.imbCopy);
            convertView.setTag(viewHolder);


        }
        else
        {
            viewHolder= (ViewHolder)convertView.getTag();
        }
        final ObjectQuotes currentObject=arrObjectQuotes.get(position);
        viewHolder.tvQuotes.setText(currentObject.getQuotes());
        viewHolder.tvWriters.setText(currentObject.getWriter());
        if (currentObject.isChecked()==true)
        {
            viewHolder.imbStars.setBackground(convertView.getResources().getDrawable(R.drawable.starchecked));
        }
        else
            viewHolder.imbStars.setBackground(convertView.getResources().getDrawable(R.drawable.star));

       viewHolder.imbStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentObject.isChecked()==false) {
                        viewHolder.imbStars.setBackgroundResource(R.drawable.starchecked);
                        MainActivity.sqLiteDatabase.insert(MainActivity.myDBHelper.TABLE_NAME, null, quotes_fragment(currentObject.getQuotes(), currentObject.getWriter(),currentObject.getPosition()));
                        currentObject.setChecked(true);
                        MainActivity.CheckedQuotes.add(currentObject);





                }

                else {

                    viewHolder.imbStars.setBackgroundResource(R.drawable.star);
                    MainActivity.sqLiteDatabase.delete(MainActivity.myDBHelper.TABLE_NAME, "quotes=?", new String[]{String.valueOf(currentObject.getQuotes())});
                    int positionChecked=checkQuoteInArray(currentObject,MainActivity.CheckedQuotes);
                    if(positionChecked!=-1)
                         MainActivity.CheckedQuotes.remove(positionChecked);
                    /*setFalseForCurrentArray(currentObject,currentObject.getPosition());*/

                }

                CheckFragment.adapterCustomChecked.notifyDataSetChanged();


            }
        });

        return convertView;
    }
    public class ViewHolder
    {
        TextView tvQuotes,tvWriters;
        ImageButton imbStars,imbCopy;
    }
    public ContentValues quotes_fragment(String quotes, String author,int position )
    {
        ContentValues ct = new ContentValues();
        ct.put("quotes",quotes);
        ct.put("author",author);
        ct.put("position",position);
        return ct;
    }
    public int checkQuoteInArray(ObjectQuotes objectQuotes,ArrayList<ObjectQuotes> arrObjectQuotes)
    {
        for (int i=0;i<arrObjectQuotes.size();i++)
        {
            if (objectQuotes.equals(arrObjectQuotes.get(i)))
            {
                return i;
            }
        }
        return -1;
    }


   /* public static  void notifyChanged(int i)
    {
        switch (i)
        {
            case 1:
                break;
            case 2:
                QuotesFragment.adapterCase2.notifyDataSetChanged();
                break;
            case 3:
                QuotesFragment.adapterCase3.notifyDataSetChanged();
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;

        }
    }*/
}

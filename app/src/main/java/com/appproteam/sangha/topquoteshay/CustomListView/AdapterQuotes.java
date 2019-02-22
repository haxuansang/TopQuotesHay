package com.appproteam.sangha.topquoteshay.CustomListView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.appproteam.sangha.topquoteshay.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterQuotes extends RecyclerView.Adapter<AdapterQuotes.viewHolder> {
    Context context;
    List<ObjectQuotes> mListObjects;
    public AdapterQuotes(Context context, List<ObjectQuotes> mListObject)
    {
        this.context= context;
        this.mListObjects=mListObject;
    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_layout,parent,false);
       return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        holder.tvQuotes.setText(mListObjects.get(position).getQuotes());
        holder.tvWriters.setText(mListObjects.get(position).getWriter());


    }

    @Override
    public int getItemCount() {
        return mListObjects.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder{
        TextView tvQuotes,tvWriters;
        ImageButton imbStars,imbCopy;
        public viewHolder(View itemView) {
            super(itemView);
           tvQuotes= (TextView)itemView.findViewById(R.id.tvQuotes);
        tvWriters= (TextView)itemView.findViewById(R.id.tvWriters);
           imbStars= (ImageButton) itemView.findViewById(R.id.imbStar);
          imbCopy= (ImageButton) itemView.findViewById(R.id.imbCopy);

        }
    }
}

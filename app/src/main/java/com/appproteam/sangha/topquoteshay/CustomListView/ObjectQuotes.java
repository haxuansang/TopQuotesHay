package com.appproteam.sangha.topquoteshay.CustomListView;

/**
 * Created by SangHa on 2/22/2018.
 */

public class ObjectQuotes {
    String quotes,writer;
    boolean checked;
    int position;

    public ObjectQuotes()
    {
        this.quotes="";
        this.writer="";
        this.checked=false;
        this.position=1;
    }
    public ObjectQuotes(String quotes, String writer) {
        this.quotes = quotes;
        this.writer = writer;
        this.checked= false;
        this.position=1;
    }
    public ObjectQuotes(String quotes, String writer,boolean checked,int position) {
        this.quotes = quotes;
        this.writer = writer;
        this.checked= checked;
        this.position= position;
    }

    public String getQuotes() {
        return this.quotes;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition()
    {
        return position;

    }
}

package com.appproteam.sangha.topquoteshay;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.appproteam.sangha.topquoteshay.CustomListView.ObjectQuotes;
import com.appproteam.sangha.topquoteshay.SQLiteDatabase.MyDBHelper;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    Button btnTop,btnLife,btnLove,btnFamily,btnJob,btnFriend;
    public static MyDBHelper myDBHelper;
    public static SQLiteDatabase sqLiteDatabase;
    ProgressBar progressBar;
    public static ArrayList<ObjectQuotes> CheckedQuotes= new ArrayList<>();
    public static DatabaseReference mData;
    public Intent intent ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        progressBar =(ProgressBar)findViewById(R.id.progressbar_loading);

        intent= new Intent(this,ListActivity.class);
        myDBHelper = new MyDBHelper(getApplicationContext());
        loadingSQLCheckedDatabase();
        loadingData();
    }


    public static  void loadingSQLCheckedDatabase()
    {
        Cursor cursor;
        CheckedQuotes.clear();
        sqLiteDatabase= myDBHelper.getReadableDatabase();
        cursor = sqLiteDatabase.query(MyDBHelper.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToFirst();
        while(cursor.moveToNext())
            CheckedQuotes.add(new ObjectQuotes(cursor.getString(1).toString(),cursor.getString(2).toString(),true,cursor.getInt(3)));

    }



    public void loadingData()
    {

        if (mData==null)
        mData = FirebaseDatabase.getInstance().getReference();
        /*
        mData.child("TopQuotes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot all_data : dataSnapshot.getChildren())
                {
                    ObjectQuotes objectQuotes = all_data.getValue(ObjectQuotes.class);
                    objectQuotes.setPosition(1);
                    TopQuotes.add(objectQuotes);

                }
                TotalQuotesData.getInstance().addListToTotalQuotesList(TopQuotes,0);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });*/
        if(TotalQuotesData.getInstance().getSizeOfListQuote(0)==0) {
            final List<ObjectQuotes> TopQuotes = new ArrayList<>();
            mData.child("LifeQuotes").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot all_data : dataSnapshot.getChildren()) {
                        ObjectQuotes objectQuotes = all_data.getValue(ObjectQuotes.class);
                        objectQuotes.setPosition(0);
                        TopQuotes.add(objectQuotes);
                    }
                    TotalQuotesData.getInstance().addListToTotalQuotesList(TopQuotes, 0);
                    turnOffProgress();
                    startActivity(intent);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    turnOffProgress();
                    showToastError();
                    startActivity(intent);
                }
            });
        }



    /*   mData.child("FamilyQuotes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FamilyQuotes.clear();
                for (DataSnapshot all_data : dataSnapshot.getChildren())
                {
                    ObjectQuotes objectQuotes = all_data.getValue(ObjectQuotes.class);
                    FamilyQuotes.add(objectQuotes);
                }


            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("JobsQuotes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                JobsQuotes.clear();
                for (DataSnapshot all_data : dataSnapshot.getChildren())
                {
                    ObjectQuotes objectQuotes = all_data.getValue(ObjectQuotes.class);
                    JobsQuotes.add(objectQuotes);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mData.child("FriendsQuotes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FriendsQuotes.clear();
                for (DataSnapshot all_data : dataSnapshot.getChildren())
                {
                    ObjectQuotes objectQuotes = all_data.getValue(ObjectQuotes.class);
                    FriendsQuotes.add(objectQuotes);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/
        }




    private void showToastError() {
        Toast.makeText(MainActivity.this, "Please check the internet connection", Toast.LENGTH_SHORT).show();
    }

    private void turnOffProgress() {
        if (progressBar.getVisibility()==View.VISIBLE)
             progressBar.setVisibility(View.GONE);

    }

}

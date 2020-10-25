package com.cobiz.codataapi;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cobiz.codata.Corona;

import java.util.ArrayList;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    private static String url = "https://corona-api.com/countries";
    private int visibleItemCount;
    private int totalItemCount;
    private int firstVisibleItemPosition;
    private int pastVisiblesItems;
    private LinearLayoutManager mLayoutManager;
    private boolean loading = true;
    private List<CovidInfo> coronaData = new ArrayList<>();
    ArrayList<CovidInfo> listData;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // data to populate the RecyclerView with
        startLoadData();
        // set up the RecyclerView
        recyclerView = findViewById(R.id.rvCovidList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        visibleItemCount = mLayoutManager.getChildCount();
        totalItemCount = mLayoutManager.getItemCount();
        firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = mLayoutManager.getChildCount(); //13
                    totalItemCount = listData.size(); //249
                    pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                    if (loading) {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                            loading = false;
                        }
                        for (int i = currentIndex; i < currentIndex + visibleItemCount; i++) {
                            if (currentIndex < totalItemCount && i < totalItemCount)
                                coronaData.add(listData.get(i));
                        }
                        currentIndex = currentIndex + visibleItemCount;
                        adapter.updateData(coronaData);
                    }
                }
            }
        };
        recyclerView.addOnScrollListener(onScrollListener);
    }

    private void startLoadData() {

        new JSONParse().execute();
    }

    private class JSONParse extends AsyncTask<String, String, List<Corona>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Corona> doInBackground(String... args) {
            JSONParser jParser = new JSONParser();
            // Getting JSON from URL
            List<Corona> coronaList = jParser.getJSONFromUrl(url);
            return coronaList;
        }

        @Override
        protected void onPostExecute(List<Corona> json) {
            // Getting JSON Array
            loadData(json);
        }

    }

    private void loadData(List<Corona> data) {

        listData = new ArrayList<CovidInfo>();
        adapter = new MyRecyclerViewAdapter(this, listData);
        if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                CovidInfo coronaData = new CovidInfo();
                coronaData.setId(i);
                coronaData.setCountryName(data.get(i).getName());
                coronaData.setDeathCount(data.get(i).getLatest_data().getDeaths());
                coronaData.setRecoverCount(data.get(i).getLatest_data().getRecovered());
                listData.add(coronaData);
            }

            for (currentIndex = 0; currentIndex < 13; currentIndex++) {
                coronaData.add(listData.get(currentIndex));
            }
            adapter.updateData(coronaData);
        }

        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);
    }

    //ToDo
    @Override
    public void onItemClick(View view, int position) {
        //Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
package com.cobiz.codataapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.cobiz.codata.Country;
import com.cobiz.codata.Timeline;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    List<Timeline> timeLine;
    BarDataSet deaths, recoveries;
    ArrayList<BarEntry> totalDeaths;
    ArrayList<BarEntry> totalRecoveries;
    private BarChart chart;
    private List<String> monthList = new ArrayList<>(Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")) ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        Country data = (Country)intent.getExtras().getSerializable("countryData");
        setTitle("Pandemic Data of : "+data.getName());
        totalDeaths = new ArrayList<>();
        totalRecoveries = new ArrayList<>();


        timeLine = data.getTimeline();
        chart = findViewById(R.id.fragment_groupedbarchart_chart);
        chart.setEnabled(false);
        chart.setPinchZoom(false);
        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);
        getLastTwelveMonths(timeLine);
    }

    private void getLastTwelveMonths(List<Timeline> timeLine) {

        Date today = new Date();
        int j =0;
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<String> labels = new ArrayList<>();
        ArrayList<BarDataSet> dataSetValues = new ArrayList<>();



            for(Timeline dataTime : timeLine)
            {
                int index =0;
                String dateCorrection = dataTime.getUpdated_at().substring(0,10);
                for (int i=1;i>=-12;i--) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(today);
                    calendar.add(Calendar.MONTH, i);
                    calendar.set(Calendar.DAY_OF_MONTH, 1);
                    calendar.add(Calendar.DATE, -1);


                    Date firstDayOfMonth = calendar.getTime();
                    String formattedDate = sdf.format(firstDayOfMonth);
                    if (dateCorrection.equals(formattedDate)) {
                        if(!labels.contains(monthList.get(Integer.parseInt(formattedDate.substring(5,7))-1)))
                        {

                            totalDeaths.add(new BarEntry(dataTime.getDeaths(), index));
                            totalRecoveries.add(new BarEntry(dataTime.getRecovered(), index));
                            formattedDate.substring(5,7);                        ;
                            labels.add(monthList.get(Integer.parseInt(formattedDate.substring(5,7))-1));
                            index++;
                            break;
                        }


                    }

                }
            }
        recoveries = new BarDataSet(totalRecoveries, "Recoveries");
        deaths = new BarDataSet(totalDeaths, "Deaths");
        deaths.setColor(Color.rgb(255, 0, 0));
        recoveries.setColor(Color.rgb(164, 228, 251));
        dataSetValues.add(recoveries);
        dataSetValues.add(deaths);

        BarData data = new BarData(labels,dataSetValues);
        chart.setData(data);


    }
}


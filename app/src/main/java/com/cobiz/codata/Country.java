package com.cobiz.codata;

import java.io.Serializable;
import java.util.List;

public class Country implements Serializable {

    private String name;
    private String code;

    private long population;
    private String updated_at;
    private Todaydata today;
    private Latestdata latest_data;
    private Coords coordinates;
    private List<Timeline> timeline;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Todaydata getToday() {
        return today;
    }

    public void setToday(Todaydata today) {
        this.today = today;
    }

    public Latestdata getLatest_data() {
        return latest_data;
    }

    public void setLatest_data(Latestdata latest_data) {
        this.latest_data = latest_data;
    }

    public Coords getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coords coordinates) {
        this.coordinates = coordinates;
    }


    public List<Timeline> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<Timeline> timeline) {
        this.timeline = timeline;
    }

    @Override
    public String toString() {
        return "   Name: " + this.getName() + "\n" +
                "   Coordinates: " + this.getCoordinates().getLatitude() + ", " + this.getCoordinates().getLongitude() + "\n" +
                "   Population:" + this.getPopulation() + "\n" +
                "   Updated at: " + this.getUpdated_at() + "\n" +
                "   Today's Deaths: " + this.getToday().getDeaths() + "\n" +
                "   Today's Confirmed: " + this.getToday().getConfirmed() + "\n" +
                "   Latest Deaths: " + this.getLatest_data().getDeaths() + "\n" +
                "   Latest Confirmed: " + this.getLatest_data().getConfirmed() + "\n" +
                "   Latest Recovered: " + this.getLatest_data().getConfirmed() + "\n" +
                "   Latest Critical: " + this.getLatest_data().getCritical() + "\n" +
                "   Calculated Death Rate: " + this.getLatest_data().getCalculated().getDeath_rate() + "\n" +
                "   Calculated Recovery Rate: " + this.getLatest_data().getCalculated().getRecovery_rate() + "\n" +
                "   Recovered vs. Death Ratio: " + this.getLatest_data().getCalculated().getRecovered_vs_death_ratio() + "\n" +
                "   Cases per million: " + this.getLatest_data().getCalculated().getCases_per_million_population() + "\n" +
                ", timeline=" + timeline +
                '}';
    }
}

package com.cobiz.codata;

import java.io.Serializable;

public class Timeline implements Serializable {
    private String updated_at;
    private String date;
    private int deaths;
    private int confirmed;
    private int recovered;
    private int active;
    private int new_confirmed;
    private int new_deaths;
    private int new_recovered;
    private boolean is_in_progress;

    public boolean isIs_in_progress() {
        return is_in_progress;
    }

    public void setIs_in_progress(boolean is_in_progress) {
        this.is_in_progress = is_in_progress;
    }

    public int getNew_recovered() {
        return new_recovered;
    }

    public void setNew_recovered(int new_recovered) {
        this.new_recovered = new_recovered;
    }



    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getNew_confirmed() {
        return new_confirmed;
    }

    public void setNew_confirmed(int new_confirmed) {
        this.new_confirmed = new_confirmed;
    }

    public int getNew_deaths() {
        return new_deaths;
    }

    public void setNew_deaths(int new_deaths) {
        this.new_deaths = new_deaths;
    }
}

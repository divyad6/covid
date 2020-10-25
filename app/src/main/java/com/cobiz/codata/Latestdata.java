package com.cobiz.codata;

public class Latestdata {
    private int deaths;
    private int confirmed;
    private int recovered;
    private int critical;
    private Calcdata calculated;

    public Calcdata getCalculated() {
        return calculated;
    }

    public void setCalculated(Calcdata value) {
        this.calculated = value;
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

    public int getCritical() {
        return critical;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }
}

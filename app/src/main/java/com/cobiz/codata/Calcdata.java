package com.cobiz.codata;

public class Calcdata {
    private double death_rate;
    private double recovery_rate;
    private int recovered_vs_death_ratio;
    private int cases_per_million_population;

    public double getDeath_rate() {
        return death_rate;
    }

    public void setDeath_rate(double death_rate) {
        this.death_rate = death_rate;
    }

    public double getRecovery_rate() {
        return recovery_rate;
    }

    public void setRecovery_rate(double recovery_rate) {
        this.recovery_rate = recovery_rate;
    }

    public int getRecovered_vs_death_ratio() {
        return recovered_vs_death_ratio;
    }

    public void setRecovered_vs_death_ratio(int recovered_vs_death_ratio) {
        this.recovered_vs_death_ratio = recovered_vs_death_ratio;
    }

    public int getCases_per_million_population() {
        return cases_per_million_population;
    }

    public void setCases_per_million_population(int cases_per_million_population) {
        this.cases_per_million_population = cases_per_million_population;
    }
}

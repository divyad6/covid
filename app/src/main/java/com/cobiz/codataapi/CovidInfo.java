package com.cobiz.codataapi;

import androidx.annotation.NonNull;

public class CovidInfo implements Comparable<CovidInfo> {


    public int id;

    public String countryName;
    public int deathCount;
    public int recoverCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getRecoverCount() {
        return recoverCount;
    }

    public void setRecoverCount(int recoverCount) {
        this.recoverCount = recoverCount;
    }

    @Override
    public int compareTo(@NonNull CovidInfo o) {

        return this.countryName.compareTo(o.countryName);
    }
}

package com.cobiz.codata;

import java.util.Comparator;

public class PopulationCompare implements Comparator<Corona> {
    public int compare(Corona c1, Corona c2) {
        if (c1.getPopulation() < c2.getPopulation()) return 1;
        if (c1.getPopulation() > c2.getPopulation()) return -1;
        else return 0;
    }
}

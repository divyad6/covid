package com.cobiz.codata;

import java.util.List;

public class Countrydata {
    private Country data;
    private boolean _cacheHit;

    public void setData(Country data) {
        this.data = data;
    }

    public Country getData() {
        return data;
    }

    public void set_cacheHit(boolean _cacheHit) {
        this._cacheHit = _cacheHit;
    }

    public boolean is_cacheHit() {
        return _cacheHit;
    }
}

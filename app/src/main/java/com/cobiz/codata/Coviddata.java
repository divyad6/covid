package com.cobiz.codata;

public class Coviddata {
    private Corona[] data;
    private boolean _cacheHit;

    public void setData(Corona[] data) {
        this.data = data;
    }

    public Corona[] getData() {
        return data;
    }

    public void set_cacheHit(boolean _cacheHit) {
        this._cacheHit = _cacheHit;
    }

    public boolean is_cacheHit() {
        return _cacheHit;
    }
}

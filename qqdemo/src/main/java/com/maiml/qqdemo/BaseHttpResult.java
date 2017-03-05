package com.maiml.qqdemo;
/**
 * Created by maimingliang
 */
public class BaseHttpResult<T> {

    private int status;
    private String error;
    private  T results;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}

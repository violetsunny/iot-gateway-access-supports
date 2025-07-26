package com.ennewiot.gateway.industrialalarm.dto;

import java.util.Map;

public class DecodeMsg {


    private Map<String, Object> data;


    private Map<String, Object> response;

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }
}

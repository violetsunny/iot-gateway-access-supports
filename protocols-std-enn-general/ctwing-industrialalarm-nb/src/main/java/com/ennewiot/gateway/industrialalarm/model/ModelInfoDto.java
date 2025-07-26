package com.ennewiot.gateway.industrialalarm.model;


import java.util.List;
import java.util.Map;

public class ModelInfoDto {
    private Map<String, List<ModelPhyAttributeDto>> modelMap;
    private List<String> modelCodeList;

    public Map<String, List<ModelPhyAttributeDto>> getModelMap() {
        return modelMap;
    }

    public void setModelMap(Map<String, List<ModelPhyAttributeDto>> modelMap) {
        this.modelMap = modelMap;
    }

    public List<String> getModelCodeList() {
        return modelCodeList;
    }

    public void setModelCodeList(List<String> modelCodeList) {
        this.modelCodeList = modelCodeList;
    }
}

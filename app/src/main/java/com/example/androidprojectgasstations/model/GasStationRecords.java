package com.example.androidprojectgasstations.model;

import java.io.Serializable;

import com.example.androidprojectgasstations.model.GasStation;
import com.example.androidprojectgasstations.model.GasStationFields;
import com.example.androidprojectgasstations.model.GasStationGeometry;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GasStationRecords implements Serializable
{

    @SerializedName("datasetid")
    @Expose
    private String datasetid;
    @SerializedName("recordid")
    @Expose
    private String recordid;
    @SerializedName("fields")
    @Expose
    private GasStationFields fields;
    @SerializedName("geometry")
    @Expose
    private GasStationGeometry geometry;
    private final static long serialVersionUID = 4590719474920823014L;

    public String getDatasetid() {
        return datasetid;
    }

    public void setDatasetid(String datasetid) {
        this.datasetid = datasetid;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public GasStationFields getFields() {
        return fields;
    }

    public void setFields(GasStationFields fields) {
        this.fields = fields;
    }

    public GasStationGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(GasStationGeometry geometry) {
        this.geometry = geometry;
    }

}

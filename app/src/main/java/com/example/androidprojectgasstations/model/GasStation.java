
package com.example.androidprojectgasstations.model;
//import java.io.Serializable;
import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GasStation implements Serializable
{

    @SerializedName("records")
    @Expose
    private List<GasStationRecords> records;
    private final static long serialVersionUID = 6844201686630965852L;

    public List<GasStationRecords> getRecords() {
        return records;
    }

    public void setRecords(List<GasStationRecords> records) {
        this.records = records;
    }

}

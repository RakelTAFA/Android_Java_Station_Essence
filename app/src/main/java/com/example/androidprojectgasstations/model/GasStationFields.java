package com.example.androidprojectgasstations.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//import java.io.Serializable;
import java.util.List;


public class GasStationFields // implements Serializable
{

    @SerializedName("geom")
    @Expose
    private List<Float> geom;
    @SerializedName("reg_name")
    @Expose
    private String regName;
    @SerializedName("prix_valeur")
    @Expose
    private float prixValeur;
    @SerializedName("com_code")
    @Expose
    private String comCode;
    @SerializedName("dep_name")
    @Expose
    private String depName;
    @SerializedName("horaires")
    @Expose
    private String horaires;
    @SerializedName("adresse")
    @Expose
    private String adresse;
    @SerializedName("prix_nom")
    @Expose
    private String prixNom;
    @SerializedName("com_name")
    @Expose
    private String comName;
    @SerializedName("ville")
    @Expose
    private String ville;
    @SerializedName("com_arm_name")
    @Expose
    private String comArmName;
    @SerializedName("reg_code")
    @Expose
    private String regCode;
    @SerializedName("services_service")
    @Expose
    private String servicesService;
    @SerializedName("dep_code")
    @Expose
    private String depCode;
    @SerializedName("com_arm_code")
    @Expose
    private String comArmCode;
    @SerializedName("epci_code")
    @Expose
    private String epciCode;
    @SerializedName("cp")
    @Expose
    private String cp;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("prix_id")
    @Expose
    private String prixId;
    @SerializedName("epci_name")
    @Expose
    private String epciName;
    @SerializedName("pop")
    @Expose
    private String pop;
    @SerializedName("prix_maj")
    @Expose
    private String prixMaj;
    @SerializedName("horaires_automate_24_24")
    @Expose
    private String horairesAutomate2424;
    private final static long serialVersionUID = -2388927593355127875L;

    public List<Float> getGeom() {
        return geom;
    }

    public void setGeom(List<Float> geom) {
        this.geom = geom;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public float getPrixValeur() {
        return prixValeur;
    }

    public void setPrixValeur(float prixValeur) {
        this.prixValeur = prixValeur;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPrixNom() {
        return prixNom;
    }

    public void setPrixNom(String prixNom) {
        this.prixNom = prixNom;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getComArmName() {
        return comArmName;
    }

    public void setComArmName(String comArmName) {
        this.comArmName = comArmName;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public String getServicesService() {
        return servicesService;
    }

    public void setServicesService(String servicesService) {
        this.servicesService = servicesService;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getComArmCode() {
        return comArmCode;
    }

    public void setComArmCode(String comArmCode) {
        this.comArmCode = comArmCode;
    }

    public String getEpciCode() {
        return epciCode;
    }

    public void setEpciCode(String epciCode) {
        this.epciCode = epciCode;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrixId() {
        return prixId;
    }

    public void setPrixId(String prixId) {
        this.prixId = prixId;
    }

    public String getEpciName() {
        return epciName;
    }

    public void setEpciName(String epciName) {
        this.epciName = epciName;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPrixMaj() {
        return prixMaj;
    }

    public void setPrixMaj(String prixMaj) {
        this.prixMaj = prixMaj;
    }

    public String getHorairesAutomate2424() {
        return horairesAutomate2424;
    }

    public void setHorairesAutomate2424(String horairesAutomate2424) {
        this.horairesAutomate2424 = horairesAutomate2424;
    }

}

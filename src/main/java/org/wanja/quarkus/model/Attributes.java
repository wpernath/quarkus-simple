package org.wanja.quarkus.model;

import com.fasterxml.jackson.annotation.*;

public class Attributes {
    private long objectid;
    private double deathRate;
    private long cases;
    private long deaths;
    private double casesPer100K;
    private double casesPerPopulation;
    private Bl bl;
    private String blID;
    private String county;
    private String lastUpdate;
    private double cases7Per100K;
    private long ewzBl;
    private double cases7BlPer100K;
    private long cases7Bl;
    private long death7Bl;
    private long cases7Lk;
    private long death7Lk;
    private String cases7Per100KTxt;

    @JsonProperty("OBJECTID")
    public long getObjectid() { return objectid; }
    @JsonProperty("OBJECTID")
    public void setObjectid(long value) { this.objectid = value; }

    @JsonProperty("death_rate")
    public double getDeathRate() { return deathRate; }
    @JsonProperty("death_rate")
    public void setDeathRate(double value) { this.deathRate = value; }

    @JsonProperty("cases")
    public long getCases() { return cases; }
    @JsonProperty("cases")
    public void setCases(long value) { this.cases = value; }

    @JsonProperty("deaths")
    public long getDeaths() { return deaths; }
    @JsonProperty("deaths")
    public void setDeaths(long value) { this.deaths = value; }

    @JsonProperty("cases_per_100k")
    public double getCasesPer100K() { return casesPer100K; }
    @JsonProperty("cases_per_100k")
    public void setCasesPer100K(double value) { this.casesPer100K = value; }

    @JsonProperty("cases_per_population")
    public double getCasesPerPopulation() { return casesPerPopulation; }
    @JsonProperty("cases_per_population")
    public void setCasesPerPopulation(double value) { this.casesPerPopulation = value; }

    @JsonProperty("BL")
    public Bl getBl() { return bl; }
    @JsonProperty("BL")
    public void setBl(Bl value) { this.bl = value; }

    @JsonProperty("BL_ID")
    public String getBlID() { return blID; }
    @JsonProperty("BL_ID")
    public void setBlID(String value) { this.blID = value; }

    @JsonProperty("county")
    public String getCounty() { return county; }
    @JsonProperty("county")
    public void setCounty(String value) { this.county = value; }

    @JsonProperty("last_update")
    public String getLastUpdate() { return lastUpdate; }
    @JsonProperty("last_update")
    public void setLastUpdate(String value) { this.lastUpdate = value; }

    @JsonProperty("cases7_per_100k")
    public double getCases7Per100K() { return cases7Per100K; }
    @JsonProperty("cases7_per_100k")
    public void setCases7Per100K(double value) { this.cases7Per100K = value; }

    @JsonProperty("EWZ_BL")
    public long getEwzBl() { return ewzBl; }
    @JsonProperty("EWZ_BL")
    public void setEwzBl(long value) { this.ewzBl = value; }

    @JsonProperty("cases7_bl_per_100k")
    public double getCases7BlPer100K() { return cases7BlPer100K; }
    @JsonProperty("cases7_bl_per_100k")
    public void setCases7BlPer100K(double value) { this.cases7BlPer100K = value; }

    @JsonProperty("cases7_bl")
    public long getCases7Bl() { return cases7Bl; }
    @JsonProperty("cases7_bl")
    public void setCases7Bl(long value) { this.cases7Bl = value; }

    @JsonProperty("death7_bl")
    public long getDeath7Bl() { return death7Bl; }
    @JsonProperty("death7_bl")
    public void setDeath7Bl(long value) { this.death7Bl = value; }

    @JsonProperty("cases7_lk")
    public long getCases7Lk() { return cases7Lk; }
    @JsonProperty("cases7_lk")
    public void setCases7Lk(long value) { this.cases7Lk = value; }

    @JsonProperty("death7_lk")
    public long getDeath7Lk() { return death7Lk; }
    @JsonProperty("death7_lk")
    public void setDeath7Lk(long value) { this.death7Lk = value; }

    @JsonProperty("cases7_per_100k_txt")
    public String getCases7Per100KTxt() { return cases7Per100KTxt; }
    @JsonProperty("cases7_per_100k_txt")
    public void setCases7Per100KTxt(String value) { this.cases7Per100KTxt = value; }
}

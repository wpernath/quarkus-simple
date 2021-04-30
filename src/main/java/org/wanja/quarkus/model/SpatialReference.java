package org.wanja.quarkus.model;

import com.fasterxml.jackson.annotation.*;

public class SpatialReference {
    private long wkid;
    private long latestWkid;

    @JsonProperty("wkid")
    public long getWkid() { return wkid; }
    @JsonProperty("wkid")
    public void setWkid(long value) { this.wkid = value; }

    @JsonProperty("latestWkid")
    public long getLatestWkid() { return latestWkid; }
    @JsonProperty("latestWkid")
    public void setLatestWkid(long value) { this.latestWkid = value; }
}

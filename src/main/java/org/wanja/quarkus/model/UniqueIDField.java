package org.wanja.quarkus.model;

import com.fasterxml.jackson.annotation.*;

public class UniqueIDField {
    private String name;
    private boolean isSystemMaintained;

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("isSystemMaintained")
    public boolean getIsSystemMaintained() { return isSystemMaintained; }
    @JsonProperty("isSystemMaintained")
    public void setIsSystemMaintained(boolean value) { this.isSystemMaintained = value; }
}

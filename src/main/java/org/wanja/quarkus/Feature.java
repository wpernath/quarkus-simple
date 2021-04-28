package org.wanja.quarkus;

import com.fasterxml.jackson.annotation.*;

public class Feature {
    private Attributes attributes;

    @JsonProperty("attributes")
    public Attributes getAttributes() { return attributes; }
    @JsonProperty("attributes")
    public void setAttributes(Attributes value) { this.attributes = value; }
}

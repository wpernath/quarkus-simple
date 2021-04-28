package org.wanja.quarkus;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class RkiModel {
    private String objectIDFieldName;
    private UniqueIDField uniqueIDField;
    private String globalIDFieldName;
    private String geometryType;
    private SpatialReference spatialReference;
    private List<Field> fields;
    private List<Feature> features;

    @JsonProperty("objectIdFieldName")
    public String getObjectIDFieldName() { return objectIDFieldName; }
    @JsonProperty("objectIdFieldName")
    public void setObjectIDFieldName(String value) { this.objectIDFieldName = value; }

    @JsonProperty("uniqueIdField")
    public UniqueIDField getUniqueIDField() { return uniqueIDField; }
    @JsonProperty("uniqueIdField")
    public void setUniqueIDField(UniqueIDField value) { this.uniqueIDField = value; }

    @JsonProperty("globalIdFieldName")
    public String getGlobalIDFieldName() { return globalIDFieldName; }
    @JsonProperty("globalIdFieldName")
    public void setGlobalIDFieldName(String value) { this.globalIDFieldName = value; }

    @JsonProperty("geometryType")
    public String getGeometryType() { return geometryType; }
    @JsonProperty("geometryType")
    public void setGeometryType(String value) { this.geometryType = value; }

    @JsonProperty("spatialReference")
    public SpatialReference getSpatialReference() { return spatialReference; }
    @JsonProperty("spatialReference")
    public void setSpatialReference(SpatialReference value) { this.spatialReference = value; }

    @JsonProperty("fields")
    public List<Field> getFields() { return fields; }
    @JsonProperty("fields")
    public void setFields(List<Field> value) { this.fields = value; }

    @JsonProperty("features")
    public List<Feature> getFeatures() { return features; }
    @JsonProperty("features")
    public void setFeatures(List<Feature> value) { this.features = value; }
}

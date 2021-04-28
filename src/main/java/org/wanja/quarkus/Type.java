package org.wanja.quarkus;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Type {
    ESRI_FIELD_TYPE_DOUBLE, ESRI_FIELD_TYPE_INTEGER, ESRI_FIELD_TYPE_OID, ESRI_FIELD_TYPE_STRING;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ESRI_FIELD_TYPE_DOUBLE: return "esriFieldTypeDouble";
            case ESRI_FIELD_TYPE_INTEGER: return "esriFieldTypeInteger";
            case ESRI_FIELD_TYPE_OID: return "esriFieldTypeOID";
            case ESRI_FIELD_TYPE_STRING: return "esriFieldTypeString";
        }
        return null;
    }

    @JsonCreator
    public static Type forValue(String value) throws IOException {
        if (value.equals("esriFieldTypeDouble")) return ESRI_FIELD_TYPE_DOUBLE;
        if (value.equals("esriFieldTypeInteger")) return ESRI_FIELD_TYPE_INTEGER;
        if (value.equals("esriFieldTypeOID")) return ESRI_FIELD_TYPE_OID;
        if (value.equals("esriFieldTypeString")) return ESRI_FIELD_TYPE_STRING;
        throw new IOException("Cannot deserialize Type");
    }
}

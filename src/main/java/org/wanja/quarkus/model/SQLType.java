package org.wanja.quarkus.model;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum SQLType {
    SQL_TYPE_OTHER;

    @JsonValue
    public String toValue() {
        switch (this) {
            case SQL_TYPE_OTHER: return "sqlTypeOther";
        }
        return null;
    }

    @JsonCreator
    public static SQLType forValue(String value) throws IOException {
        if (value.equals("sqlTypeOther")) return SQL_TYPE_OTHER;
        throw new IOException("Cannot deserialize SQLType");
    }
}

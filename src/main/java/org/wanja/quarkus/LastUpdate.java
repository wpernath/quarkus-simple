package org.wanja.quarkus;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum LastUpdate {
    THE_250420210000_UHR;

    @JsonValue
    public String toValue() {
        switch (this) {
            case THE_250420210000_UHR: return "25.04.2021, 00:00 Uhr";
        }
        return null;
    }

    @JsonCreator
    public static LastUpdate forValue(String value) throws IOException {
        if (value.equals("25.04.2021, 00:00 Uhr")) return THE_250420210000_UHR;
        throw new IOException("Cannot deserialize LastUpdate");
    }
}

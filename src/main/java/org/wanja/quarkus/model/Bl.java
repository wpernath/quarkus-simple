package org.wanja.quarkus.model;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Bl {
    BADEN_WRTTEMBERG, BAYERN, BERLIN, BRANDENBURG, BREMEN, HAMBURG, HESSEN, MECKLENBURG_VORPOMMERN, NIEDERSACHSEN, NORDRHEIN_WESTFALEN, RHEINLAND_PFALZ, SAARLAND, SACHSEN, SACHSEN_ANHALT, SCHLESWIG_HOLSTEIN, THRINGEN;

    @JsonValue
    public String toValue() {
        switch (this) {
            case BADEN_WRTTEMBERG: return "Baden-Württemberg";
            case BAYERN: return "Bayern";
            case BERLIN: return "Berlin";
            case BRANDENBURG: return "Brandenburg";
            case BREMEN: return "Bremen";
            case HAMBURG: return "Hamburg";
            case HESSEN: return "Hessen";
            case MECKLENBURG_VORPOMMERN: return "Mecklenburg-Vorpommern";
            case NIEDERSACHSEN: return "Niedersachsen";
            case NORDRHEIN_WESTFALEN: return "Nordrhein-Westfalen";
            case RHEINLAND_PFALZ: return "Rheinland-Pfalz";
            case SAARLAND: return "Saarland";
            case SACHSEN: return "Sachsen";
            case SACHSEN_ANHALT: return "Sachsen-Anhalt";
            case SCHLESWIG_HOLSTEIN: return "Schleswig-Holstein";
            case THRINGEN: return "Thüringen";
        }
        return null;
    }

    @JsonCreator
    public static Bl forValue(String value) throws IOException {
        if (value.equals("Baden-Württemberg")) return BADEN_WRTTEMBERG;
        if (value.equals("Bayern")) return BAYERN;
        if (value.equals("Berlin")) return BERLIN;
        if (value.equals("Brandenburg")) return BRANDENBURG;
        if (value.equals("Bremen")) return BREMEN;
        if (value.equals("Hamburg")) return HAMBURG;
        if (value.equals("Hessen")) return HESSEN;
        if (value.equals("Mecklenburg-Vorpommern")) return MECKLENBURG_VORPOMMERN;
        if (value.equals("Niedersachsen")) return NIEDERSACHSEN;
        if (value.equals("Nordrhein-Westfalen")) return NORDRHEIN_WESTFALEN;
        if (value.equals("Rheinland-Pfalz")) return RHEINLAND_PFALZ;
        if (value.equals("Saarland")) return SAARLAND;
        if (value.equals("Sachsen")) return SACHSEN;
        if (value.equals("Sachsen-Anhalt")) return SACHSEN_ANHALT;
        if (value.equals("Schleswig-Holstein")) return SCHLESWIG_HOLSTEIN;
        if (value.equals("Thüringen")) return THRINGEN;
        throw new IOException("Cannot deserialize Bl");
    }
}

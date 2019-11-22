package data;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class Aftale {
    private Type Type;
    private Sygehus Sygehus;
    private String Dato;
    private String Fritekst;

    public data.Type getType() {
        return Type;
    }

    public void setType(data.Type type) {
        Type = type;
    }

    public data.Sygehus getSygehus() {
        return Sygehus;
    }

    public void setSygehus(data.Sygehus sygehus) {
        Sygehus = sygehus;
    }

    public String getDato() {
        return Dato;
    }

    public void setDato(String dato) {
        Dato = dato;
    }

    public String getFritekst() {
        return Fritekst;
    }

    public void setFritekst(String fritekst) {
        this.Fritekst = fritekst;
    }
}

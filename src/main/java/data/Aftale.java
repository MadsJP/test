package data;

public class Aftale {
    private String Patient;
    private String Type;
    private String Sygehus;

    public String getPatient() {
        return Patient;
    }

    public void setPatient(String patient) {
        this.Patient = patient;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSygehus() {
        return Sygehus;
    }

    public void setSygehus(String sygehus) {
        Sygehus = sygehus;
    }
}

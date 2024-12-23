package de.java.muster.anwendung.vo;

public class KundeVo {
    private String name;
    private String vorname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String toString() {
        return "KundeVo{" +
                "name='" + name + '\'' +
                ", vorname='" + vorname + '\'' +
                '}';
    }

    public String toCsvString() {
        return name + "," + vorname;
    }
}

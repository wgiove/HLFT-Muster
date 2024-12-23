package de.java.muster.anwendung.daten;

import de.java.muster.CsvManager;
import de.java.muster.anwendung.vo.KundeVo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DatenSingleton {

    //private List<KundeVo> meineDaten;
    private CsvManagerAnwendung csvManager;
    private String path;

    private static DatenSingleton singleton;

    private DatenSingleton() {
        // meineDaten = new ArrayList<KundeVo>();
        path = "C:\\Users\\wgiov\\IdeaProjects\\HLFT-Muster\\src\\DatenQuelle\\csvDatei.csv";
        csvManager = new CsvManagerAnwendung(path);
        try {
            csvManager.createFile();
        } catch (IOException e) {
            System.err.println("Fehler beim erstellen der Datei");
        }

    }
    public static DatenSingleton getInstance() {
        if (singleton ==null) {
            singleton = new DatenSingleton();
        }
        return singleton;
    }

    public List<KundeVo> getMeineDaten() {
        try {
            return csvManager.readAllLines();
        } catch (IOException e) {
            System.err.println("Fehler beim Laden der Daten");
        }
        return new ArrayList<KundeVo>();
    }

    public void addKunde(KundeVo kunde) {
        //meineDaten.add(kunde);
        try {
            csvManager.appendLine(kunde);
        } catch (IOException e) {
            System.err.println("Fehler beim schreiben der Daten");
        }
    }

}

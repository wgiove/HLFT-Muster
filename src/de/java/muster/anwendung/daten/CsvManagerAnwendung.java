package de.java.muster.anwendung.daten;

import de.java.muster.anwendung.vo.KundeVo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvManagerAnwendung {
    private String filePath;

    public CsvManagerAnwendung(String filePath) {
        this.filePath = filePath;
    }

    // Methode, um die CSV-Datei zu erstellen (falls sie nicht existiert)
    public void createFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("CSV-Datei wurde erstellt: " + filePath);
        } else {
            System.out.println("CSV-Datei existiert bereits: " + filePath);
        }
    }

    // Methode, um alle Zeilen aus der CSV-Datei zu lesen
    public List<KundeVo> readAllLines() throws IOException {
        List<KundeVo> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                KundeVo kunde = new KundeVo();
                kunde.setVorname(columns[0]);
                kunde.setName(columns[1]);
                rows.add(kunde);
            }
        }
        return rows;
    }

    // Methode, um eine neue Zeile am Ende der CSV-Datei hinzuzufügen
    public void appendLine(KundeVo kundeVo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(kundeVo.toCsvString());
            sb.append(System.lineSeparator());
            writer.write(sb.toString());
        }
    }


}

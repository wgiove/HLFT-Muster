package de.java.muster;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvManager {
    private String filePath;

    public CsvManager(String filePath) {
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
    public List<String[]> readAllLines() throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                rows.add(columns);
            }
        }
        return rows;
    }

    // Methode, um eine neue Zeile am Ende der CSV-Datei hinzuzufügen
    public void appendLine(String[] newRow) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < newRow.length; i++) {
                sb.append(newRow[i]);
                if (i < newRow.length - 1) {
                    sb.append(",");
                }
            }
            sb.append(System.lineSeparator());
            writer.write(sb.toString());
        }
    }

    public static void main(String[] args) {
        try {
            // Pfad zur CSV-Datei angeben
            String filePath = "test.csv";
            CsvManager csvManager = new CsvManager(filePath);

            // CSV-Datei erstellen
            csvManager.createFile();

            // Neue Zeile hinzufügen
            String[] newRow = {"Name", "Alter", "Stadt"};
            csvManager.appendLine(newRow);

            // Alle Zeilen aus der CSV-Datei lesen
            List<String[]> rows = csvManager.readAllLines();
            for (String[] row : rows) {
                for (String column : row) {
                    System.out.print(column + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * questa classe gestusce la crezione di un file con contenente al suo interno la classifica degli atleti
 */


import java.io.*;

public class GestioneFile {

    private String fileName;

    public GestioneFile(String fileName) {
        this.fileName = fileName;
    }

    // Salva la classifica del giudice nel file
    public synchronized void salvaPodio(Giudice giudice) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Classifica della gara:\n");
            writer.write(giudice.getClassifica());
            System.out.println("Classifica salvata nel file '" + fileName + "'.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio della classifica: " + e.getMessage());
        }
    }

    // Legge e stampa la classifica salvata nel file
    public synchronized void leggiPodio() {
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("Nessuna classifica precedente trovata.");
            return;
        }

        System.out.println("\nUltima classifica salvata:");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Fine classifica.\n");
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }
    }
}

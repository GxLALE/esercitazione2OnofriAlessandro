/**
 * questa classe controlla l'arrivo degli atleti, la loro posizione e li mette nella classifica in base alla loro posizione finale
 */

public class Giudice implements Runnable {
    String classifica = "";
    int posizione = 0;
    final double LUNGHEZZAGARA = 50.0;

    public synchronized void traguardo(Atleta atleta) {
        posizione++;
        System.out.println("È arrivato: " + atleta.nome);
        classifica += posizione + " " + atleta.nome + " ";
    }

    // --- NUOVO METODO ---
    public synchronized void ritiro(Atleta atleta) {
        posizione++;
        System.out.println("Si è ritirato: " + atleta.nome);
        classifica += posizione + " " + atleta.nome + " (RITIRATO) ";
    }

    public void podio() {
        System.out.println("Il podio è: " + classifica);
    }

    public String getClassifica() {
        return classifica;
    }

    @Override
    public void run() {

    }
}

/**
 * questa classe gestisce gli atleti dandogli la distanza che percorrono ogni secondo 
 */

import java.util.Random;

public class Atleta implements Runnable {
    int numero;
    String nome;
    double tempo = 0.0;
    double metri = 0.0;
    Giudice giudice;
    Random random = new Random();

    public Atleta(int pNumero, String pNome, Giudice giudice) {
        this.numero = pNumero;
        this.nome = pNome;
        this.giudice = giudice;
    }

    public void run() {
        Random metriPercorsi = new Random();
        double minIncrement = 1.0; 
        double maxIncrement = 4.0; 

        while (this.metri <= giudice.LUNGHEZZAGARA) {

            // --- NUOVO: possibilità di ritiro casuale ---
            if (random.nextDouble() < 0.01) { // 1% probabilità di ritiro
                System.out.println(this.nome + " si è RITIRATO!");
                giudice.ritiro(this);
                return; // termina il thread
            }

            this.metri += minIncrement + (maxIncrement - minIncrement) * metriPercorsi.nextDouble();
            System.out.println(this.nome + " Metri Percorsi: " + this.metri);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var3) {
                System.err.println("Errore sleep");
            }
        }

        System.out.println(this.nome + " è al Traguardo");
        giudice.traguardo(this);
    }
}

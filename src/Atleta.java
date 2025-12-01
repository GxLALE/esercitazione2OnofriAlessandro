/**
 * questa classe gestisce gli atleti dandogli la distanza che percorrono ogni secondo 
 */


import java.util.Random;


public class Atleta implements Runnable {
    int numero;
    String nome;
    double tempo = (double) 0.0F;
    double metri = (double) 0.0F;
    Giudice giudice;

    


    public Atleta(int pNumero, String pNome, Giudice giudice) {
        this.numero = pNumero;
        this.nome = pNome;
        this.giudice = giudice;
    }


    public void run() {
        Random metriPercorsi = new Random();
        double minIncrement = 1.0; // minimo incremento per ciclo (metri)
        double maxIncrement = 4.0; // massimo incremento per ciclo (metri)


        while (this.metri <= (double) giudice.LUNGHEZZAGARA) {
            this.metri += minIncrement + (maxIncrement - minIncrement) * metriPercorsi.nextDouble();
            System.out.println(this.nome + " Metri Percorsi: " + this.metri);


            try {
                Thread.currentThread();
                Thread.sleep(1000L);
            } catch (InterruptedException var3) {
                System.err.println("Errore sleep");
            }
        }


        System.out.println(this.nome + " è al Traguardo");
        giudice.traguardo(this);
    }
}


/**
 * questa classe controlla l'arrivo degli atleti, la loro posizione e li mette nella classifica in base alla loro posizione finale
 */


public class Giudice implements Runnable {
String classifica="";
int posizione = 0;
final double LUNGHEZZAGARA = (double) 50.0F;



    public synchronized void traguardo(Atleta atleta) {
        System.out.println("è arrivato: " + atleta.nome);
        posizione ++;
        classifica += posizione + " " + atleta.nome + " " ;

    }
    

    public void podio(){
        System.out.println("il podio è " + classifica);
    }

    public String getClassifica() {
        return classifica;
    }

    @Override
    public void run() {

    }
}


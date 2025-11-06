public class Giudice implements Runnable {
String classificata="";
int posizione = 0;


    public synchronized void traguardo(Atleta atleta) {
        System.out.println("è arrivato: " + atleta.nome);
        posizione ++;
        classificata += posizione + " " + atleta.nome + " " ;
    }

    public void podio() {
        System.out.println("il podio è " + classificata);
    }


    @Override
    public void run() {

    }
}

public class Giudice implements Runnable {

    public synchronized void fineGara(Atleta atleta) {
        System.out.println("è arrivato: " + atleta.nome);
    }

    @Override
    public void run() {

    }
}

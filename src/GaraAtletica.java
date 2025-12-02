/**
 * questa ckasse contiene il metodo main per far avviare la gara 
 * 
 */

 
public class GaraAtletica {
    public static void main(String[] args) {
        System.out.println("Gara Atletica");
        Giudice giudice = new Giudice();
        GestioneFile gestore = new GestioneFile("podio.txt");

        Atleta a1 = new Atleta(67, "pongre", giudice);
        Atleta a2 = new Atleta(68, "iodo", giudice);

        Thread ta1 = new Thread(a1);
        Thread ta2 = new Thread(a2);

        for(int i = 3; i > 0; --i) {
            System.out.println("Inizio in:" + i);
        }

        ta1.start();
        ta2.start();

        try {
            ta1.join();
            ta2.join();

        } catch (InterruptedException var6) {
            System.err.println("Errore join");
        }

        giudice.podio();
        gestore.salvaPodio(giudice);
        gestore.leggiPodio();
    }
}

package modele;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MorpionInterface extends Remote {
    //Toutes les fonctions implémentées dans ImpMorpion
    void nouvellePartie() throws RemoteException;
    boolean VerifGagnant() throws RemoteException;
    Caractere[][] getPlateau()throws RemoteException;
    Caractere PlacerCaract(int x, int y) throws RemoteException;
    String msgGagnant() throws RemoteException;

}

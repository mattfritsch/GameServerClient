package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PenduInterface extends Remote {
    //appel de la génération du mot
    public String genererMotPendu() throws RemoteException;
}

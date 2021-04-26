package modele;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AllumetteInterface extends Remote {
    //fonction implémenté dans impAllumette
    public int nombreAleatoireAllumette() throws RemoteException;

    public int retirerAllumetteOrdi(int nbretirerordi) throws RemoteException;

    public int retirerAllumetteJoueur(int nbretirerjoueur) throws RemoteException;

    //public boolean jeuAllumette(boolean win, int nbretirerordi, int nballumette) throws RemoteException;

    public int getNbAllumetteJoueur() throws RemoteException;

    public int getNbAllumetteOrdi() throws RemoteException;

    public int getNbAllumetteTotal() throws RemoteException;

    public int getNbAllumetteOrdiRetire() throws RemoteException;

    public int setNbAllumetteJoueur() throws RemoteException;

    public int setNbAllumetteOrdi() throws RemoteException;
}

package modele;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class ImpAllumette extends UnicastRemoteObject implements AllumetteInterface {
    private Allumette a=new Allumette();
    public ImpAllumette() throws RemoteException{
        super();
    }
    //fonction permettant de récupérer un nombre aléatoire d'allumette
    public int nombreAleatoireAllumette() throws RemoteException{
        return a.randomAllumetteTotal();
    }

    //fonction permettant de mettre le nombre d'allumette du joueur à 0
    public int setNbAllumetteJoueur() throws RemoteException{
        a.setAllumettejoueur(0);
        return 0;
    }
    //fonction permettant de mettre le nombre d'allumette de l'ordinateur à 0
    public int setNbAllumetteOrdi() throws RemoteException{
        a.setAllumetteordi(0);
        return 0;
    }

    //fonction permettant de récupérer le nombre d'allumette dans la main du joueur
    public int getNbAllumetteJoueur() throws RemoteException{
        return a.getAllumettejoueur();
    }

    //fonction permettant de récupérer le nombre d'allumette dans la main du joueur
    public int getNbAllumetteOrdi() throws RemoteException{
        return a.getAllumetteordi();
    }
    //fonction permettant de récupérer le nombre total d'allumette restante
    public int getNbAllumetteTotal() throws RemoteException{
        return a.getAllumettetotal();
    }
    //fonction permettant de récupérer le nombre d'allumette retirer par l'ordinateur
    public int getNbAllumetteOrdiRetire() throws RemoteException{
        return a.getAllumetteordiretire();
    }
    //fonction permettant de récupérer le nombre d'allumette retirer par le joueur
    public int retirerAllumetteJoueur(int nbretirerjoueur) throws RemoteException{
        //si le nombre d'allumette retirer est égale à 1 alors
        if (nbretirerjoueur == 1){
            //on ajoute une allumette dans la main du joueur
            a.ajouterAllumetteJoueur(nbretirerjoueur);
            //on retire une allumette du nombre total d'allumette
            a.retirerAllumetteTotal(nbretirerjoueur);
        }
        //sinon si le nombre d'allumette retirer est égale à 2 alors
        else if (nbretirerjoueur == 2){
            //on ajoute deux allumettes dans la main du joueur
            a.ajouterAllumetteJoueur(nbretirerjoueur);
            //on retire deux allumettes du nombre total d'allumette
            a.retirerAllumetteTotal(nbretirerjoueur);
        }
        return nbretirerjoueur;
    }

    public int retirerAllumetteOrdi(int nbretirerordi) throws RemoteException{
        //on choisit le nombre d'allumette retirer aléatoirement entre 1 et 2
        nbretirerordi = new Random().nextInt(2) + 1;
        //si le nombre d'allumette retirer est égale à 1 alors
        if (nbretirerordi == 1){
            //on ajoute une allumette dans la main de l'ordinateur
            a.ajouterAllumetteOrdi(nbretirerordi);
            //on retire une allumette du nombre total d'allumette
            a.retirerAllumetteTotal(nbretirerordi);
            //on met le nombre d'allumette retirer par l'ordinateur à 0
            a.setAllumetteordiretire(nbretirerordi);
        }
        //sinon
        else{
            //on ajoute deux allumettes dans la main de l'ordinateur
            a.ajouterAllumetteOrdi((nbretirerordi));
            //on retire deux allumettes du nombre total d'allumette
            a.retirerAllumetteTotal(nbretirerordi);
            //on met le nombre d'allumette retirer par l'ordinateur à 0
            a.setAllumetteordiretire(nbretirerordi);
        }
        return nbretirerordi;
    }
}
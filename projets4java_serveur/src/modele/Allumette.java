package modele;

import java.io.Serializable;
import java.util.Random;

public class Allumette implements Serializable {
    public int allumettejoueur;
    public int allumetteordi;
    public int allumettetotal;
    public int allumetteordiretire;

    public int randomAllumetteTotal() {
        //choisit un nombre aléatoirement entre 10 et 31
        allumettetotal = new Random().nextInt(21) + 10;
        //si le nombre obtenu est paire alors
        if (allumettetotal % 2 == 0) {
            //on ajoute un pour qu'il soit impair
            allumettetotal = allumettetotal + 1;
        }
        //sinon
        else {
            //on renvoie le nombre impaire
            return allumettetotal;
        }
        return allumettetotal;
    }

    //ajoute en fonction de nb une ou deux allumettes au joueur
    public void ajouterAllumetteJoueur(int nb){
        this.allumettejoueur += nb;
    }
    //même principe
    public void ajouterAllumetteOrdi(int nb){ this.allumetteordi += nb; }
    //on retire en fonction de nb une ou deux allumettes à l'ordinateur
    public void retirerAllumetteTotal(int nb){
        this.allumettetotal -= nb;
    }

    public int getAllumettejoueur() {
        return allumettejoueur;
    }

    public void setAllumettejoueur(int allumettejoueur) {
        this.allumettejoueur = allumettejoueur;
    }

    public int getAllumetteordi() {
        return allumetteordi;
    }

    public void setAllumetteordi(int allumetteordi) {
        this.allumetteordi = allumetteordi;
    }

    public int getAllumettetotal() {
        return allumettetotal;
    }

    public void setAllumettetotal(int allumettetotal) {
        this.allumettetotal = allumettetotal;
    }
    public int getAllumetteordiretire() {
        return allumetteordiretire;
    }

    public void setAllumetteordiretire(int allumetteordiretire) {
        this.allumetteordiretire = allumetteordiretire;
    }
}


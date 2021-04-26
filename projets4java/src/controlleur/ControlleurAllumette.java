package controlleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modele.AllumetteInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ControlleurAllumette {
    //Déclaration des variables utilisé dans allumettes.fxml
    @FXML ImageView imgAllumette1, imgAllumette2;
    @FXML Button uneAllumette, deuxAllumettes;
    @FXML Label lblJoueur, lblNbAllumetteRetireJoueur, lblNbAllumetteJoueur, lblOrdinateur, lblNbRetireOrdinateur,
            lblNbAllumetteOrdinateur, lblNombreTotalAllumette, lblDescriptionAllumette, lblGagnant;
    @FXML Button btnJouer, btnRetour;


//Action réaliser au clique du bouton "Jouer"
    public void onStart() throws RemoteException, NotBoundException, MalformedURLException, InterruptedException {

        AllumetteInterface obj = (AllumetteInterface) Naming.lookup("rmi://localhost:8000/allumette");


        //on vide les labels pour rejouer
        lblNbAllumetteRetireJoueur.setText("");
        lblNbRetireOrdinateur.setText("");
        lblNbAllumetteOrdinateur.setText("");
        lblGagnant.setText("");

        //On remplace le texte du label par le nombre total d'allumettes et on l'affiche
        lblNombreTotalAllumette.setText("Il y a un total de " +obj.nombreAleatoireAllumette()+ " d'allumettes sur la table.");
        lblNombreTotalAllumette.setVisible(true);
        lblJoueur.setVisible(true);
        imgAllumette1.setVisible(true);
        imgAllumette2.setVisible(true);
        uneAllumette.setVisible(true);
        deuxAllumettes.setVisible(true);

    }
//Action réaliser au clique du bouton "Enlever une allumette"
    public void onClickUneAllumette(ActionEvent actionEvent) throws RemoteException, NotBoundException, MalformedURLException {
        AllumetteInterface obj = (AllumetteInterface) Naming.lookup("rmi://localhost:8000/allumette");

        if(obj.getNbAllumetteTotal() > 0 ) {
            //on retire une allumette du nombre total
            obj.retirerAllumetteJoueur(1);
            lblNbAllumetteRetireJoueur.setText("Vous avez retiré une allumette.");
            lblNbAllumetteRetireJoueur.setVisible(true);
            //on affiche le nombre d'allumette du joueur
            lblNbAllumetteJoueur.setText("Vous avez " + obj.getNbAllumetteJoueur() + " allumettes dans votre main.");
            lblNbAllumetteJoueur.setVisible(true);
            //on affiche le nombre total d'allumette restant
            lblNombreTotalAllumette.setText("Il y a " + obj.getNbAllumetteTotal() + " d'allumettes sur la table.");
            lblNombreTotalAllumette.setVisible(true);
            //si le nombre total d'allumette est inférieur ou égale a 0 alors
            if (obj.getNbAllumetteTotal() <= 0) {
                //on vérifie si le nombre d'allumette qu'on possède est impair
                if (obj.getNbAllumetteJoueur() % 2 == 1) {
                    lblGagnant.setText("Bravo vous avez gagné :)");
                    lblGagnant.setVisible(true);
                    //on remet le nombre d'allumette du joueur et de l'ordinateur à 0
                    obj.setNbAllumetteJoueur();
                    obj.setNbAllumetteOrdi();
                    btnJouer.setText("Rejouer !");
                    cacher();
                }
                //on vérifie le nombre d'allumette que possède l'ordinateur
                if (obj.getNbAllumetteOrdi() % 2 == 1) {
                    lblGagnant.setText("Désolé vous avez perdu :(");
                    lblGagnant.setVisible(true);
                    obj.setNbAllumetteJoueur();
                    obj.setNbAllumetteOrdi();
                    btnJouer.setText("Rejouer !");
                    cacher();
                }
            }
        }
        if(obj.getNbAllumetteTotal() > 0) {
            //on fait la même chose pour l'ordinateur
            //on affiche le label de l'ordinateur
            lblOrdinateur.setText("Au tour de l'ordinateur !");
            lblOrdinateur.setVisible(true);
            obj.retirerAllumetteOrdi(0);
            //on affiche combien d'allumette a retirer l'ordinateur
            lblNbRetireOrdinateur.setText("L'ordinateur à retiré " + obj.getNbAllumetteOrdiRetire() + " allumettes");
            lblNbRetireOrdinateur.setVisible(true);
            //on affiche la main de l'ordinateur
            lblNbAllumetteOrdinateur.setText("L'ordinateur possède " + obj.getNbAllumetteOrdi() + " allumettes");
            lblNbAllumetteOrdinateur.setVisible(true);
            //on affiche le nombre d'allumette total d'allumette restante
            lblNombreTotalAllumette.setText("Il y a " + obj.getNbAllumetteTotal() + " d'allumettes sur la table.");

            if (obj.getNbAllumetteTotal() <= 0) {
                if (obj.getNbAllumetteJoueur() % 2 == 1) {
                    lblGagnant.setText("Bravo vous avez gagné :)");
                    lblGagnant.setVisible(true);
                    obj.setNbAllumetteJoueur();
                    obj.setNbAllumetteOrdi();
                    btnJouer.setText("Rejouer !");
                    cacher();
                }
                if (obj.getNbAllumetteOrdi() % 2 == 1) {
                    lblGagnant.setText("Désolé vous avez perdu :(");
                    lblGagnant.setVisible(true);
                    obj.setNbAllumetteJoueur();
                    obj.setNbAllumetteOrdi();
                    btnJouer.setText("Rejouer !");
                    cacher();
                }
            }
        }
    }
//Action réalisé au clique du bouton "Enlever deux allumettes, même action que le bouton "Enlever une allumette" sauf
// que ça enléve deux allumettes au nombres total d'allumette
    public void onClickDeuxAllumettes(ActionEvent actionEvent) throws RemoteException, NotBoundException, MalformedURLException {
        AllumetteInterface obj = (AllumetteInterface) Naming.lookup("rmi://localhost:8000/allumette");
        if (obj.getNbAllumetteTotal() > 0) {
            //on retire deux allumettes du nombre total
            obj.retirerAllumetteJoueur(2);
            lblNbAllumetteRetireJoueur.setText("Vous avez retiré deux allumette.");
            lblNbAllumetteRetireJoueur.setVisible(true);
            //on affiche le nombre d'allumette du joueur
            lblNbAllumetteJoueur.setText("Vous avez " + obj.getNbAllumetteJoueur() + " allumettes dans votre main.");
            lblNbAllumetteJoueur.setVisible(true);
            //on affiche le nombre total d'allumette restant
            lblNombreTotalAllumette.setText("Il y a " + obj.getNbAllumetteTotal() + " d'allumettes sur la table.");
            lblNombreTotalAllumette.setVisible(true);
            //on fait la même chose pour l'ordinateur
            //on affiche le label de l'ordinateur
            if (obj.getNbAllumetteTotal() <= 0) {
                if (obj.getNbAllumetteJoueur() % 2 == 1) {
                    lblGagnant.setText("Bravo vous avez gagné :)");
                    lblGagnant.setVisible(true);
                    obj.setNbAllumetteJoueur();
                    obj.setNbAllumetteOrdi();
                    btnJouer.setText("Rejouer !");
                    cacher();
                }
                if (obj.getNbAllumetteOrdi() % 2 == 1) {
                    lblGagnant.setText("Désolé vous avez perdu :(");
                    lblGagnant.setVisible(true);
                    obj.setNbAllumetteJoueur();
                    obj.setNbAllumetteOrdi();
                    btnJouer.setText("Rejouer !");
                    cacher();
                }
            }
        }
        if(obj.getNbAllumetteTotal() > 0 ) {
            lblOrdinateur.setText("Au tour de l'ordinateur !");
            lblOrdinateur.setVisible(true);
            obj.retirerAllumetteOrdi(0);
            //on affiche combien d'allumette a retirer l'ordinateur
            lblNbRetireOrdinateur.setText("L'ordinateur à retiré " + obj.getNbAllumetteOrdiRetire() + " allumettes");
            lblNbRetireOrdinateur.setVisible(true);
            //on affiche la main de l'ordinateur
            lblNbAllumetteOrdinateur.setText("L'ordinateur possède " + obj.getNbAllumetteOrdi() + " allumettes");
            lblNbAllumetteOrdinateur.setVisible(true);
            //on affiche le nombre d'allumette total d'allumette restante
            lblNombreTotalAllumette.setText("Il y a " + obj.getNbAllumetteTotal() + " d'allumettes sur la table.");
            if (obj.getNbAllumetteTotal() <= 0) {
                if (obj.getNbAllumetteJoueur() % 2 == 1) {
                    lblGagnant.setText("Bravo vous avez gagné :)");
                    lblGagnant.setVisible(true);
                    obj.setNbAllumetteJoueur();
                    obj.setNbAllumetteOrdi();
                    btnJouer.setText("Rejouer !");
                    cacher();
                }
                if (obj.getNbAllumetteOrdi() % 2 == 1) {
                    lblGagnant.setText("Désolé vous avez perdu :(");
                    lblGagnant.setVisible(true);
                    obj.setNbAllumetteJoueur();
                    obj.setNbAllumetteOrdi();
                    btnJouer.setText("Rejouer !");
                    cacher();
                }
            }
        }
    }
//Fonction permettant de cacher certains éléments présents sur la fenêtre
    public void cacher(){
        lblNbRetireOrdinateur.setVisible(false);
        lblNbAllumetteOrdinateur.setVisible(false);
        lblOrdinateur.setVisible(false);
        lblNombreTotalAllumette.setVisible(false);
        lblJoueur.setVisible(false);
        lblNbAllumetteJoueur.setVisible(false);
        lblNbAllumetteRetireJoueur.setVisible(false);
        imgAllumette1.setVisible(false);
        imgAllumette2.setVisible(false);
        uneAllumette.setVisible(false);
        deuxAllumettes.setVisible(false);

    }
//Fonction permettant de quitter le jeu
    public void onClickRetour(){
        btnJouer.setText("Jouer");
        Stage stage = (Stage) btnRetour.getScene().getWindow();
        stage.close();
    }
}



package controlleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import modele.PenduInterface;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;


public class ControlleurPendu implements Initializable {

    //déclaration des éléments
    @FXML Button lancer, quitter, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    @FXML Line b1, b2, b3, b4, b5, b8, b9, b10, b11;
    @FXML Circle b6;
    @FXML Ellipse b7;
    @FXML Label victoire, defaite, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    @FXML ImageView img1;

    public boolean gagne = false;
    String mot;
    public int pasbon;

    // fonction qui permet de réinitialiser tout a 0 lorsque l'on veut rejouer une partie
    private void reset(Line b1, Line b2, Line b3, Line b4, Line b5, Line b8, Line b9, Line b10, Line b11, Circle b6,
                       Ellipse b7 , Label l1, Label l2, Label l3, Label l4, Label l5, Label l6, Label l7,
                       Label l8, Label l9, Label l10, Button A, Button B, Button C, Button D, Button E, Button F, Button G,
                       Button H, Button I, Button J, Button K, Button L, Button M, Button N, Button O, Button P, Button Q,
                       Button R, Button S, Button T, Button U, Button V, Button W, Button X, Button Y, Button Z){
        defaite.setVisible(false);
        victoire.setVisible(false);
        lancer.setVisible(true);
        quitter.setVisible(true);

        //dessin ok
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
        b6.setVisible(false);
        b7.setVisible(false);
        b8.setVisible(false);
        b9.setVisible(false);
        b10.setVisible(false);
        b11.setVisible(false);
        //bouton ok
        A.setDisable(false);
        B.setDisable(false);
        C.setDisable(false);
        D.setDisable(false);
        E.setDisable(false);
        F.setDisable(false);
        G.setDisable(false);
        H.setDisable(false);
        I.setDisable(false);
        J.setDisable(false);
        K.setDisable(false);
        L.setDisable(false);
        M.setDisable(false);
        N.setDisable(false);
        O.setDisable(false);
        P.setDisable(false);
        Q.setDisable(false);
        R.setDisable(false);
        S.setDisable(false);
        T.setDisable(false);
        U.setDisable(false);
        V.setDisable(false);
        W.setDisable(false);
        X.setDisable(false);
        Y.setDisable(false);
        Z.setDisable(false);

        //mot ok
        l1.setText("");
        l2.setText("");
        l3.setText("");
        l4.setText("");
        l5.setText("");
        l6.setText("");
        l7.setText("");
        l8.setText("");
        l9.setText("");
        l10.setText("");
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(true);
        l5.setVisible(true);
        l6.setVisible(true);
        l7.setVisible(true);
        l8.setVisible(true);
        l9.setVisible(true);
        l10.setVisible(true);

    }

    //fonction qui lors de l'appui sur le bouton jouer lance l'initialisation ainsi que la réinitialisation afin d'être sur que tout soit a 0
    public void init() throws RemoteException, MalformedURLException, NotBoundException {

        PenduInterface obj = (PenduInterface) Naming.lookup("rmi://localhost:8000/pendu");
        reset(b1, b2, b3, b4, b5, b8, b9, b10, b11,b6 ,b7 ,l1 ,l2 ,l3 ,l4 ,l5 ,l6 ,l7 ,l8 ,l9 ,l10 ,A ,B ,C ,D ,E ,F ,G ,
                H,I ,J ,K ,L ,M ,N ,O ,P ,Q ,R ,S ,T ,U ,V ,W ,X ,Y ,Z);
        pasbon = 0;
        lancer.setVisible(false);
        quitter.setVisible(false);
        mot = obj.genererMotPendu();

        //affichage du mot dans la console
        System.out.println("Le mot choisi par l'ordinateur est : " + mot);

        //génération du mot caché par des étoiles
        int longueur = mot.length();
        if (longueur >= 1)
            l1.setText("*");
        if (longueur >= 2)
            l2.setText("*");
        if (longueur >= 3)
            l3.setText("*");
        if (longueur >= 4)
            l4.setText("*");
        if (longueur >= 5)
            l5.setText("*");
        if (longueur >= 6)
            l6.setText("*");
        if (longueur >= 7)
            l7.setText("*");
        if (longueur >= 8)
            l8.setText("*");
        if (longueur >= 9)
            l9.setText("*");
        if (longueur >= 10)
            l10.setText("*");
    }


    //fermer la fenêtre
    @FXML
    public void fermer(){
        Stage stage = (Stage) quitter.getScene().getWindow();
        stage.close();
    }

    //lors du clic sur une des lettres, si la lettre correspond au mot, on l'affiche dans le label
    public void lclic(ActionEvent event) {
        Button btnClic = (Button) event.getTarget();

        int position = 0;
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 0) {
            l1.setText(btnClic.getText());
            position = 1;
        }
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 1) {
            l2.setText(btnClic.getText());
            position = 2;
        }
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 2) {
            l3.setText(btnClic.getText());
            position = 3;
        }
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 3) {
            l4.setText(btnClic.getText());
            position = 4;
        }
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 4) {
            l5.setText(btnClic.getText());
            position = 5;
        }
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 5) {
            l6.setText(btnClic.getText());
            position = 6;
        }
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 6) {
            l7.setText(btnClic.getText());
            position = 7;
        }
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 7) {
            l8.setText(btnClic.getText());
            position = 8;
        }
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 8) {
            l9.setText(btnClic.getText());
            position = 9;
        }
        if (mot.toUpperCase().indexOf(btnClic.getText(), position) == 9) {
            l10.setText(btnClic.getText());
            position = 10;
        }

        System.out.println(pasbon);


        //Affichage du pendu lorsque la lettre choisie n'est pas bonne
        if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 0) {
            b1.setVisible(true);
            pasbon = 1;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 1) {
            b2.setVisible(true);
            pasbon = 2;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 2) {
            b3.setVisible(true);
            pasbon = 3;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 3) {
            b4.setVisible(true);
            pasbon = 4;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 4) {
            b5.setVisible(true);
            pasbon = 5;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 5) {
            b6.setVisible(true);
            pasbon = 6;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 6) {
            b7.setVisible(true);
            pasbon = 7;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 7) {
            b8.setVisible(true);
            pasbon = 8;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 8) {
            b9.setVisible(true);
            pasbon = 9;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 9) {
            b10.setVisible(true);
            pasbon = 10;
        } else if (!mot.toUpperCase().contains(btnClic.getText()) && pasbon == 10) {
            b11.setVisible(true);
            pasbon = 11;
        }
        if (pasbon == 11) {
            defaite.setVisible(true);
            lancer.setVisible(true);
            quitter.setVisible(true);
        }

        btnClic.setDisable(true);

        //affichage de la victoire lorsque tous les labels sont complétés
        if (!l1.getText().equals("*") && !l2.getText().equals("*") && !l3.getText().equals("*") && !l4.getText().equals("*") && !l5.getText().equals("*") && !l6.getText().equals("*") && !l7.getText().equals("*") && !l8.getText().equals("*") && !l9.getText().equals("*") && !l10.getText().equals("*")) {
            victoire.setVisible(true);
            lancer.setVisible(true);
            quitter.setVisible(true);
        }


        //désactiver les boutons lors du clic
        if (pasbon == 11 || gagne) {
            if (!A.isDisable()) {
                A.setDisable(true);
            }
            if (!B.isDisable()) {
                B.setDisable(true);
            }
            if (!C.isDisable()) {
                C.setDisable(true);
            }
            if (!D.isDisable()) {
                D.setDisable(true);
            }
            if (!E.isDisable()) {
                E.setDisable(true);
            }
            if (!F.isDisable()) {
                F.setDisable(true);
            }
            if (!G.isDisable()) {
                G.setDisable(true);
            }
            if (!H.isDisable()) {
                H.setDisable(true);
            }
            if (!I.isDisable()) {
                I.setDisable(true);
            }
            if (!J.isDisable()) {
                J.setDisable(true);
            }
            if (!K.isDisable()) {
                K.setDisable(true);
            }
            if (!L.isDisable()) {
                L.setDisable(true);
            }
            if (!M.isDisable()) {
                M.setDisable(true);
            }
            if (!N.isDisable()) {
                N.setDisable(true);
            }
            if (!O.isDisable()) {
                O.setDisable(true);
            }
            if (!P.isDisable()) {
                P.setDisable(true);
            }
            if (!Q.isDisable()) {
                Q.setDisable(true);
            }
            if (!R.isDisable()) {
                R.setDisable(true);
            }
            if (!S.isDisable()) {
                S.setDisable(true);
            }
            if (!T.isDisable()) {
                T.setDisable(true);
            }
            if (!U.isDisable()) {
                U.setDisable(true);
            }
            if (!V.isDisable()) {
                V.setDisable(true);
            }
            if (!W.isDisable()) {
                W.setDisable(true);
            }
            if (!X.isDisable()) {
                X.setDisable(true);
            }
            if (!Y.isDisable()) {
                Y.setDisable(true);
            }
            if (!Z.isDisable()) {
                Z.setDisable(true);
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            PenduInterface penduInterface = (PenduInterface) Naming.lookup("rmi://localhost:8000/pendu");
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }

    }
}

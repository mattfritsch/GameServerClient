package controlleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modele.Caractere;
import modele.MorpionInterface;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

//Initialisation des différents bouton et label en FXML
public class ControlleurMorpion implements Initializable {
    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button btn3;
    @FXML
    Button btn4;
    @FXML
    Button btn5;
    @FXML
    Button btn6;
    @FXML
    Button btn7;
    @FXML
    Button btn8;
    @FXML
    Button btn9;
    @FXML
    Button quitter;
    @FXML
    GridPane plateau;
    @FXML
    Label msgvictoire;

    private MorpionInterface MorpionImpl;

//Fonction qui permet de cliquer sur une case du javaFx, et de mettre un caractère dans ce même bouton,puis par la suite
// vérifier si il y a un gagnant et pour finir affiche un message de victoire
    public void Cliquer(ActionEvent evt) {
        try {
            if (!this.MorpionImpl.VerifGagnant()) {
                Button caseClique = (Button) evt.getSource();
                int x = GridPane.getRowIndex(caseClique);
                int y = GridPane.getColumnIndex(caseClique);
                Caractere caract = null;
                if ((caract = this.MorpionImpl.PlacerCaract(x, y)) != null) {
                    if (caract.toString().equals("X")) {
                        caseClique.setText("X");
                        caseClique.setStyle("-fx-background-color:#DCFFFF; -fx-text-fill: black;");
                    } else if (caract.toString().equals("O")) {
                        caseClique.setText("O");
                        caseClique.setStyle("-fx-background-color:#FFFFDC; -fx-text-fill: black;");
                    }
                    caseClique.setText(caract.toString());
                    if (this.MorpionImpl.VerifGagnant()) {
                        btn1.setDisable(true);
                        btn2.setDisable(true);
                        btn3.setDisable(true);
                        btn4.setDisable(true);
                        btn5.setDisable(true);
                        btn6.setDisable(true);
                        btn7.setDisable(true);
                        btn8.setDisable(true);
                        btn9.setDisable(true);
                        msgvictoire.setText(this.MorpionImpl.msgGagnant());
                    }
                }
            }
        } catch (RemoteException e) {
            System.err.println(e);
        }
    }
//Fonction qui permet de fermer la fenetre en appuyant sur le bouton quitter
    public void actionQuitter(ActionEvent e) {
        Stage stage = (Stage) quitter.getScene().getWindow();
        stage.close();
    }
//Fonction qui reset le plateau de jeu
    public void reset(Button btn1, Button btn2, Button btn3, Button btn4, Button btn5, Button btn6, Button btn7, Button btn8, Button btn9, Label msgvictoire) {
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        btn8.setDisable(false);
        btn9.setDisable(false);
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn1.setStyle("");
        btn2.setStyle("");
        btn3.setStyle("");
        btn4.setStyle("");
        btn5.setStyle("");
        btn6.setStyle("");
        btn7.setStyle("");
        btn8.setStyle("");
        btn9.setStyle("");
        msgvictoire.setText("");
    }

//Fonction qui permet d'intialiser le plateau de jeu ainsi que la partie (Fonction qui permet aussi de rejouer)
    public void jouer() throws RemoteException, MalformedURLException, NotBoundException {
        MorpionInterface obj = (MorpionInterface) Naming.lookup("rmi://localhost:8000/morpion");
        reset(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, msgvictoire);
        obj.nouvellePartie();
        Caractere[][] plateau = this.MorpionImpl.getPlateau();
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                ((Button) this.plateau.getChildren().get(plateau.length * i + j)).setText(plateau[i][j] == null ? null : plateau[i][j].toString());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.MorpionImpl = (MorpionInterface) Naming.lookup("rmi://localhost:8000/morpion");
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

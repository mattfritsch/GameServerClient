package controlleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlleurMenu{

    @FXML
    private Button btnQuitter;

//Vers le jeu des allumettes
    public void onClickAllumette(ActionEvent event) throws IOException {
        Image allumette = new Image("/vue/allumette1.jpg");
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Jeu de l'allumette");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../vue/allumette.fxml"))));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.getIcons().add(allumette);
        stage.show();
    }
    //Vers le jeu du pendu
    public void onClickPendu(ActionEvent event) throws IOException {
        Image pendu = new Image("/vue/pendu2.jpg");
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Jeu du pendu");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../vue/pendu.fxml"))));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.getIcons().add(pendu);
        stage.show();
    }
    //Vers le jeu du morpion
    public void onClickMorpion(ActionEvent event) throws IOException {
        Image morpion = new Image("/vue/morpion.png");
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Jeu du morpion");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../vue/morpion.fxml"))));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.getIcons().add(morpion);
        stage.show();
    }
    //Quitter le programme
    public void onClickQuitter(){
        Stage stage = (Stage) btnQuitter.getScene().getWindow();
        stage.close();
    }
}

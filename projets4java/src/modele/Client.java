package modele;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Client extends Application {

    @Override
    public void start(final Stage primaryStage) {
        try {
            Image jeu = new Image("/vue/jeu.png");
            Parent root = FXMLLoader.load(getClass().getResource("../vue/menu.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.setTitle("Serveur de jeu RMI");
            primaryStage.getIcons().add(jeu);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

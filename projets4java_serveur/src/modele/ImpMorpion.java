package modele;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImpMorpion extends UnicastRemoteObject implements MorpionInterface{

    public ImpMorpion() throws RemoteException {
        super();
        this.nouvellePartie();
    }
//Déclaration des paramètres pour initialiser le jeu
    private final int t = 3;
    private boolean VerifGagnant;
    private Caractere[][] plateau;
    private Caractere prochainJoueur;
//Fonction qui permets de mettre en place le plateau de jeu ainsi que les caractères
    public void nouvellePartie() throws RemoteException {
        this.plateau = new Caractere[this.t][this.t];
        this.prochainJoueur = Caractere.X;
        this.VerifGagnant = false;

    }
//Fonction qui permet de récuperer le plateau avec les caractères
    public Caractere[][] getPlateau() throws RemoteException {
        return this.plateau;
    }
//Fonction qui permet de placer un caractère dans un tableau à 2 dimensions qui permettra de comparer les valeurs des cases
    public Caractere PlacerCaract(int x, int y) throws RemoteException {
        if (!this.VerifGagnant) {
            if (this.plateau[x][y] == null) {
                this.plateau[x][y] = this.prochainJoueur;
                Caractere caractereActuel = this.prochainJoueur;
                this.prochainJoueur = this.prochainJoueur.equals(Caractere.X) ? Caractere.O : Caractere.X;
                return caractereActuel;
            }
        }
        return null;
    }
// Fonction qui permet de vérifier si il y a un gagant en fonction des caractères (O ou X)
    public boolean VerifGagnant() throws RemoteException {
        this.VerifGagnant = true;
        Caractere caract = null;
        // Partie pour vérifier les lignes
        VerifLigne:
        for (int i = 0; i < this.t; i++) {
            caract = this.plateau[i][0];
            if (caract == null) {
                continue;
            }
            for (int j = 1; j < this.t; j++) {
                if (!caract.equals(this.plateau[i][j])) {
                    continue VerifLigne;
                }
            }
            return true;
        }
        //partie pour vérifier les colonnes
        verifColonne:
        for (int i = 0; i < this.t; i++) {
            caract = this.plateau[0][i];
            if (caract == null) {
                continue;
            }
            for (int j = 1; j < this.t; j++) {
                if (!caract.equals(this.plateau[j][i])) {
                    continue verifColonne;
                }
            }
            return true;
        }
        //Partie pour vérifier les diagonales
        boolean a = true;
        caract = this.plateau[0][0];
        if (caract != null) {
            for (int i = 1; i < this.t; i++) {
                if (!caract.equals(this.plateau[i][i])) {
                    a = false;
                    break;
                }
            }
            if (a) {
                return true;
            }
        }
        boolean b = true;
        caract = this.plateau[0][2];
        if (caract != null) {
            for (int i = 1; i < this.t; i++) {
                if (!caract.equals(this.plateau[i][this.t - 1 - i])) {
                    b = false;
                    break;
                }
            }
            if (b) {
                return true;
            }
        }
        this.VerifGagnant = false;
        return false;
    }
// Fonction qui oermet de mettre en place un label de message de victoire en fonction du joueur qui gagne
    public String msgGagnant() throws RemoteException{
        if (this.VerifGagnant){
            if(this.prochainJoueur.equals(Caractere.X))
                return "Les ronds ont gagné";
        }else if (this.prochainJoueur.equals(Caractere.O)){
            return "Les croix ont gagné";
        }
        return "Les croix ont gagné";
    }

    /*
    public boolean VerificationGagnantX(){
//Vérification des lignes
        if ("X".equals(btn1.getText()) && btn1.getText().equals(btn2.getText())
                && btn2.getText().equals(btn3.getText())){
            styleGagnant(btn1,btn2,btn3);
            return true;
        }
        if ("X".equals(btn4.getText()) && btn4.getText().equals(btn5.getText())
                && btn5.getText().equals(btn6.getText())){
            styleGagnant(btn4,btn5,btn6);
            return true;
        }
        if ("X".equals(btn7.getText()) && btn7.getText().equals(btn8.getText())
                && btn8.getText().equals(btn9.getText())){
            styleGagnant(btn7,btn8,btn9);
            return true;
        }
//Vérification des colonnes
        if ("X".equals(btn1.getText()) && btn1.getText().equals(btn4.getText())
                && btn4.getText().equals(btn7.getText())){
            styleGagnant(btn1,btn4,btn7);
            return true;
        }
        if ("X".equals(btn2.getText()) && btn2.getText().equals(btn5.getText())
                && btn5.getText().equals(btn8.getText())){
            styleGagnant(btn2,btn5,btn8);
            return true;
        }
        if ("X".equals(btn3.getText()) && btn3.getText().equals(btn6.getText())
                && btn6.getText().equals(btn9.getText())){
            styleGagnant(btn3,btn6,btn9);
            return true;
        }
//Vérification des Diagnoles
        if ("X".equals(btn1.getText()) && btn1.getText().equals(btn5.getText())
                && btn5.getText().equals(btn9.getText())){
            styleGagnant(btn1,btn5,btn9);
            return true;
        }
        if ("X".equals(btn3.getText()) && btn3.getText().equals(btn5.getText())
                && btn5.getText().equals(btn7.getText())){
            styleGagnant(btn3,btn5,btn7);
            return true;
        }
        return false;
    }

    public boolean VerificationGagnantO(){
//Vérification des lignes
        if ("O".equals(btn1.getText()) && btn1.getText().equals(btn2.getText())
                && btn2.getText().equals(btn3.getText())){
            styleGagnant(btn1,btn2,btn3);
            return true;
        }
        if ("O".equals(btn4.getText()) && btn4.getText().equals(btn5.getText())
                && btn5.getText().equals(btn6.getText())){
            styleGagnant(btn4,btn5,btn6);
            return true;
        }
        if ("O".equals(btn7.getText()) && btn7.getText().equals(btn8.getText())
                && btn8.getText().equals(btn9.getText())){
            styleGagnant(btn7,btn8,btn9);
            return true;
        }
//Vérification des colonnes
        if ("O".equals(btn1.getText()) && btn1.getText().equals(btn4.getText())
                && btn4.getText().equals(btn7.getText())){
            styleGagnant(btn1,btn4,btn7);
            return true;
        }
        if ("O".equals(btn2.getText()) && btn2.getText().equals(btn5.getText())
                && btn5.getText().equals(btn8.getText())){
            styleGagnant(btn2,btn5,btn8);
            return true;
        }
        if ("O".equals(btn3.getText()) && btn3.getText().equals(btn6.getText())
                && btn6.getText().equals(btn9.getText())){
            styleGagnant(btn3,btn6,btn9);
            return true;
        }
//Vérification des Diagnoles
        if ("O".equals(btn1.getText()) && btn1.getText().equals(btn5.getText())
                && btn5.getText().equals(btn9.getText())){
            styleGagnant(btn1,btn5,btn9);
            return true;
        }
        if ("O".equals(btn3.getText()) && btn3.getText().equals(btn5.getText())
                && btn5.getText().equals(btn7.getText())){
            styleGagnant(btn3,btn5,btn7);
            return true;
        }
        return false;
    }
*/


  /*  public void styleGagnant(Button PremiereCase, Button DeuxiemeCase, Button TroisiemeCase){
        PremiereCase.setStyle("-fx-background-color:green; -fx-text-fill: red;");
        DeuxiemeCase.setStyle("-fx-background-color:green; -fx-text-fill: red;");
        TroisiemeCase.setStyle("-fx-background-color:green; -fx-text-fill: red;");

    }*/



}

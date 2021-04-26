package modele;


import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] argv) {
        try {
            //initialisation du port à 8000
            LocateRegistry.createRegistry(8000);
            Naming.rebind("rmi://localhost:8000/allumette", new ImpAllumette());
            System.out.println("Serveur allumette prêt !");

            Naming.rebind("rmi://localhost:8000/pendu", new ImpPendu());
            System.out.println("Serveur pendu prêt !");

            Naming.rebind("rmi://localhost:8000/morpion", new ImpMorpion());
            System.out.print("Serveur morpion prêt !");

        } catch (Exception e) {
            System.out.println("Serveur allumette échec " + e);
            System.out.println("Serveur pendu échec " + e);
            System.out.println("Serveur morpion échec " + e);
        }
    }
}

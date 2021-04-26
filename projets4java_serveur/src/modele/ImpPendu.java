package modele;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class ImpPendu extends UnicastRemoteObject implements PenduInterface{

    protected ImpPendu() throws RemoteException {
        super();
    }

    //génération d'un mot aléatoire parmis ceux qui sont écrits dans un fichier texte grâce à un randomGenerator
    public String genererMotPendu() throws RemoteException {
        String mot="bonjour";

        int incrementation = 0;
        Random randomGenerator = new Random();
        int limite = randomGenerator.nextInt(15);
        System.out.println(limite+"\n");

        try{
            InputStream ips=new FileInputStream("../projets4java_serveur/src/modele/dictionnaire.txt");
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            while ((ligne=br.readLine())!=null && incrementation<limite){
                mot = ligne;
                incrementation++;
            }
            br.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return mot;
    }
}

import bdd.*;
import gestionBiere.*;
import java.util.ArrayList;

public class BeerProject {
    public static void main(String[] args) {
        BaseDonnee baseDonnee = new BaseDonnee();

        ArrayList test = baseDonnee.getListeBreuvage();
        System.out.println(test.size());
        Breuvage breuv = new Breuvage();
        System.out.println("Ok");
        baseDonnee.ajoutBreuvage(breuv);
        System.out.println("Ok");
        baseDonnee.ajoutBreuvage(breuv);
        System.out.println("Ok");
        baseDonnee.ajoutBreuvage(breuv);
        System.out.println(test.size());
        baseDonnee.suppressionBreuvage(breuv);
        System.out.println(test.size());
    }
}

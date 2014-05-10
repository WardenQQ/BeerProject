import Graphics.FenetrePrincipale;
import bdd.*;
import gestionBiere.*;
import java.util.ArrayList;

public class BeerProject {
    public static void main(String[] args) {
        //FenetrePrincipale p = new FenetrePrincipale();

        BaseDonnee bdd = new BaseDonnee("breuvage.bdd");

        ArrayList<StringBuffer> liste = bdd.getListeCouleur();
        StringBuffer str = liste.get(0);
        str.replace(0, str.length(), "Fucking Bill Burr");

        ArrayList<Breuvage> test = bdd.getListeBreuvage();
        System.out.println(test.get(0).getCouleur());
    }
}

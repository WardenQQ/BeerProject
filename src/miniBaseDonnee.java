import Graphics.FenetrePrincipale;
import bdd.*;
import gestionBiere.*;
import java.util.ArrayList;

public class miniBaseDonnee {
    public static void main(String[] args) {
        BaseDonnee baseDonnee = new BaseDonnee();

        StringBuffer blanche = new StringBuffer("Blanche");
        StringBuffer blonde = new StringBuffer("Blonde");
        StringBuffer brune = new StringBuffer("Brune");
        baseDonnee.ajoutCouleur(blanche);
        baseDonnee.ajoutCouleur(blonde);
        baseDonnee.ajoutCouleur(brune);

        StringBuffer abbaye = new StringBuffer("Abbaye");
        StringBuffer industrie = new StringBuffer("Industrie");
        StringBuffer trappiste = new StringBuffer("Trappiste");
        baseDonnee.ajoutProvenance(abbaye);
        baseDonnee.ajoutProvenance(industrie);
        baseDonnee.ajoutProvenance(trappiste);
        
        LieuOrigine lieu = new LieuOrigine(new StringBuffer("Strasbourg"), new StringBuffer("France"));
        baseDonnee.ajoutLieuOrigine(lieu);

        Brasserie kronenbourg = new Brasserie(new StringBuffer("Les Brasseurs"), lieu);
        baseDonnee.ajoutBrasserie(kronenbourg);

        Breuvage biere1 = new Breuvage(new StringBuffer("Biere1"), kronenbourg, lieu, 0.0, 1992, blanche, new StringBuffer(""), new StringBuffer(""), industrie, new StringBuffer(), new StringBuffer()); 
        Breuvage biere2 = new Breuvage(new StringBuffer("Biere2"), kronenbourg, lieu, 0.0, 1992, blonde, new StringBuffer(""), new StringBuffer(""), industrie, new StringBuffer(), new StringBuffer()); 
        baseDonnee.ajoutBreuvage(biere1);
        baseDonnee.ajoutBreuvage(biere2);

        baseDonnee.sauvegarder("breuvage.bdd");
    }
}

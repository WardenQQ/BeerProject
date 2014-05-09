package bdd;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import gestionBiere.*;

public class BaseDonnee {
    private String nomFichier;
    private Boolean aChange;

    private ArrayList<Bouteille> listeBouteille;
    private ArrayList<Breuvage> listeBreuvage;
    private ArrayList<Brasserie> listeBrasserie;
    private ArrayList<LieuOrigine> listeLieuOrigine;
    private ArrayList<String> listeCouleur;
    private ArrayList<String> listeFermentation;
    private ArrayList<String> listeTypeFermentation;
    private ArrayList<String> listeProvenance;

    public BaseDonnee() {
            listeBouteille = new ArrayList<Bouteille>();
            listeBreuvage = new ArrayList<Breuvage>();
            listeBrasserie = new ArrayList<Brasserie>();
            listeLieuOrigine = new ArrayList<LieuOrigine>();
            listeCouleur = new ArrayList<String>();
            listeFermentation = new ArrayList<String>();
            listeTypeFermentation = new ArrayList<String>();
            listeProvenance = new ArrayList<String>();
    }

    public ArrayList<Bouteille> getListeBouteille() { return listeBouteille; }
    public ArrayList<Breuvage> getListeBreuvage() { return listeBreuvage; }
    public ArrayList<Brasserie> getListeBrasserie() { return listeBrasserie; }
    public ArrayList<LieuOrigine> getListeLieuOrigine() { return listeLieuOrigine; }
    public ArrayList<String> getListeCouleur() { return listeCouleur; }
    public ArrayList<String> getListeFermentation() { return listeFermentation; }
    public ArrayList<String> getListeTypeFermentation() { return listeTypeFermentation; }
    public ArrayList<String> getListeProvenance() { return listeProvenance; }

    public BaseDonnee(String nomFichier) {
        this();
        charger(nomFichier);

        this.aChange = false;
        this.nomFichier = nomFichier;
    }
    
    public boolean sauvegarder(String nomFichier) {
        boolean aSauve = false;
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(nomFichier));

            os.writeObject(listeBouteille);
            os.writeObject(listeBreuvage);
            os.writeObject(listeBrasserie);
            os.writeObject(listeLieuOrigine);
            os.writeObject(listeCouleur);
            os.writeObject(listeFermentation);
            os.writeObject(listeTypeFermentation);
            os.writeObject(listeProvenance);

            os.close();
            aSauve = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aSauve;
    }

    public boolean charger(String nomFichier) {
        boolean aCharge = false;
        File fichier = new File(nomFichier);
        if (fichier.exists()) {
            try {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(fichier));

                listeBouteille = (ArrayList<Bouteille>)is.readObject();
                listeBreuvage = (ArrayList<Breuvage>)is.readObject();
                listeBrasserie = (ArrayList<Brasserie>)is.readObject();
                listeLieuOrigine = (ArrayList<LieuOrigine>)is.readObject();
                listeCouleur = (ArrayList<String>)is.readObject();
                listeFermentation = (ArrayList<String>)is.readObject();
                listeTypeFermentation = (ArrayList<String>)is.readObject();
                listeProvenance = (ArrayList<String>)is.readObject();

                is.close();
                aCharge = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return aCharge;
    }

    public void ajoutBouteille(Bouteille nouvelleBouteille) {
        listeBouteille.add(nouvelleBouteille);
    }

    public void ajoutBreuvage(Breuvage nouvelleBreuvage) {
        listeBreuvage.add(nouvelleBreuvage);
    }

    public void ajoutBrasserie(Brasserie nouvelleBrasserie) {
        listeBrasserie.add(nouvelleBrasserie);
    }

    public void ajoutLieuOrigine(LieuOrigine nouvelleLieuOrigine) {
        listeLieuOrigine.add(nouvelleLieuOrigine);
    }

    public void ajoutCouleur(String nouvelleCouleur) {
        listeCouleur.add(nouvelleCouleur);
    }

    public void ajoutFermentation(String nouvelleFermentation) {
        listeFermentation.add(nouvelleFermentation);
    }

    public void ajoutTypeFermentation(String nouvelleTypeFermentation) {
        listeTypeFermentation.add(nouvelleTypeFermentation);
    }

    public void ajoutProvenance(String nouvelleProvenance) {
        listeProvenance.add(nouvelleProvenance);
    }

    public void suppressionBouteille(Bouteille nouvelleBouteille) {
        listeBouteille.remove(nouvelleBouteille);
    }

    public void suppressionBreuvage(Breuvage nouvelleBreuvage) {
        listeBreuvage.remove(nouvelleBreuvage);
    }

    public void suppressionBrasserie(Brasserie nouvelleBrasserie) {
        listeBrasserie.remove(nouvelleBrasserie);
    }

    public void suppressionLieuOrigine(LieuOrigine nouvelleLieuOrigine) {
        listeLieuOrigine.remove(nouvelleLieuOrigine);
    }

    public void suppressionCouleur(String nouvelleCouleur) {
        listeCouleur.remove(nouvelleCouleur);
    }

    public void suppressionFermentation(String nouvelleFermentation) {
        listeFermentation.remove(nouvelleFermentation);
    }

    public void suppressionTypeFermentation(String nouvelleTypeFermentation) {
        listeTypeFermentation.remove(nouvelleTypeFermentation);
    }

    public void suppressionProvenance(String nouvelleProvenance) {
        listeProvenance.remove(nouvelleProvenance);
    }
}

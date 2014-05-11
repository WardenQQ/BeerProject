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
    private ArrayList<StringBuffer> listeCouleur;
    private ArrayList<StringBuffer> listeFermentation;
    private ArrayList<StringBuffer> listeTypeFermentation;
    private ArrayList<StringBuffer> listeProvenance;
    private ArrayList<StringBuffer> listeTypeBouteille;
    private ArrayList<StringBuffer> listeBouchon;

    public BaseDonnee() {
            listeBouteille = new ArrayList<Bouteille>();
            listeBreuvage = new ArrayList<Breuvage>();
            listeBrasserie = new ArrayList<Brasserie>();
            listeLieuOrigine = new ArrayList<LieuOrigine>();
            listeCouleur = new ArrayList<StringBuffer>();
            listeFermentation = new ArrayList<StringBuffer>();
            listeTypeFermentation = new ArrayList<StringBuffer>();
            listeProvenance = new ArrayList<StringBuffer>();
            listeTypeBouteille = new ArrayList<StringBuffer>();
            listeBouchon = new ArrayList<StringBuffer>();
    }

    public ArrayList<Bouteille> getListeBouteille() { return listeBouteille; }
    public ArrayList<Breuvage> getListeBreuvage() { return listeBreuvage; }
    public ArrayList<Brasserie> getListeBrasserie() { return listeBrasserie; }
    public ArrayList<LieuOrigine> getListeLieuOrigine() { return listeLieuOrigine; }
    public ArrayList<StringBuffer> getListeCouleur() { return listeCouleur; }
    public ArrayList<StringBuffer> getListeFermentation() { return listeFermentation; }
    public ArrayList<StringBuffer> getListeTypeFermentation() { return listeTypeFermentation; }
    public ArrayList<StringBuffer> getListeProvenance() { return listeProvenance; }
    public ArrayList<StringBuffer> getListeTypeBouteille() { return listeTypeBouteille; }
    public ArrayList<StringBuffer> getListeBouchon() { return listeBouchon; }

    public BaseDonnee(String nomFichier) {
        this();
        charger(nomFichier);

        this.aChange = false;
        this.nomFichier = nomFichier;
    }
    
    @SuppressWarnings("unchecked")
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
            os.writeObject(listeTypeBouteille);
            os.writeObject(listeBouchon);

            os.close();
            aSauve = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aSauve;
    }

    @SuppressWarnings("unchecked")
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
                listeCouleur = (ArrayList<StringBuffer>)is.readObject();
                listeFermentation = (ArrayList<StringBuffer>)is.readObject();
                listeTypeFermentation = (ArrayList<StringBuffer>)is.readObject();
                listeProvenance = (ArrayList<StringBuffer>)is.readObject();
                listeTypeBouteille = (ArrayList<StringBuffer>)is.readObject();
                listeBouchon = (ArrayList<StringBuffer>)is.readObject();

                is.close();
                aCharge = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return aCharge;
    }

    public void ajoutBouteille(Bouteille nouvelleBouteille) {
        if (!listeBouteille.contains(nouvelleBouteille)) {
            listeBouteille.add(nouvelleBouteille);
        }
    }

    public void ajoutBreuvage(Breuvage nouvelleBreuvage) {
        if (!listeBreuvage.contains(nouvelleBreuvage)) {
            listeBreuvage.add(nouvelleBreuvage);
        }
    }

    public void ajoutBrasserie(Brasserie nouvelleBrasserie) {
        if (!listeBrasserie.contains(nouvelleBrasserie)) {
            listeBrasserie.add(nouvelleBrasserie);
        }
    }

    public void ajoutLieuOrigine(LieuOrigine nouvelleLieuOrigine) {
        if (!listeLieuOrigine.contains(nouvelleLieuOrigine)) {
            listeLieuOrigine.add(nouvelleLieuOrigine);
        }
    }

    public void ajoutCouleur(StringBuffer nouvelleCouleur) {
        if (!listeCouleur.contains(nouvelleCouleur)) {
            listeCouleur.add(nouvelleCouleur);
        }
    }

    public void ajoutFermentation(StringBuffer nouvelleFermentation) {
        if (!listeFermentation.contains(nouvelleFermentation)) {
            listeFermentation.add(nouvelleFermentation);
        }
    }

    public void ajoutTypeFermentation(StringBuffer nouvelleTypeFermentation) {
        if (!listeTypeFermentation.contains(nouvelleTypeFermentation)) {
            listeTypeFermentation.add(nouvelleTypeFermentation);
        }
    }

    public void ajoutProvenance(StringBuffer nouvelleProvenance) {
        if (!listeProvenance.contains(nouvelleProvenance)) {
            listeProvenance.add(nouvelleProvenance);
        }
    }

    public void ajoutTypeBouteille(StringBuffer nouvelleBouteille) {
        if (!listeTypeBouteille.contains(nouvelleBouteille)) {
            listeTypeBouteille.add(nouvelleBouteille);
        }
    }

    public void ajoutBouchon(StringBuffer nouvelleBouchon) {
        if (!listeBouchon.contains(nouvelleBouchon)) {
            listeBouchon.add(nouvelleBouchon);
        }
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

    public void suppressionCouleur(StringBuffer nouvelleCouleur) {
        listeCouleur.remove(nouvelleCouleur);
    }

    public void suppressionFermentation(StringBuffer nouvelleFermentation) {
        listeFermentation.remove(nouvelleFermentation);
    }

    public void suppressionTypeFermentation(StringBuffer nouvelleTypeFermentation) {
        listeTypeFermentation.remove(nouvelleTypeFermentation);
    }

    public void suppressionProvenance(StringBuffer nouvelleProvenance) {
        listeProvenance.remove(nouvelleProvenance);
    }

    public void suppressionTypeBouteille(StringBuffer nouvelleTypeBouteille) {
        listeTypeBouteille.remove(nouvelleTypeBouteille);
    }

    public void suppressionBouchon(StringBuffer nouvelleBouchon) {
        listeBouchon.remove(nouvelleBouchon);
    }
}

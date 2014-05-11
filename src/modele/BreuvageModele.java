package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import gestionBiere.Breuvage;
import gestionBiere.LieuOrigine;

public class BreuvageModele extends AbstractTableModel implements Observer
{
    private static final long serialVersionUID = 1L;
    private final String[] entete = {
        "Identifiant",
        "Nom du breuvage",
        "Nom de la brasserie",
        "Ville d'origine",
        "Pays d'origine",
        "Taux d'alcool",
        "Année d'origine",
        "Couleur",
        "Fermentation",
        "Type de fermentation",
        "Provenance",
        "Commentaire de dégustation",
        "Commentaire de libre"
    };
    private ArrayList<Breuvage> listeBreuvage;

    public BreuvageModele(ArrayList<Breuvage> listeBreuvage) {
        super();
        this.listeBreuvage = listeBreuvage;
    }

    public int getRowCount() {
        return listeBreuvage.size();
    }

    public int getColumnCount() {
        return entete.length;
    }

    public String getColumnName(int columnIndex) {
        return entete[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listeBreuvage.get(rowIndex).getIdentifiant();
            case 1:
                return listeBreuvage.get(rowIndex).getNom();
            case 2:
                return listeBreuvage.get(rowIndex).getBrasserie().getNom();
            case 3:
                return listeBreuvage.get(rowIndex).getLieuOrigine().getNom();
            case 4:
                return listeBreuvage.get(rowIndex).getLieuOrigine().getPaysAppartenance();
            case 5:
                return listeBreuvage.get(rowIndex).getTauxAlcool();
            case 6:
                return listeBreuvage.get(rowIndex).getAnneeOrigine();
            case 7:
                return listeBreuvage.get(rowIndex).getCouleur();
            case 8:
                return listeBreuvage.get(rowIndex).getFermentation();
            case 9:
                return listeBreuvage.get(rowIndex).getTypeFermentation();
            case 10:
                return listeBreuvage.get(rowIndex).getProvenance();
            case 11:
                return listeBreuvage.get(rowIndex).getCommentaireDegustation().getTexte();
            case 12:
                return listeBreuvage.get(rowIndex).getCommentaireLibre().getTexte();
            default:
                return null;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex > 0;
    }

    public void ajoutBreuvage() {
        listeBreuvage.add(new Breuvage());

        fireTableRowsInserted(listeBreuvage.size() - 1, listeBreuvage.size() - 1);
    }
    
    public void suppressionBreuvage(int rowIndex) {
        listeBreuvage.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);
    }

    public void notify(String string, Object obj) {
        if (string.equals("Couleur")) {
            for (Breuvage ite : listeBreuvage) {
                if (ite.getCouleur() == obj) {
                    ite.setCouleur(new StringBuffer());
                    break;
                }
            }
        } else if (string.equals("Fermentation")) {
            for (Breuvage ite : listeBreuvage) {
                if (ite.getFermentation() == obj) {
                    ite.setFermentation(new StringBuffer());
                    break;
                }
            }
        } else if (string.equals("TypeFermentation")) {
            for (Breuvage ite : listeBreuvage) {
                if (ite.getTypeFermentation() == obj) {
                    ite.setTypeFermentation(new StringBuffer());
                    break;
                }
            }
        } else if (string.equals("Provenance")) {
            for (Breuvage ite : listeBreuvage) {
                if (ite.getProvenance() == obj) {
                    ite.setProvenance(new StringBuffer());
                    break;
                }
            }
        } else if (string.equals("LieuOrigine")) {
            for (Breuvage ite : listeBreuvage) {
                if (ite.getLieuOrigine() == obj) {
                    ite.setLieuOrigine(new LieuOrigine());
                    break;
                }
            }
        }
    }
}

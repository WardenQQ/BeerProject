package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import gestionBiere.LieuOrigine;

public class LieuOrigineModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;

    private final String[] entete = { "Identifiant", "Ville d'origine", "Pays d'origine" };

    private static ArrayList<LieuOrigine> listeLieuOrigine;
    ArrayList<Observer> listeObserver;

    public LieuOrigineModele(ArrayList<LieuOrigine> listeLieuOrigine) {
        super();
        this.listeLieuOrigine = listeLieuOrigine;
    }

    public int getRowCount() {
        return listeLieuOrigine.size();
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
                return listeLieuOrigine.get(rowIndex).getIdentifiant();
            case 1:
                return listeLieuOrigine.get(rowIndex).getNom();
            case 2:
                return listeLieuOrigine.get(rowIndex).getPaysAppartenance();
            default:
                return null;
        }
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue != null) {
            LieuOrigine listeLieuOrigine = this.listeLieuOrigine.get(rowIndex);

            switch (columnIndex) {
                case 1:
                    listeLieuOrigine.getNom().replace(0,
                    		listeLieuOrigine.getNom().length(), (String)aValue);
                    break;
                case 2:
                	listeLieuOrigine.getPaysAppartenance().replace(0,
                    		listeLieuOrigine.getPaysAppartenance().length(), (String)aValue);
                	break;
                default:
                	break;
            }
        }
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void ajoutLieuOrigine() {
        listeLieuOrigine.add(new LieuOrigine());

        fireTableRowsInserted(listeLieuOrigine.size() - 1, listeLieuOrigine.size() - 1);
    }
    
    public void suppressionLieuOrigine(int rowIndex) {
        Object objSupprimer = listeLieuOrigine.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);

        notify("Provenance", objSupprimer);
    }

    public void ajoutObserver(Observer observer) {
        if (observer != null) {
            listeObserver.add(observer);
        }
    }

    private void notify(String string, Object obj) {
        for (Observer ite : listeObserver) {
            ite.notify(string, obj);
        }
    }

    public static LieuOrigine rechercheVilleOrigine(String regex) {
        for (LieuOrigine ite : listeLieuOrigine) {
            if (ite.getNom().toString().matches(regex)) {
                return ite;
            }
        }

        return new LieuOrigine();
    }

    public static LieuOrigine recherchePaysOrigine(String regex) {
        for (LieuOrigine ite : listeLieuOrigine) {
            if (ite.getPaysAppartenance().toString().matches(regex)) {
                return ite;
            }
        }

        return new LieuOrigine();
    }
}

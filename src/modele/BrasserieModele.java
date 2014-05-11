package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import gestionBiere.Brasserie;

public class BrasserieModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;
    private final String[] entete = {"Identifiant", "Nom de la Brasserie", "Ville d'origine", "Pays d'origine"};
    private ArrayList<Brasserie> listeBrasserie;

    public BrasserieModele(ArrayList<Brasserie> listeBrasserie) {
        super();
        this.listeBrasserie = listeBrasserie;
    }

    public int getRowCount() {
        return listeBrasserie.size();
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
                return listeBrasserie.get(rowIndex).getIdentifiant();
            case 1:
                return listeBrasserie.get(rowIndex).getNom();
            case 2:
                return listeBrasserie.get(rowIndex).getLieuOrigine().getNom();
            case 3:
                return listeBrasserie.get(rowIndex).getLieuOrigine().getPaysAppartenance();
            default:
                return null;
        }
    }

    public void ajoutBrasserie() {
        listeBrasserie.add(new Brasserie());

        fireTableRowsInserted(listeBrasserie.size() - 1, listeBrasserie.size() - 1);
    }
    
    public void suppressionBrasserie(int rowIndex) {
        listeBrasserie.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);
    }
}

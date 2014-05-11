package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import gestionBiere.LieuOrigine;

public class LieuOrigineModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;
    private final String[] entete = { "Identifiant", "Ville d'origine", "Pays d'origine" };
    private ArrayList<LieuOrigine> listeLieuOrigine;

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

    public void ajoutLieuOrigine() {
        listeLieuOrigine.add(new LieuOrigine());

        fireTableRowsInserted(listeLieuOrigine.size() - 1, listeLieuOrigine.size() - 1);
    }
    
    public void suppressionLieuOrigine(int rowIndex) {
        listeLieuOrigine.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);
    }
}

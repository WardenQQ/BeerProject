package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CouleurModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;
    private final String[] entete = { "Couleur" };
    private ArrayList<StringBuffer> listeCouleur;

    public CouleurModele(ArrayList<StringBuffer> listeCouleur) {
        super();
        this.listeCouleur = listeCouleur;
    }

    public int getRowCount() {
        return listeCouleur.size();
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
                return listeCouleur.get(rowIndex);
            default:
                return null;
        }
    }
}

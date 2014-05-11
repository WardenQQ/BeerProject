package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TypeBouteilleModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;
    private final String[] entete = { "TypeBouteille" };
    private ArrayList<StringBuffer> listeTypeBouteille;

    public TypeBouteilleModele(ArrayList<StringBuffer> listeTypeBouteille) {
        super();
        this.listeTypeBouteille = listeTypeBouteille;
    }

    public int getRowCount() {
        return listeTypeBouteille.size();
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
                return listeTypeBouteille.get(rowIndex);
            default:
                return null;
        }
    }
}

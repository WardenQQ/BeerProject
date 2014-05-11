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

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StringBuffer couleur = listeCouleur.get(rowIndex);

        switch (columnIndex) {
            case 0:
                couleur.replace(0, couleur.length(), (String)aValue);
                break;
            default:
        }
    }

    public void ajoutCouleur() {
        listeCouleur.add(new StringBuffer());

        fireTableRowsInserted(listeCouleur.size() - 1, listeCouleur.size() - 1);
    }
    
    public void suppressionCouleur(int rowIndex) {
        listeCouleur.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);
    }
}

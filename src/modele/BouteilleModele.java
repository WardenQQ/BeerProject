package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import gestionBiere.Bouteille;

public class BouteilleModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;
    private final String[] entete = {"Nom breuvage", "Type de bouteille", "Taille", "Type de bouchon", "lienPhoto"};
    private ArrayList<Bouteille> listeBouteille;

    public BouteilleModele(ArrayList<Bouteille> listeBouteille) {
        super();
        this.listeBouteille = listeBouteille;
    }

    public int getRowCount() {
        return listeBouteille.size();
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
                return listeBouteille.get(rowIndex).getBreuvage().getNom();
            case 1:
                return listeBouteille.get(rowIndex).getType();
            case 2:
                return listeBouteille.get(rowIndex).getTaille();
            case 3:
                return listeBouteille.get(rowIndex).getBouchon();
            case 4:
                return listeBouteille.get(rowIndex).getLienPhoto();
            default:
                return null;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void ajoutBouteille() {
        listeBouteille.add(new Bouteille());

        fireTableRowsInserted(listeBouteille.size() - 1, listeBouteille.size() - 1);
    }
    
    public void suppressionBouteille(int rowIndex) {
        listeBouteille.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);
    }
    
    public void setValueAt(Object aValue,int rowIndex, int columnIndex)
    {
    	if (aValue != null) {
    		Bouteille listeBouteille = this.listeBouteille.get(rowIndex);
    		
    		switch(columnIndex)
    		{		 
    			case 2 : 
    				listeBouteille.setTailleBouteille(((Integer)aValue).intValue());
    				break;
    			case 4 :
    				listeBouteille.getLienPhoto().replace(0, listeBouteille.getLienPhoto().length(), (String)aValue);
    				break;
    			default :
    				break;
    		}
    	}
    }
}

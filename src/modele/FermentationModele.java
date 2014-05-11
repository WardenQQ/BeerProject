package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class FermentationModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;
    private final String[] entete = { "Fermentation" };
    private ArrayList<StringBuffer> listeFermentation;

    public FermentationModele(ArrayList<StringBuffer> listeFermentation) {
        super();
        this.listeFermentation = listeFermentation;
    }

    public int getRowCount() {
        return listeFermentation.size();
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
                return listeFermentation.get(rowIndex);
            default:
                return null;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void ajoutFermentation() {
        listeFermentation.add(new StringBuffer());

        fireTableRowsInserted(listeFermentation.size() - 1, listeFermentation.size() - 1);
    }
    
    public void suppressionFermentation(int rowIndex) {
        listeFermentation.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);
    }
}

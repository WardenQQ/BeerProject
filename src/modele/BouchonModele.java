package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class BouchonModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;
    private final String[] entete = { "Bouchon" };
    private ArrayList<StringBuffer> listeBouchon;

    public BouchonModele(ArrayList<StringBuffer> listeBouchon) {
        super();
        this.listeBouchon = listeBouchon;
    }

    public int getRowCount() {
        return listeBouchon.size();
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
                return listeBouchon.get(rowIndex);
            default:
                return null;
        }
    }
}

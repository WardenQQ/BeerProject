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

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue != null) {
            StringBuffer bouchon = listeBouchon.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    bouchon.replace(0, bouchon.length(), (String)aValue);
                    break;
                default:
            }
        }
    }

    public void ajoutBouchon() {
        listeBouchon.add(new StringBuffer());

        fireTableRowsInserted(listeBouchon.size() - 1, listeBouchon.size() - 1);
    }
    
    public void suppressionBouchon(int rowIndex) {
        listeBouchon.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);
    }
}

package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ProvenanceModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;
    private final String[] entete = { "Provenance" };
    private ArrayList<StringBuffer> listeProvenance;

    public ProvenanceModele(ArrayList<StringBuffer> listeProvenance) {
        super();
        this.listeProvenance = listeProvenance;
    }

    public int getRowCount() {
        return listeProvenance.size();
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
                return listeProvenance.get(rowIndex);
            default:
                return null;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void ajoutProvenance() {
        listeProvenance.add(new StringBuffer());

        fireTableRowsInserted(listeProvenance.size() - 1, listeProvenance.size() - 1);
    }
    
    public void suppressionProvenance(int rowIndex) {
        listeProvenance.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);
    }
}

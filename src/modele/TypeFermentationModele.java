package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TypeFermentationModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;

    private final String[] entete = { "TypeFermentation" };

    private ArrayList<StringBuffer> listeTypeFermentation;
    ArrayList<Observer> listeObserver;

    public TypeFermentationModele(ArrayList<StringBuffer> listeTypeFermentation) {
        super();
        this.listeTypeFermentation = listeTypeFermentation;
        this.listeObserver = new ArrayList<Observer>();
    }

    public int getRowCount() {
        return listeTypeFermentation.size();
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
                return listeTypeFermentation.get(rowIndex);
            default:
                return null;
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue != null) {
            StringBuffer typeFermentation = listeTypeFermentation.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    typeFermentation.replace(0, typeFermentation.length(), (String)aValue);
                    break;
                default:
            }
        }
    }

    public void ajoutTypeFermentation() {
        listeTypeFermentation.add(new StringBuffer());

        fireTableRowsInserted(listeTypeFermentation.size() - 1, listeTypeFermentation.size() - 1);
    }
    
    public void suppressionTypeFermentation(int rowIndex) {
        Object objSupprimer = listeTypeFermentation.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);

        notify("TypeFermentation", objSupprimer);
    }

    public void ajoutObserver(Observer observer) {
        if (observer != null) {
            listeObserver.add(observer);
        }
    }

    private void notify(String string, Object obj) {
        for (Observer ite : listeObserver) {
            ite.notify(string, obj);
        }
    }
}

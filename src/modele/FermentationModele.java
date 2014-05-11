package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class FermentationModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;

    private final String[] entete = { "Fermentation" };

    private static ArrayList<StringBuffer> listeFermentation;
    ArrayList<Observer> listeObserver;

    public FermentationModele(ArrayList<StringBuffer> listeFermentation) {
        super();
        this.listeFermentation = listeFermentation;
        this.listeObserver = new ArrayList<Observer>();
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

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue != null) {
            StringBuffer fermentation = listeFermentation.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    fermentation.replace(0, fermentation.length(), (String)aValue);
                    break;
                default:
            }
        }
    }

    public void ajoutFermentation() {
        listeFermentation.add(new StringBuffer());

        fireTableRowsInserted(listeFermentation.size() - 1, listeFermentation.size() - 1);
    }

    public void suppressionFermentation(int rowIndex) {
        Object objSupprimer = listeFermentation.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);

        notify("Fermentation", objSupprimer);
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

    public static StringBuffer rechercheFermentation(String regex) {
        for (StringBuffer ite : listeFermentation) {
            if (ite.toString().matches(regex)) {
                return ite;
            }
        }

        return new StringBuffer();
    }
}

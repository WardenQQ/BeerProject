package modele;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TypeBouteilleModele extends AbstractTableModel 
{
    private static final long serialVersionUID = 1L;

    private final String[] entete = { "TypeBouteille" };

    private ArrayList<StringBuffer> listeTypeBouteille;
    ArrayList<Observer> listeObserver;

    public TypeBouteilleModele(ArrayList<StringBuffer> listeTypeBouteille) {
        super();
        this.listeTypeBouteille = listeTypeBouteille;
        this.listeObserver = new ArrayList<Observer>();
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

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (aValue != null) {
            StringBuffer typeBouteille = listeTypeBouteille.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    typeBouteille.replace(0, typeBouteille.length(), (String)aValue);
                    break;
                default:
            }
        }
    }

    public void ajoutTypeBouteille() {
        listeTypeBouteille.add(new StringBuffer());

        fireTableRowsInserted(listeTypeBouteille.size() - 1, listeTypeBouteille.size() - 1);
    }

    public void suppressionTypeBouteille(int rowIndex) {
        Object objSupprimer = listeTypeBouteille.remove(rowIndex);

        fireTableRowsInserted(rowIndex, rowIndex);

        notify("TypeBouteille", objSupprimer);
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

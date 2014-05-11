import java.util.ArrayList;
import gestionBiere.Bouteille;

public class BouteilleModele {
    private static final long serialVersionUID = 1L;
    private final String[] entete = {"Nom breuvage", "Type", "Taille", "Type bouchon", "lienPhoto"};
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
}

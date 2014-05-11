package modele;

import java.util.ArrayList;

public class Observable {
    ArrayList<Observer> listeObserver;

    public void ajoutObserver(Observer observer) {
        listeObserver.add(observer);
    }

    private void notify(String string, Object obj) {
        for (Observer ite : listeObserver) {
            ite.notify(string, obj);
        }
    }
}

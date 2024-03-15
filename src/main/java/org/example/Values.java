package org.example;

import java.util.ArrayList;
import java.util.List;

public class Values implements Observed {
    private List<Item2d> item2d = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public void setValue(List<Item2d> item2d) {
        this.item2d = item2d;
        notifyObservers();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.handleEvent(item2d);
        }
    }
}

package com.atoudeft.modele;

import java.util.ArrayList;
import java.util.List;

import observer.Observable;

/**
 * @author A. Toudeft
 * @version 1.0
 * @since 2022
 */
public class PlanDeJeu extends Observable{
    private List<Carre> carres;

    public PlanDeJeu() {
        carres = new ArrayList<>();
    }

    public void ajouter(Carre c) {
        carres.add(c);
        this.notifierObservateurs();
    }

    public List<Carre> getCarres() {
        return carres;
    }

    public void vider() {
        carres.clear();
        this.notifierObservateurs();
    }
}

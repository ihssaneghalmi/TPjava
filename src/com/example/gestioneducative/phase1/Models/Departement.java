package com.example.gestioneducative.phase1.Models;

import java.util.ArrayList;
import java.util.List;

public class Departement {
    private String intitule;
    private Enseignant responsable;
    private List<Filiere> filieres;

    @Override
    public String toString() {
        return "Departement{" +
                "intitule='" + intitule + '\'' +
                ", responsable=" + responsable +
                ", filieres=" + filieres +
                '}';
    }

    public Departement(String intitule, Enseignant responsable) {
        this.intitule = intitule;
        this.responsable = responsable;
        this.filieres = new ArrayList<>();
    }

    // Getters et setters

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getResponsable() {
        return responsable;
    }

    public void setResponsable(Enseignant responsable) {
        this.responsable = responsable;
    }

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public void ajouterFiliere(Filiere filiere) {
        filieres.add(filiere);
    }


}

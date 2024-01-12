package com.example.gestioneducative.phase1.Models;

import java.util.HashMap;
import java.util.Map;

public class Etudiant {
    private String nom;
    private String prenom;
    private String email;
    private int apogee;
    private Filiere filiere;

    public Map<Module, Double> getNotes() {
        return notes;
    }

    public void setNotes(Map<Module, Double> notes) {
        this.notes = notes;
    }

    private Map<Module, Double> notes;


    public Etudiant(String nom, String prenom, String email, int apogee, Filiere filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
        this.filiere = filiere;
        this.notes = new HashMap<>();

    }

    // Getters et setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getApogee() {
        return apogee;
    }

    public void setApogee(int apogee) {
        this.apogee = apogee;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}

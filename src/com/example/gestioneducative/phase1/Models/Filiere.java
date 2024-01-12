package com.example.gestioneducative.phase1.Models;

import java.util.ArrayList;
import java.util.List;

public class Filiere {
    private String intitule;
    private Enseignant responsable;
    private Departement departement;
    private List<Module> modules;

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    private List<Etudiant> etudiants;


    public Filiere(String intitule, Enseignant responsable, Departement departement) {
        this.intitule = intitule;
        this.responsable = responsable;
        this.departement = departement;
        this.modules = new ArrayList<>();
        this.etudiants = new ArrayList<>();
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

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public void ajouterModule(Module module) {
        modules.add(module);
    }
}

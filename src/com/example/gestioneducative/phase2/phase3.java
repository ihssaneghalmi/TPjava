package com.example.gestioneducative.phase2;

import com.example.gestioneducative.phase2.Models.Departement;
import com.example.gestioneducative.phase2.Models.Enseignant;
import com.example.gestioneducative.phase2.Models.Filiere;

import java.util.Scanner;

public class phase3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue dans le système de gestion éducative.");

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Enregistrer un département");
            System.out.println("2. Enregistrer un enseignant");
            System.out.println("3. Enregistrer une filière");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option (1-4) : ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    enregistrerDepartement();
                    break;
                case 2:
                    enregistrerEnseignant();
                    break;
                case 3:
                    enregistrerFiliere();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    System.exit(0); // Exit the program
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private static void enregistrerDepartement() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnregistrement d'un département : ");
        System.out.println("Nom du département : ");
        String nomDepartement = scanner.nextLine();

        Departement departement = new Departement();
        departement.setNom(nomDepartement);

        System.out.println("Nom du responsable : ");
        String nomEnseignant = scanner.nextLine();

        System.out.println("Prénom du responsable : ");
        String prenomEnseignant = scanner.nextLine();

        System.out.println("Email du responsable : ");
        String emailEnseignant = scanner.nextLine();

        System.out.println("Grade du responsable : ");
        String gradeEnseignant = scanner.nextLine();

        Enseignant enseignant =new Enseignant();
        enseignant.setNom(nomEnseignant);
        enseignant.setPrenom(prenomEnseignant);
        enseignant.setEmail(emailEnseignant);
        enseignant.setGrade(gradeEnseignant);

        DatabaseManager.createDepartement(departement,enseignant);
        System.out.println("Département enregistré avec succès !");
    }

    private static void enregistrerEnseignant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnregistrement d'un enseignant : ");
        System.out.println("Nom de l'enseignant : ");
        String nomEnseignant = scanner.nextLine();

        System.out.println("Prénom de l'enseignant : ");
        String prenomEnseignant = scanner.nextLine();

        System.out.println("Email de l'enseignant : ");
        String emailEnseignant = scanner.nextLine();

        System.out.println("Grade de l'enseignant : ");
        String gradeEnseignant = scanner.nextLine();

        // Display available departments for the user to choose
        DatabaseManager.afficherDepartements();

        System.out.println("Choisissez le numéro du département pour l'enseignant : ");
        int choixDepartement = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Retrieve the chosen department
        Departement departement = DatabaseManager.getDepartementById(choixDepartement);

        // Create the teacher with the chosen department
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(nomEnseignant);
        enseignant.setPrenom(prenomEnseignant);
        enseignant.setEmail(emailEnseignant);
        enseignant.setGrade(gradeEnseignant);
        enseignant.affecterDepartement(departement);

        DatabaseManager.createEnseignant(enseignant);
        System.out.println("Enseignant enregistré avec succès !");
    }


    private static void enregistrerFiliere() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnregistrement d'une filière : ");
        System.out.println("Nom de la filière : ");
        String nomFiliere = scanner.nextLine();

        // Retrieve existing Departements for the user to choose
        System.out.println("Liste des départements disponibles : ");
        DatabaseManager.afficherDepartements();

        System.out.println("Choisissez le numéro du département pour la filière : ");
        int choixDepartement = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        // Retrieve the chosen Departement
        Departement departement = DatabaseManager.getDepartementById(choixDepartement);

        System.out.println("Nom du responsable : ");
        String nomEnseignant = scanner.nextLine();

        System.out.println("Prénom du responsable : ");
        String prenomEnseignant = scanner.nextLine();

        System.out.println("Email du responsable : ");
        String emailEnseignant = scanner.nextLine();

        System.out.println("Grade du responsable : ");
        String gradeEnseignant = scanner.nextLine();

        Enseignant enseignant =new Enseignant();
        enseignant.setNom(nomEnseignant);
        enseignant.setPrenom(prenomEnseignant);
        enseignant.setEmail(emailEnseignant);
        enseignant.setGrade(gradeEnseignant);

        // Create Filiere in the database
        Filiere filiere = new Filiere();
        filiere.setIntitule(nomFiliere);
        filiere.setDepartement(departement);
        filiere.setResponsable(enseignant);
        DatabaseManager.createEnseignant(enseignant);
        DatabaseManager.createFiliere(filiere, departement,enseignant);

        System.out.println("Filière enregistrée avec succès !");
    }
}
package com.example.gestioneducative.phase1;
import com.example.gestioneducative.phase1.Models.Departement;
import com.example.gestioneducative.phase1.Models.Enseignant;
import com.example.gestioneducative.phase1.Models.Etudiant;
import com.example.gestioneducative.phase1.Models.Filiere;
import com.example.gestioneducative.phase1.Models.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class phase1 {
    private static List<Departement> departements = new ArrayList<>();
    private static List<Filiere> filieres = new ArrayList<>();
    private static List<Enseignant> enseignants=new ArrayList<>();
    private static List<com.example.gestioneducative.phase1.Models.Module> modules=new ArrayList<>();
    private static List<Etudiant> etudiants=new ArrayList<>();
    public static void main(String[] args) {
        Enseignant profInfo = new Enseignant("said", "sami","said@gmail.com","PH",null);
        Enseignant profMath = new Enseignant("oumaima", "nasiri","oumaima@gmail.com","PA",null);

        enseignants.add(profInfo);
        enseignants.add(profMath);

        Departement informatique = new Departement("Informatique", profInfo);
        Departement mathematiques = new Departement("Mathématiques", profMath);

        departements.add(informatique);
        departements.add(mathematiques);

        Filiere infoFiliere = new Filiere("Ingénierie Informatique", profInfo,informatique);
        Filiere mathFiliere = new Filiere("Mathématiques Appliquées", profMath,mathematiques);

        filieres.add(infoFiliere);
        filieres.add(mathFiliere);

        informatique.getFilieres().add(infoFiliere);
        mathematiques.getFilieres().add(mathFiliere);

        profInfo.setDepartement(informatique);
        profMath.setDepartement(mathematiques);

        com.example.gestioneducative.phase1.Models.Module algoModule = new com.example.gestioneducative.phase1.Models.Module("Algorithmique",mathFiliere,profMath);
        com.example.gestioneducative.phase1.Models.Module calcModule = new com.example.gestioneducative.phase1.Models.Module("Calcul Différentiel",mathFiliere,profMath);

        modules.add(algoModule);
        modules.add(calcModule);

        profInfo.getModules().add(algoModule);
        profMath.getModules().add(calcModule);

        Etudiant etudiant1 = new Etudiant("Étudiant 1","Étudiant 1","Étudiant_1@gmail.com",120, infoFiliere);
        etudiants.add(etudiant1);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Que souhaitez-vous afficher ?");
            System.out.println("1. Département");
            System.out.println("2. Enseignant");
            System.out.println("3. Étudiant");
            System.out.println("4. Module");
            System.out.println("5. Filière");

            System.out.println("Que souhaitez-vous ajouter ?");
            System.out.println("6. Département");
            System.out.println("7. Filière");
            System.out.println("8. Enseignant");
            System.out.println("9. Etudiant");
            System.out.println("10. Module");

            System.out.println("0. Quitter");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherDepartements();
                    break;
                case 2:
                    afficherEnseignants();
                    break;
                case 3:
                    afficherEtudiants();
                    break;
                case 4:
                    afficherModules();
                    break;
                case 5:
                    afficherFilieres();
                    break;
                case 6:
                    ajouterDepartement();
                    break;

                case 7:
                    ajouterFiliere();
                    break;

                case 8:
                    ajouterEnseignant();
                    break;

                case 9:
                    ajouterEtudiant();
                    break;

                case 10:
                    ajouterModule();
                    break;
                case 0:
                    System.out.println("Merci d'avoir utilisé le programme. Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }


        }

    }

    private static void afficherDepartements() {
        for (Departement departement : departements) {
            System.out.println("Nom du département: " + departement.getIntitule());

            Enseignant enseignant = departement.getResponsable();
            System.out.println("Responsable du département: " + enseignant.getNom() + " " + enseignant.getPrenom());

            System.out.println("Filières du département:");
            for (Filiere filiere : departement.getFilieres()) {
                System.out.println("  - " + filiere.getIntitule());

                System.out.println("    Modules de la filière:");
                for (com.example.gestioneducative.phase1.Models.Module module : filiere.getModules()) {
                    System.out.println("      - " + module.getIntitule());
                }

                System.out.println("    Étudiants de la filière:");
                for (Etudiant etudiant : filiere.getEtudiants()) {
                    System.out.println("      - " + etudiant.getNom() + " " + etudiant.getPrenom());
                }
            }

            System.out.println("------------------------------");
        }
    }


    private static void afficherEnseignants() {
        for (Enseignant enseignant : enseignants) {
            System.out.println("Nom de l'enseignant: " + enseignant.getNom());
            System.out.println("Prénom de l'enseignant: " + enseignant.getPrenom());

            Departement departement = enseignant.getDepartement();
            System.out.println("Département de l'enseignant: " + departement.getIntitule());

            System.out.println("Modules enseignés par l'enseignant:");
            for (com.example.gestioneducative.phase1.Models.Module module : enseignant.getModules()) {
                System.out.println("  - " + module.getIntitule());
            }

            System.out.println("------------------------------");
        }
    }


    private static void afficherEtudiants() {
        for (Etudiant etudiant : etudiants) {
            System.out.println("Nom de l'étudiant: " + etudiant.getNom());
            System.out.println("Prénom de l'étudiant: " + etudiant.getPrenom());
            System.out.println("Filière de l'étudiant: " + etudiant.getFiliere().getIntitule());


            System.out.println("------------------------------");
        }
    }


    private static void afficherModules() {
        for (com.example.gestioneducative.phase1.Models.Module module : modules) {
            System.out.println("Nom du module: " + module.getIntitule());

            Enseignant enseignant = module.getProfesseur();
            System.out.println("Enseignant du module: " + enseignant.getNom() + " " + enseignant.getPrenom());

            Filiere filiere = module.getFiliere();
            System.out.println("Filière du module: " + filiere.getIntitule());


            System.out.println("------------------------------");
        }
    }

    private static void afficherFilieres() {
        for (Filiere filiere : filieres) {
            System.out.println("Nom de la filière: " + filiere.getIntitule());

            Enseignant enseignant = filiere.getResponsable();
            System.out.println("Responsable de la filière: " + enseignant.getNom() + " " + enseignant.getPrenom());


            System.out.println("------------------------------");
        }
    }

    private static void ajouterDepartement() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom du département : ");
        String nomDepartement = scanner.nextLine();

        System.out.println("Nom du responsable du département : ");
        String nomEnseignant = scanner.nextLine();

        System.out.println("Prénom du responsable du département : ");
        String prenomEnseignant = scanner.nextLine();

        System.out.println("Email du responsable du département : ");
        String emailEnseignant = scanner.nextLine();

        System.out.println("Grade du responsable du département : ");
        String gradeEnseignant = scanner.nextLine();


        Enseignant enseignant = new Enseignant(nomEnseignant, prenomEnseignant, emailEnseignant, gradeEnseignant, null);
        Departement nouveauDepartement = new Departement(nomDepartement, enseignant);
        enseignant.setDepartement(nouveauDepartement);

        // Ajouter le nouveau département à la liste
        departements.add(nouveauDepartement);
        enseignants.add(enseignant);

        System.out.println("Le département a été ajouté avec succès !");
    }

    private static void ajouterFiliere() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisir le départements : ");
        for (int i = 0; i < departements.size(); i++) {
            System.out.println((i + 1) + ". " + departements.get(i).getIntitule());
        }

        System.out.println("Choisissez le numéro du département où vous souhaitez ajouter la filière : ");
        int choixDepartement = scanner.nextInt();

        Departement departementSelectionne = departements.get(choixDepartement - 1);

        System.out.println("Nom de la filière : ");
        scanner.nextLine();
        String nomFiliere = scanner.nextLine();

        System.out.println("Nom du responsable de la filière : ");
        String nomEnseignant = scanner.nextLine();

        System.out.println("Prénom du responsable de la filière : ");
        String prenomEnseignant = scanner.nextLine();

        System.out.println("Email du responsable de la filière : ");
        String emailEnseignant = scanner.nextLine();

        System.out.println("Grade du responsable de la filière : ");
        String gradeEnseignant = scanner.nextLine();

        Enseignant enseignant = new Enseignant(nomEnseignant, prenomEnseignant, emailEnseignant, gradeEnseignant, departementSelectionne);
        Filiere nouvelleFiliere = new Filiere(nomFiliere, enseignant, departementSelectionne);

        departementSelectionne.getFilieres().add(nouvelleFiliere);

        enseignants.add(enseignant);
        filieres.add(nouvelleFiliere);

        System.out.println("La filière a été ajoutée avec succès au département " + departementSelectionne.getIntitule() + " !");
    }

    private static Departement choisirDepartement() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Départements disponibles : ");
        for (int i = 0; i < departements.size(); i++) {
            System.out.println((i + 1) + ". " + departements.get(i).getIntitule());
        }

        System.out.println("Choisissez le numéro du département : ");
        int choixDepartement = scanner.nextInt();

        if (choixDepartement >= 1 && choixDepartement <= departements.size()) {
            return departements.get(choixDepartement - 1);
        } else {
            System.out.println("Choix invalide. Veuillez choisir un numéro de département valide.");
            return choisirDepartement(); // Recursive call to choose again
        }
    }

    private static void ajouterEnseignant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom de l'enseignant : ");
        String nomEnseignant = scanner.nextLine();

        System.out.println("Prénom de l'enseignant : ");
        String prenomEnseignant = scanner.nextLine();

        System.out.println("Email de l'enseignant : ");
        String emailEnseignant = scanner.nextLine();

        System.out.println("Grade de l'enseignant : ");
        String gradeEnseignant = scanner.nextLine();

        Departement departementSelectionne = choisirDepartement();

        Enseignant nouvelEnseignant = new Enseignant(nomEnseignant, prenomEnseignant, emailEnseignant, gradeEnseignant, departementSelectionne);

        enseignants.add(nouvelEnseignant);

        System.out.println("L'enseignant a été ajouté avec succès !");
    }

    private static Filiere choisirFiliere() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Filieres disponibles : ");
        for (int i = 0; i < filieres.size(); i++) {
            System.out.println((i + 1) + ". " + filieres.get(i).getIntitule());
        }

        System.out.println("Choisissez le numéro de la filière : ");
        int choixFiliere = scanner.nextInt();

        // Validate the user's input
        if (choixFiliere >= 1 && choixFiliere <= filieres.size()) {
            return filieres.get(choixFiliere - 1);
        } else {
            System.out.println("Choix invalide. Veuillez choisir un numéro de filière valide.");
            return choisirFiliere(); // Recursive call to choose again
        }
    }
    private static void ajouterEtudiant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom de l'étudiant : ");
        String nomEtudiant = scanner.nextLine();

        System.out.println("Prénom de l'étudiant : ");
        String prenomEtudiant = scanner.nextLine();

        System.out.println("Email de l'étudiant : ");
        String emailEtudiant = scanner.nextLine();

        System.out.println("Numéro apogé : ");
        int numeroEtudiant = scanner.nextInt();

        Filiere filiereSelectionnee = choisirFiliere();

        Etudiant nouvelEtudiant = new Etudiant(nomEtudiant, prenomEtudiant, emailEtudiant, numeroEtudiant, filiereSelectionnee);

        filiereSelectionnee.getEtudiants().add(nouvelEtudiant);

        etudiants.add(nouvelEtudiant);

        System.out.println("L'étudiant a été ajouté avec succès à la filière " + filiereSelectionnee.getIntitule() + " !");
    }

    private static Enseignant choisirEnseignant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enseignants disponibles : ");
        for (int i = 0; i < enseignants.size(); i++) {
            System.out.println((i + 1) + ". " + enseignants.get(i).getNom() + " " + enseignants.get(i).getPrenom());
        }

        System.out.println("Choisissez le numéro de l'enseignant : ");
        int choixEnseignant = scanner.nextInt();

        // Validate the user's input
        if (choixEnseignant >= 1 && choixEnseignant <= enseignants.size()) {
            return enseignants.get(choixEnseignant - 1);
        } else {
            System.out.println("Choix invalide. Veuillez choisir un numéro d'enseignant valide.");
            return choisirEnseignant(); // Recursive call to choose again
        }
    }

    private static void ajouterModule() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom du module : ");
        String nomModule = scanner.nextLine();

        Filiere filiereSelectionnee = choisirFiliere();

        Enseignant enseignantSelectionne = choisirEnseignant();

        com.example.gestioneducative.phase1.Models.Module nouveauModule = new Module(nomModule, filiereSelectionnee, enseignantSelectionne);

        filiereSelectionnee.getModules().add(nouveauModule);

        modules.add(nouveauModule);

        System.out.println("Le module a été ajouté avec succès à la filière " + filiereSelectionnee.getIntitule() + " !");
    }

}


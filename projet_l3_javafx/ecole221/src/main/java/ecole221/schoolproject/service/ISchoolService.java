package ecole221.schoolproject.service;

import java.util.ArrayList;

import ecole221.schoolproject.entites.Classe;
import ecole221.schoolproject.entites.Etudiant;
import ecole221.schoolproject.entites.Professeur;
import ecole221.schoolproject.entites.User;

public interface ISchoolService {
    public Classe ajouterClasse(Classe classe);
    public ArrayList <Classe> listerClasse();
    public ArrayList <Professeur> listerProf();
    public Professeur ajouterProf(Professeur prof,String libelle);
    public Etudiant inscrireEtudiant(Etudiant etudiant,Classe classe,String date);
    public Etudiant reInscrireEtudiant(Etudiant etudiant,Classe classe,String date);
    public ArrayList <Etudiant> listerEtudiant();
    public ArrayList <Classe> listerClassesUnProf(Professeur professeur);
    public ArrayList<Etudiant> filtrerEtudiantsParAn(String year);
    public ArrayList <Etudiant> filterEtudiantsParClasse(Classe classe);
    public User connexion(String login, String password);
}

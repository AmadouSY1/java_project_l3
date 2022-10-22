package ecole221.schoolproject.dao;

import java.util.ArrayList;

import ecole221.schoolproject.entites.Classe;
import ecole221.schoolproject.entites.Etudiant;

public interface IEtudiantRepository {

    public Etudiant insert(Etudiant etudiant);
    public ArrayList<Etudiant> findAll();
    public Etudiant findEtudiantByMatricule(String matricule);
    public ArrayList <Etudiant> filterEtudiantsByClasse(Classe classe);
    public ArrayList <Etudiant> filterEtudiantsByYear(String year);
}

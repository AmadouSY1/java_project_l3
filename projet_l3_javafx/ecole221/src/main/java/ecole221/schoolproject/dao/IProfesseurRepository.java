package ecole221.schoolproject.dao;

import java.util.ArrayList;

import ecole221.schoolproject.entites.Classe;
import ecole221.schoolproject.entites.Professeur;

public interface IProfesseurRepository {
    public Professeur insert(Professeur prof,Classe classe);
    public ArrayList<Professeur> findALL();
    public Professeur findProfByNci(String nci);
    public Professeur findProfById(Professeur professeur);
    public ArrayList <Classe> filterClassesProf(Professeur professeur);
}

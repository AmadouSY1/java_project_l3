package ecole221.schoolproject.dao;

import ecole221.schoolproject.entites.Classe;
import ecole221.schoolproject.entites.Etudiant;

public interface IInscriptionRepository {
    public Etudiant insert(Etudiant etudiant,Classe classe,String date);
}

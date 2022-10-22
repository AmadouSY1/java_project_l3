package ecole221.schoolproject.dao;

import java.util.ArrayList;

import ecole221.schoolproject.entites.Classe;

public interface IClasseRepository {
    public Classe insert(Classe classe);
    public ArrayList<Classe> findAll();
    public Classe findClassByLibelle(String libelle);
    public Classe findClassById(int id);
}

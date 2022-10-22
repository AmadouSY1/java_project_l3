package ecole221.schoolproject.entites;

import java.util.ArrayList;

public class Classe {

    private int id;
    private String libelle;
    ArrayList <Inscription> inscriptions=new ArrayList<>();
    ArrayList <Professeur> professeurs=new ArrayList<>();


    @Override
    public String toString() {
        return "Classe [libelle=" + libelle + "]";
    }
    

    public Classe(String libelle) {
        this.libelle = libelle;
    }

    
    public Classe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

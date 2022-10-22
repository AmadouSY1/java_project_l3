package ecole221.schoolproject.entites;

import java.util.ArrayList;

public class Etudiant {
    private int id;
    private String matricule;
    private String nomComplet;
    private String tuteur;
    ArrayList <Inscription> inscriptions=new ArrayList<>();
    Classe classe;



    public Etudiant(String matricule,String nom,String tuteur) {
        this.matricule=matricule;
        this.nomComplet=nom;
        this.tuteur=tuteur;
    }


    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getTuteur() {
        return tuteur;
    }
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    public ArrayList<Inscription> getInscriptions() {
        return inscriptions;
    }
    
    public Classe getClasse() {
        return classe;
    }


    public void setClasse(Classe classe) {
        this.classe = classe;
    }

     
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Etudiant [matricule=" + matricule + ", nomComplet=" + nomComplet + ", tuteur=" + tuteur + "]";
    }


}

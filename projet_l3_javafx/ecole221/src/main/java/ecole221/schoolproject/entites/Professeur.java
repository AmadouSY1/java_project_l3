package ecole221.schoolproject.entites;

import java.util.ArrayList;

public class Professeur {

    private int id;
    private String nci;
    private String nomComplet;
    private String grade;
    ArrayList <Classe> classes=new ArrayList<>();


    public Professeur(int id,String nci,String nomComplet,String grade) {
      this.id=id;
      this.nci=nci;
      this.nomComplet=nomComplet;
      this.grade=grade;
    }

    

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public String getNci() {
        return nci;
    }
    public void setNci(String nci) {
        this.nci = nci;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Professeur [nci=" + nci + ", nomComplet=" + nomComplet + ", grade=" + grade + "]";
    }
}

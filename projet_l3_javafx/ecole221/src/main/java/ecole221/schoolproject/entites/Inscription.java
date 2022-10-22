package ecole221.schoolproject.entites;

public class Inscription {

    private int id ;
    private String dateInscription;
    private Etudiant etudiant;
    private Classe classe;
    

    public Inscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getDateInscription() {
        return dateInscription;
    }
    
    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

 /*  public Inscription(String dateInscription) {
        this.dateInscription = this.getStringToLocalDate(dateInscription);
    }
 */
    /* public Inscription(int id, String dateInscription) {
        this.id = id;
        this.dateInscription = this.getStringToLocalDate(dateInscription);
    } */

    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    public Etudiant getEtudiant() {
        return etudiant;
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Inscription [dateInscription=" + dateInscription + "]";
    }
}

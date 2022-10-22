package ecole221.schoolproject.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecole221.schoolproject.core.DataBase;
import ecole221.schoolproject.entites.Classe;
import ecole221.schoolproject.entites.Etudiant;
import ecole221.schoolproject.entites.Inscription;

public class InscriptionRepository extends DataBase implements IInscriptionRepository{

   // public final String SQL_INSERT_ETUDIANT="INSERT INTO user (`login`, `password`, `nomcomplet`, `matricule`, `tuteur`, `role`) VALUES (?, ?, ?, ?, ?, ?)"; 
    public final String SQL_INSERT_INSCRIPTION="INSERT INTO inscription (`id`, `date`, `etudiant_id`, `classe_id`) VALUES (NULL,?,?,?)";
    
    @Override
    public Etudiant insert(Etudiant etudiant,Classe classe,String date) {
        this.OpenConnexion(); 
        Inscription inscription=new Inscription(date);
        try {
            state=conn.prepareStatement(SQL_INSERT_INSCRIPTION,PreparedStatement.RETURN_GENERATED_KEYS);
            state.setString(1,inscription.getDateInscription());
            state.setInt(2,etudiant.getId());
            state.setInt(3,classe.getId());
            state.executeUpdate();
            result=state.getGeneratedKeys();
            if(result.next())
                inscription.setId(result.getInt(1));
                etudiant.setClasse(classe);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.CloseConnexion();
        return etudiant;
    
    }
    
}

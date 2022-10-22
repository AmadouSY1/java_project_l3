package ecole221.schoolproject.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ecole221.schoolproject.core.DataBase;
import ecole221.schoolproject.entites.Classe;
import ecole221.schoolproject.entites.Professeur;

public class ProfesseurRepository extends DataBase implements IProfesseurRepository {
    ArrayList <Professeur> professeurs=new ArrayList<>();
    public final String SQL_INSERT_PROFESSEUR="INSERT INTO professeur (`grade`, `nci`, `nomcomplet`) VALUES (?,?,?)";
    public final String SQL_FIND_PROF_BY_NCI="SELECT from professeur where nci=?";
    public final String SQL_SELECT_ALL="SELECT * from professeur";
    public final String SQL_FIND_PROF_BY_ID="select from professeur where id=?";
    public final String SQL_FIND_CLASSES_PROF="select cl * from classe cl,professeur_classe pcl where pcl.professeur_id=? and cl.id=pcl.id";


    @Override
    public Professeur insert(Professeur prof,Classe classe) {
        this.OpenConnexion(); 
        try {
            state=conn.prepareStatement(SQL_INSERT_PROFESSEUR,PreparedStatement.RETURN_GENERATED_KEYS);
            state.setString(2,prof.getNci());
            state.setString(3,prof.getNomComplet());
            state.setString(1,prof.getGrade());

            state.executeUpdate();
            result=state.getGeneratedKeys();
            if(result.next())
                prof.setId(result.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.CloseConnexion();
        professeurs.add(prof);       
        return prof;
    }

    @Override
    public ArrayList<Professeur> findALL() {
     
        this.OpenConnexion();
        try {
            Professeur prof;
         state=conn.prepareStatement(SQL_SELECT_ALL);
        result=state.executeQuery();
        while(result.next()){
            prof=new Professeur(result.getInt(1),result.getString("nci"),
             result.getString("nomcomplet"),result.getString("grade"));
             professeurs.add(prof);
            }         
                   
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
        return professeurs;
    }


    @Override
    public Professeur findProfByNci(String nci) {
        this.OpenConnexion();
        Professeur prof=null;
        try {
         state=conn.prepareStatement(SQL_FIND_PROF_BY_NCI);
         state.setString(1, nci);
        result=state.executeQuery();
        if(result.next()){
            prof=new Professeur(result.getInt(1),result.getString("nci"),
            result.getString("nomcomplet"),result.getString("grade"));
        }
                  
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
    return prof;
    }

    
    @Override
    public Professeur findProfById(Professeur prof) {
        this.OpenConnexion();
        try {
         state=conn.prepareStatement(SQL_FIND_PROF_BY_ID);
         state.setInt(1,prof.getId());
        result=state.executeQuery();
        if(result.next()){
            prof=new Professeur(result.getInt(1),result.getString("nci"),
             result.getString("nomcomplet"),result.getString("grade"));
        }
                  
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
    return prof;
    }

    
    @Override
    public ArrayList<Classe> filterClassesProf(Professeur prof) {
        this.OpenConnexion();
        Classe classe=null;
        try {
         state=conn.prepareStatement(SQL_FIND_CLASSES_PROF);
         state.setInt(1,prof.getId());
        result=state.executeQuery();
        while(result.next()){
            classe=new Classe(result.getInt("id"), result.getString("libelle"));
           prof.getClasses().add(classe); 
        }
                
                  
    } catch (SQLException e) {
        e.printStackTrace();
    }

    this.CloseConnexion();
    return prof.getClasses();
    }
}

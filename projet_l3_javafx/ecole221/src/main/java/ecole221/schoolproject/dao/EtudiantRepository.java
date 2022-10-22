package ecole221.schoolproject.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ecole221.schoolproject.core.DataBase;
import ecole221.schoolproject.entites.Classe;
import ecole221.schoolproject.entites.Etudiant;

public class EtudiantRepository extends DataBase implements IEtudiantRepository{
ArrayList <Etudiant> etudiants=new ArrayList<>();
public final String SQL_INSERT_ETUDIANT="INSERT INTO etudiant (`id`, `nomcomplet`, `tuteur`, `matricule`) VALUES (NULL,?,?,?)"; 
public final String SQL_SELECT_ALL="SELECT from etudiant";
public final String SQL_FILTER_ETUDIANTS_BY_CLASSE="SELECT et.* from etudiant et,classe cl where cl.id=?";
public final String SQL_FILTER_BY_YEAR="SELECT et.* from etudiant et,inscription ins where et.id=ins.etudiant_id and date like ? ";
    
    @Override
    public Etudiant insert(Etudiant etudiant) {
        this.OpenConnexion(); 
        try {
            state=conn.prepareStatement(SQL_INSERT_ETUDIANT,PreparedStatement.RETURN_GENERATED_KEYS);
            state.setString(1,etudiant.getNomComplet());
            state.setString(3,etudiant.getMatricule());
            state.setString(2,etudiant.getTuteur());
            state.executeUpdate();
            result=state.getGeneratedKeys();
            if(result.next())
                etudiant.setId(result.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.CloseConnexion();
        etudiants.add(etudiant);       
        return etudiant;
    }

    @Override
    public ArrayList<Etudiant> findAll() {
        this.OpenConnexion();
        try {
            Etudiant etudiant;
         state=conn.prepareStatement(SQL_SELECT_ALL);
         state.setString(1,"ROLE_ETUDIANT");
        result=state.executeQuery();
        while(result.next()){
            etudiant=new Etudiant(result.getString("matricule"),
            result.getString("nomcomplet"),result.getString("tuteur"));
             etudiants.add(etudiant);
            }         
                   
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
        return etudiants;
    }

    @Override
    public Etudiant findEtudiantByMatricule(String matricule) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Etudiant> filterEtudiantsByClasse(Classe classe) {
        this.OpenConnexion();
        ArrayList <Etudiant> etudiantsCl=new ArrayList<>();
        try {
            Etudiant etudiant;
         state=conn.prepareStatement(SQL_FILTER_ETUDIANTS_BY_CLASSE);
         state.setInt(1,classe.getId());
        result=state.executeQuery();
        while(result.next()){
            etudiant=new Etudiant(result.getString("matricule"),
            result.getString("nomcomplet"),result.getString("tuteur"));
             etudiantsCl.add(etudiant);
            }         
                   
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
        return etudiantsCl;
    }

    @Override
    public ArrayList<Etudiant> filterEtudiantsByYear(String year) {
        ArrayList <Etudiant> etudiantsAn=new ArrayList<>();
        this.OpenConnexion();
        try {
         state=conn.prepareStatement(SQL_FILTER_BY_YEAR);
         state.setString(1, year);
        result=state.executeQuery();
        while(result.next()){
            Etudiant etudiant=new Etudiant(result.getString("matricule"),result.getString("nom"), result.getString("tuteur"));
            etudiantsAn.add(etudiant); 
        }
                  
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
        return etudiantsAn;
    }
    
}

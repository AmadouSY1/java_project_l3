package ecole221.schoolproject.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ecole221.schoolproject.core.DataBase;
import ecole221.schoolproject.entites.Classe;

public class ClasseRepository extends DataBase implements IClasseRepository{
    ArrayList <Classe> classes=new ArrayList<>();

    public final String SQL_INSERT_CLASS="INSERT INTO classe (id, libelle) VALUES (NULL,?)";
    public final String SQL_SELECT_ALL_CLASS="SELECT * from classe";
    public final String SQL_FIND_CLASS_BY_LIBELLE="SELECT from classe where libelle like ?";
    public final String SQL_FIND_CLASS_BY_ID="SELECT from classe where id=?";

    IProfesseurRepository professeurRepository;
    

    @Override
    public Classe insert(Classe classe) {
       this.OpenConnexion(); 
        try {
            state=conn.prepareStatement(SQL_INSERT_CLASS,PreparedStatement.RETURN_GENERATED_KEYS);
            state.setString(1,classe.getLibelle());
            state.executeUpdate();
            result=state.getGeneratedKeys();
            if(result.next())
                classe.setId(result.getInt(1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        this.CloseConnexion();
        classes.add(classe);       
        return classe;
    }

    @Override
    public ArrayList<Classe> findAll() {
        this.OpenConnexion();
        try {
            Classe classe;
         state=conn.prepareStatement(SQL_SELECT_ALL_CLASS);
        result=state.executeQuery();
        while(result.next()){
            classe=new Classe(result.getInt(1),
             result.getString(2));
             classes.add(classe);
            }         
                   
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
        return classes;
    }

    @Override
    public Classe findClassByLibelle(String libelle) {
        this.OpenConnexion();
        Classe classe=null;
        try {
         state=conn.prepareStatement(SQL_FIND_CLASS_BY_LIBELLE);
         state.setString(1,libelle);
        result=state.executeQuery();
        if(result.next()){
            classe=new Classe(result.getInt("id"), result.getString("libelle"));
        }
                  
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
    return classe;
    }

    @Override
    public Classe findClassById(int id) {
        this.OpenConnexion();
        Classe classe=null;
        try {
         state=conn.prepareStatement(SQL_FIND_CLASS_BY_ID);
         state.setInt(1,id);
        result=state.executeQuery();
        if(result.next()){
            classe=new Classe(result.getInt("id"), result.getString("libelle"));
        }
                  
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
    return classe;
    }

}


package ecole221.schoolproject.dao;

import java.sql.SQLException;

import ecole221.schoolproject.core.DataBase;
import ecole221.schoolproject.entites.User;

public class UserRepository extends DataBase implements IUserRepository{

    private final String SQL_SELECT_LOGIN_PASSWORD="SELECT * FROM user WHERE login LIKE ? AND password LIKE ?";
    
    @Override
    public User selectUserByLoginAndPassword(String login, String password) {
        User user=null;
        this.OpenConnexion();
        try {
         state=conn.prepareStatement(SQL_SELECT_LOGIN_PASSWORD);
         state.setString(1, login);
         state.setString(2, password);
        result=state.executeQuery();
        if(result.next()){
            user=new User(result.getString("login"),
            result.getString("password"));
            }         
                   
    } catch (SQLException e) {
        e.printStackTrace();
    }
    this.CloseConnexion();
    return user;
    }
    
}

package ecole221.schoolproject.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBase implements IDataBase {
    protected Connection conn;
    protected PreparedStatement state;
    protected ResultSet result;

    @Override
    public void CloseConnexion() {
        if(conn!=null){
            try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    @Override
    public void OpenConnexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_projet_l3","root","");
        } catch (ClassNotFoundException | SQLException e) {
           System.out.println(e.getMessage());
           }        
    }

    
}

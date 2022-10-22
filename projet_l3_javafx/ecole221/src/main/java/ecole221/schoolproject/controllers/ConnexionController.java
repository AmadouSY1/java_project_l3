package ecole221.schoolproject.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ecole221.schoolproject.App;
import ecole221.schoolproject.core.Fabrique;
import ecole221.schoolproject.entites.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ConnexionController implements Initializable {

    
    @FXML
    Text lblErrors;
    @FXML
    TextField txtLogin;
    @FXML
    PasswordField txtPassword;


   

    public void handleConnexion() throws IOException{
        String login=txtLogin.getText().trim();
        String password=txtPassword.getText().trim();

        User user=Fabrique.getService().connexion(login, password);
        if (user==null) {
            lblErrors.setVisible(true);
        }else{
            lblErrors.setVisible(false);
            App.setRoot("home");
        }
    }




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        lblErrors.setVisible(false);
        
    }
}
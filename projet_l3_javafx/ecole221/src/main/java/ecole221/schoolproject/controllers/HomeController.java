package ecole221.schoolproject.controllers;

import java.io.IOException;

import ecole221.schoolproject.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HomeController {

    @FXML
    AnchorPane anchorContent;

    @FXML
    void handleDeconnexion(ActionEvent event) throws IOException {
        App.setRoot("connexion");
    }

    @FXML
    void handleLoadViewClasse(ActionEvent event) throws IOException {
        loadView("classe");
    }

    @FXML
    void handleLoadViewEtudiant(ActionEvent event) throws IOException {
       loadView("etudiant");
    }

    @FXML
    void handleLoadViewProfesseur(ActionEvent event) throws IOException {
       loadView("professeur");
    }

    void loadView(String fxml) throws IOException{
        AnchorPane root= (AnchorPane) App.loadFXML(fxml);
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);
    }
}

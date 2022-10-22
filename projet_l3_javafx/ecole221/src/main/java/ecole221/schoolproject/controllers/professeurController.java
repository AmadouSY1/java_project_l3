package ecole221.schoolproject.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ecole221.schoolproject.core.Fabrique;
import ecole221.schoolproject.entites.Professeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class professeurController implements Initializable {

    @FXML
    private TableColumn<Professeur, String> tblcGrade;

    @FXML
    private TableColumn<Professeur, String> tblcId;

    @FXML
    private TableColumn<Professeur, String> tblcNci;

    @FXML
    private TableColumn<Professeur, String> tblcNomComplet;

    @FXML
    private TableView<Professeur> tblvProfesseur;

    ObservableList professeurs =FXCollections.observableList(Fabrique.getService().listerProf());

    public void handleListerProfesseur() {
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));
        tblcNomComplet.setCellValueFactory(new PropertyValueFactory<>("nomcomplet"));
        tblcNci.setCellValueFactory(new PropertyValueFactory<>("nci"));
        tblvProfesseur.setItems(professeurs);
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        handleListerProfesseur();
    }
}

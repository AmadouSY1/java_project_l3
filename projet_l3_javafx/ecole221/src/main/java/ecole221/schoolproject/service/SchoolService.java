package ecole221.schoolproject.service;

import java.util.ArrayList;

import ecole221.schoolproject.dao.IClasseRepository;
import ecole221.schoolproject.dao.IEtudiantRepository;
import ecole221.schoolproject.dao.IInscriptionRepository;
import ecole221.schoolproject.dao.IProfesseurRepository;
import ecole221.schoolproject.dao.IUserRepository;
import ecole221.schoolproject.entites.Classe;
import ecole221.schoolproject.entites.Etudiant;
import ecole221.schoolproject.entites.Professeur;
import ecole221.schoolproject.entites.User;

public class SchoolService implements ISchoolService{
    IEtudiantRepository etudiantRepository;
    IProfesseurRepository professeurRepository;
    IClasseRepository classeRepository;
    IInscriptionRepository inscriptionRepository;
    IUserRepository userRepository;
    
    public SchoolService(IEtudiantRepository etudiantRepository, IProfesseurRepository professeurRepository,
            IClasseRepository classeRepository, IInscriptionRepository inscriptionRepository,IUserRepository userRepository) {
        this.etudiantRepository = etudiantRepository;
        this.userRepository=userRepository;
 
        this.professeurRepository = professeurRepository;
        this.classeRepository = classeRepository;
        this.inscriptionRepository = inscriptionRepository;
    }


    @Override
    public Classe ajouterClasse(Classe classe) {
        return classeRepository.insert(classe); 
    }

    @Override
    public ArrayList<Classe> listerClasse() {
       return classeRepository.findAll();
    }

    @Override
    public ArrayList<Professeur> listerProf() {
        return professeurRepository.findALL();
    }

    @Override 
    public Professeur ajouterProf(Professeur prof,String libelle) {
        Classe classe=classeRepository.findClassByLibelle(libelle);
        return professeurRepository.insert(prof,classe);
    }

    @Override
    public Etudiant inscrireEtudiant(Etudiant etudiant, Classe classe, String date) {
       etudiantRepository.insert(etudiant);
        classe=classeRepository.findClassByLibelle(classe.getLibelle());
       return inscriptionRepository.insert(etudiant, classe, date);
    }

    @Override
    public Etudiant reInscrireEtudiant(Etudiant etudiant, Classe classe, String date) {
        classe=classeRepository.findClassByLibelle(classe.getLibelle());
        return inscriptionRepository.insert(etudiant, classe, date);
    }

    @Override
    public ArrayList<Etudiant> listerEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public ArrayList<Classe> listerClassesUnProf(Professeur professeur) {
        return professeurRepository.filterClassesProf(professeur);
    }

    @Override
    public ArrayList<Etudiant> filtrerEtudiantsParAn(String year) {
        return etudiantRepository.filterEtudiantsByYear(year);
    }

    @Override
    public ArrayList<Etudiant> filterEtudiantsParClasse(Classe classe) {
        return etudiantRepository.filterEtudiantsByClasse(classe);
    }


    @Override
    public User connexion(String login, String password) {
        return userRepository.selectUserByLoginAndPassword(login, password);
    }
    

}
package ecole221.schoolproject.core;

import ecole221.schoolproject.service.ISchoolService;
import ecole221.schoolproject.service.SchoolService;
import ecole221.schoolproject.dao.ClasseRepository;
import ecole221.schoolproject.dao.EtudiantRepository;
import ecole221.schoolproject.dao.IClasseRepository;
import ecole221.schoolproject.dao.IEtudiantRepository;
import ecole221.schoolproject.dao.IInscriptionRepository;
import ecole221.schoolproject.dao.IProfesseurRepository;
import ecole221.schoolproject.dao.IUserRepository;
import ecole221.schoolproject.dao.InscriptionRepository;
import ecole221.schoolproject.dao.ProfesseurRepository;
import ecole221.schoolproject.dao.UserRepository;

public class Fabrique {
    

    public static ISchoolService getService(){
        IUserRepository userRepository=new UserRepository();
        IClasseRepository classeRepository=new ClasseRepository();
        IProfesseurRepository professeurRepository=new ProfesseurRepository();
        IEtudiantRepository etudiantRepository=new EtudiantRepository();
        IInscriptionRepository inscriptionRepository=new InscriptionRepository();
        return new SchoolService(etudiantRepository, professeurRepository, classeRepository, inscriptionRepository, userRepository);
    }
}

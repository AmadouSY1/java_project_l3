package ecole221.schoolproject.entites;

public class RP extends User {

    public RP(String login, String password) {
        super(login, password);
        role=Role.ROLE_RP;
    }
    
}

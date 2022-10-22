package ecole221.schoolproject.entites;

public class AC extends User {

    public AC(String login, String password) {
        super(login, password);
       role=Role.ROLE_AC;
    }

}
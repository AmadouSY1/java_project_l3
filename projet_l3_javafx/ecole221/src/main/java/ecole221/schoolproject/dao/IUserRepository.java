package ecole221.schoolproject.dao;

import ecole221.schoolproject.entites.User;

public interface IUserRepository {
    public User selectUserByLoginAndPassword(String login,String password);
}

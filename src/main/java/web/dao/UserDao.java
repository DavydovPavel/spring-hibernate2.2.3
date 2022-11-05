package web.dao;

import web.models.Users;

import java.util.List;

public interface UserDao {

    Users getUser(long id);
    void add(Users user);
    List<Users> listUsers();
    void deleteUserByID(long id);
    void updateUserByID(Users updateUser, long id);
}

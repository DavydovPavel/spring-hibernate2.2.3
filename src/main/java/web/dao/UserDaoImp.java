package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Users> listUsers() {
        return entityManager.createQuery("FROM Users", Users.class).getResultList();
    }
    @Override
    public Users getUser(long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public void add (Users user) {
        entityManager.persist(user);
    }
    @Override
    public  void deleteUserByID(long id) {
        Users user = entityManager.find(Users.class, id);
        entityManager.remove(user);
    }
    @Override
    public void updateUserByID(Users user, long id) { entityManager.merge(user); }
}

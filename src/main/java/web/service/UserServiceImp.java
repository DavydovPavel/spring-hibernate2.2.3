package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.Users;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   public UserServiceImp(UserDao userDAO) {
      this.userDao = userDAO;
   }

   @Override
   public void add(Users user) {
      userDao.add(user);
   }
   @Override
   public List<Users> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public void deleteUserByID(long id) {
      userDao.deleteUserByID(id);
   }

   @Override
   public Users getUser(long id) {
      return userDao.getUser(id);
   }
   @Override
   public void updateUserByID(Users user, long id) {
      userDao.updateUserByID(user, id);
   }

}

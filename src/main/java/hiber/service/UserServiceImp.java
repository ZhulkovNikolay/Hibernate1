package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;
   @Autowired
   private Car car;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public void add(User user, Car car) {
      userDao.addCar(user, car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public Car findCarById(Long id) {
      return userDao.findCarByID(id);
   }

   @Override
   public User getUserByCar(Car car) {
      return userDao.getUserByCar(car);
   }

}

package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public void addCar(User user, Car car) {
      user.setCar(car);
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public Car findCarByID(Long id) {
      String hql ="SELECT car FROM Car car where car.id = :id";
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("id", id);
      return (Car) ((org.hibernate.query.Query<?>) query).uniqueResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCar(Car car) {
      String hql = "SELECT user FROM User user INNER JOIN user.car car WHERE car.model = :model AND car.series= :series";
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("model", car.getModel());
      query.setParameter("series", car.getSeries());
      return (User) ((org.hibernate.query.Query<?>) query).uniqueResult();
   }

}

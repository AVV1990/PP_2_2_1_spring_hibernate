package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);
   }

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().persist(car);
   }

   @Override
   public List<User> listUsers() {
      return sessionFactory.getCurrentSession().createQuery("select u from User u", User.class).getResultList();
   }

   @Override
   public List<Car> listCars() {
      return sessionFactory.getCurrentSession().createQuery("select c from Car c", Car.class).getResultList();
   }

   @Override
   public User findUserByCar(String model, int series) {
      return sessionFactory.getCurrentSession().createQuery("select u from User u where u.car.model = :model and u.car.series =  :series", User.class)
              .setParameter("model", model)
              .setParameter("series", series)
              .getSingleResult();
   }


}

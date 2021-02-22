package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
   //   userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("Tesla", 3));
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("ЛадаСедан", 0));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"), new Car("AudiQ", 3));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"), new Car("InfinitiFX", 35));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Model = "+userService.findCarById(user.getId()).getModel());
//         System.out.println("Serial = "+userService.findCarById(user.getId()).getSeries());
//         System.out.println("-----");
//      }
//
      Car car = new Car("test",0);
      System.out.println("User = " + userService.getUserByCar(car).toString());
//
      context.close();
   }
}

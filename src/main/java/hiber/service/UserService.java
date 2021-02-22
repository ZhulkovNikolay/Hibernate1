package hiber.service;

import hiber.model.User;
import hiber.model.Car;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserService {
    void add(User user);

    List<User> listUsers();

    void add(User user, Car car);

    Car findCarById(Long id);

    User getUserByCar(Car car);
}

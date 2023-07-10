package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        User user1 = new User("Петя", "Иванов", "user1@mail.ru");
        User user2 = new User("Саша", "Петров", "user2@mail.ru");
        User user3 = new User("Сережа", "Ласточкин", "user3@mail.ru");
        User user4 = new User("Кирилл", "Сидоров", "user4@mail.ru");

        Car car1 = new Car("model1", 1, user1);
        Car car2 = new Car("model2", 2, user3);
        Car car3 = new Car("model3", 3, user4);
        Car car4 = new Car("model4", 4, user2);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        CarService carService = context.getBean(CarService.class);
        carService.add(car1);
        carService.add(car2);
        carService.add(car3);
        carService.add(car4);

        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println(user.getCar());
            System.out.println();
        }

        List<Car> cars = carService.getCars();
        for (Car car : cars) {
            System.out.println(car.getUser());
        }

        System.out.println(userService.findUserByCar("model4", 4));

        context.close();
    }
}

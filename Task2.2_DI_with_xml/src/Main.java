import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = (Car) context.getBean("car");
        Plane plane = (Plane) context.getBean("plane");

        car.saveIntoDatabase();
        plane.saveIntoDatabase();

    }
}
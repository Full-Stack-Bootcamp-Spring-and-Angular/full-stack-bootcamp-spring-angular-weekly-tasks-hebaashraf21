import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle circle = (Circle) context.getBean("circle");
        Square square = (Square) context.getBean("square");

        System.out.println("The area of the circle = " + circle.getArea());
        System.out.println("The area of the square = " + square.getArea());
    }
}
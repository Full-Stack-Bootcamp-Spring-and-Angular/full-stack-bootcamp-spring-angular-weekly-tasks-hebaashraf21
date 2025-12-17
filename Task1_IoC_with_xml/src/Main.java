import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle circle = (Circle) context.getBean("circle");
        Square square = (Square) context.getBean("square");

        System.out.println(String.format("The area of the circle = %f" , circle.getArea()));
        System.out.println(String.format("The area of the square = %f" , square.getArea()));
    }
}
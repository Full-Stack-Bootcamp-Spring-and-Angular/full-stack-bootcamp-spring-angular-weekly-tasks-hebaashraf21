import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Circle circle1 = (Circle) context.getBean("circle");
        Circle circle2 = (Circle) context.getBean("circle");

        System.out.println(circle1);
        System.out.println(circle2);

        Square square1 = (Square) context.getBean("square");
        Square square2 = (Square) context.getBean("square");

        System.out.println(square1);
        System.out.println(square2);

        circle1.drawShape();
        square1.drawShape();
    }
}
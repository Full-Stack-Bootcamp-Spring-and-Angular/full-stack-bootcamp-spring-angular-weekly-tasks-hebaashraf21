import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.BikeController;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.controller.PlaneController;
import com.vehiclesSystem.controller.VehicleController;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Plane;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);


        Car car = context.getBean(Car.class);
        Plane plane = context.getBean(Plane.class);
        Bike bike = context.getBean(Bike.class);


        car.setId(209);
        car.setModel("Toyota");

        plane.setId(309);
        plane.setModel("p4");

        bike.setId(409);
        bike.setModel("b4");


        VehicleController<Car> carController = context.getBean(CarController.class);

        VehicleController<Plane> planeController = context.getBean(PlaneController.class);

        VehicleController<Bike> bikeController = context.getBean(BikeController.class);


        System.out.println("---- SAVE ----");
        carController.save(car);
        planeController.save(plane);
        bikeController.save(bike);


        System.out.println("---- GET ALL ----");
        System.out.println("---- Cars ----");
        carController.getAll().forEach(System.out::println);
        System.out.println("---- Planes ----");
        planeController.getAll().forEach(System.out::println);
        System.out.println("---- Bikes ----");
        bikeController.getAll().forEach(System.out::println);


        System.out.println("---- UPDATE ----");
        car.setModel("C100");
        carController.update(car);

        plane.setModel("P100");
        planeController.update(plane);

        bike.setModel("B100");
        bikeController.update(bike);


        System.out.println("---- GET BY ID ----");
        System.out.println(carController.searchById(209));
        System.out.println(planeController.searchById(309));
        System.out.println(bikeController.searchById(409));


        System.out.println("---- DELETE ----");
        carController.delete(206);
        planeController.delete(306);
        bikeController.delete(406);

        System.out.println("---- GET ALL AGAIN----");
        System.out.println("---- Cars ----");
        carController.getAll().forEach(System.out::println);
        System.out.println("---- Planes ----");
        planeController.getAll().forEach(System.out::println);
        System.out.println("---- Bikes ----");
        bikeController.getAll().forEach(System.out::println);

        context.close();
    }
}

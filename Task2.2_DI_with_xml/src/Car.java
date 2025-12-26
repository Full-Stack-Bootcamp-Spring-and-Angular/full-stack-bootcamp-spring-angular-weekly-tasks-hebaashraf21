public class Car implements Vehicle{

    DatabaseOperations databaseOperations;
    String carBrand;

    public Car(DatabaseOperations databaseOperations, String carBrand)
    {
        this.databaseOperations = databaseOperations;
        this.carBrand = carBrand;
    }

    @Override
    public void saveIntoDatabase() {
        databaseOperations.insert(carBrand);
    }
}

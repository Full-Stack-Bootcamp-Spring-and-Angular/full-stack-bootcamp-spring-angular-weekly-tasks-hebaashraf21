public class Plane implements Vehicle{

    DatabaseOperations databaseOperations;
    String planeBrand;

    public void setDatabaseOperations(DatabaseOperations databaseOperations)
    {
        this.databaseOperations = databaseOperations;
    }

    public void setPlaneBrand(String planeBrand)
    {
        this.planeBrand = planeBrand;
    }

    @Override
    public void saveIntoDatabase() {
        databaseOperations.insert(planeBrand);
    }
}

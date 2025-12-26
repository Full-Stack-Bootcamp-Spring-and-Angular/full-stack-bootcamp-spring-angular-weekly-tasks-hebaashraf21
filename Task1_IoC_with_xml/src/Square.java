public class Square implements Shape{

    private final double side;

    Square(double side)
    {
        this.side = side;
    }

    @Override
    public double getArea()
    {
        return side * side;
    }
}

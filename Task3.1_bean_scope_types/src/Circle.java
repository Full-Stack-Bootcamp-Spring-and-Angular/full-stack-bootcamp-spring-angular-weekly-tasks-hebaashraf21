public class Circle implements Shape{

    private final Draw2D draw2D;

    public Circle(Draw2D draw2D)
    {
        this.draw2D = draw2D;
    }

    @Override
    public void drawShape() {
        draw2D.draw("circle");
    }
}

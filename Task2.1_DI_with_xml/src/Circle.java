public class Circle implements Shape{

    Draw2D draw2D;

    public Circle(Draw2D draw2d)
    {
        this.draw2D = draw2d;
    }

    @Override
    public void drawShape()
    {
        draw2D.draw("circle");
    }

}

public class Square implements Shape{

    Draw2D draw2D;

    public void setDraw2D(Draw2D draw2d)
    {
        this.draw2D = draw2d;
    }

    @Override
    public void drawShape() {
        draw2D.draw("square");
    }
}

public class Square implements Shape {

    Draw3D draw3D;

    public void setDraw3D( Draw3D draw3D)
    {
        this.draw3D = draw3D;
    }

    @Override
    public void drawShape() {
        draw3D.draw("square");
    }
}

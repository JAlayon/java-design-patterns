package factories;

public class FactoryMethod {

    public static void main(String[] args) {
        Point point = Point.newCartesianPoint(10,20);
        Point point2 = Point.newPolarPoint(1,0.5);
    }
}

class Point{
    private double x, y;

    private Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static Point newCartesianPoint(double x, double y){
        return new Point(x,y);
    }

    public static Point newPolarPoint(double rho, double theta){
        return new Point(rho*Math.cos(theta),rho*Math.sin(theta));
    }
}

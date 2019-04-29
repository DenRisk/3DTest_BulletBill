package Sprite;

public class Vec {

    private double x;
    private double y;
    private double restoreAngle;

    public Vec(double vecX, double vecY){
        this.x = vecX;
        this.y = vecY;
        this.restoreAngle = 0.0;

    }

    public Vec(Vec v){
        this.x = v.x;
        this.y = v.y;
        this.restoreAngle = 0.0;
    }


    /**
     * Methoden aus einem anderen Programm
     */

    public double angle()
    {
        return Math.atan2(y, x);
    }

    public double mag()
    {
        return Math.sqrt((x * x) + (y * y));
    }

    public void rotateCoordinates(double tiltAngle)
    {
        this.restoreAngle += tiltAngle;
        double angle = angle();
        double mag = mag();
        angle -= tiltAngle;
        x = mag * Math.cos(angle);
        y = mag * Math.sin(angle);
    }

    public void restoreCoordinates()
    {
        double angle = angle();
        double mag = mag();
        angle += restoreAngle;
        x = mag * Math.cos(angle);
        y = mag * Math.sin(angle);
        restoreAngle = 0.0;
    }

    /**
     * Getter und Setter
     */

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

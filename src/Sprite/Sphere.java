package Sprite;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Sphere extends Circle {

    double x0;
    double y0;
    double z0;
    double vx;
    double vy;
    double vz;
    double r;
    Color color;
    double mass = 0.2;

    /**
     * Konstruktor
     */

    public Sphere(double centerX, double centerY, double centerZ, double radius, Color ccolor, double veloX, double veloY, double veloZ, int count) {

        if (count == 1) {
            setCenterX(centerX);
            setCenterY(centerY);
            setRadius(radius);
            setFill(ccolor);

            this.x0 = getCenterX();
            this.y0 = getCenterY();
            this.r = getRadius();
            this.color = ccolor;
            this.vx = veloX;
            this.vy = veloY;
        }

        if (count == 2) {
            setCenterX(centerX);
            setCenterY(centerZ);
            setRadius(radius);
            setFill(ccolor);

            this.x0 = getCenterX();
            this.z0 = getCenterY();
            this.r = getRadius();
            this.color = ccolor;
            this.vx = veloX;
            this.vz = veloZ;
        }

        if (count == 3) {
            setCenterX(centerZ);
            setCenterY(centerY);
            setRadius(radius);
            setFill(ccolor);

            this.z0 = getCenterX();
            this.y0 = getCenterY();
            this.r = getRadius();
            this.color = ccolor;
            this.vz = veloZ;
            this.vy = veloY;
        }

    }


    /**
     * Getter und Setter
     */

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
    /**
     * Using Vec for Coordinates
     */

    public Vec getPosVector() {
        return new Vec(getX0(), getY0());

    }

    public Vec getVelocityVector() {
        return new Vec(getVx(), getVy());
    }

/**
 * Update Pos and Velocity
 */

    public void updateVelocity(double vx, double vy, double vz) {
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;

    }

    public void updatePos(double newX, double newY, double newZ)
    {
        this.x0 = newX;
        this.y0 = newY;
        this.z0 = newZ;
    }

    /**
     * Z-Dim Test
     */

    public double getZ0() {
        return z0;
    }

    public void setZ0(double z0) {
        this.z0 = z0;
    }

    public double getVz() {
        return vz;
    }

    public void setVz(double vz) {
        this.vz = vz;
    }





}

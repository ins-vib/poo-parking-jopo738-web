package org.yourcompany.parking.places;

public class Coordenada {
    private double x;
    private double y;

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(')');
        return sb.toString();
    }

    



}

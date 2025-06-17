package JOUR02;


public abstract class GeometricFigure {
    private final Center center;

    public GeometricFigure(double x, double y) {
        this.center = new Center(x, y);
    }

    public abstract double area();

    public Center getCenter() {
        return this.center;
    }
}


class Center {
    private double x;
    private double y;

    public Center(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double newX) {
        this.x = newX;
    }

    public void setY(double newY) {
        this.y = newY;
    }

    public void printCenter() {
        System.out.println("Center : (" + this.x + ", " + this.y + ")" );
    }

    public void setCenter(double x, double y) {
        this.x = x;
        this.y = y;
    }
}


class Rectangle extends GeometricFigure {
    private double length;
    private double width;

    public Rectangle(double lenght, double width, double x, double y) {
        super(x, y);
        this.length = lenght;
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    public void setLength(double newLength) {
        this.length = newLength;
    }

    public void setWidth(double newWidth) {
        this.width = newWidth;
    }

    @Override
    public double area() {
        return (getLength() * getWidth());
    }
}


class RectangleColor extends Rectangle {
    private int color;

    public RectangleColor(int color,double lenght, double width, double x, double y) {
        super(lenght, width, x, y);
        this.color = color;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int newColor) {
        this.color = newColor;
    }
}


class Circle extends GeometricFigure {
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }

    @Override
    public double area() {
        return (Math.PI * Math.pow(getRadius(), 2));
    }

    public boolean isInside(double x, double y) {
        return (Math.pow(x - this.getCenter().getX(), 2) + Math.pow(y - this.getCenter().getY(), 2) <= Math.pow(getRadius(), 2));
    }
}

// do not use inheritance to model a possession relationship.
// rectangle has a center, rectangle insn't a center!

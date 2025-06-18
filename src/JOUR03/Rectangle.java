package JOUR03;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle :\n width = " + this.width + "\n height = " + this.height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.height, height) == 0;
    }
}

class ColorRectangle extends Rectangle {
    private String color;

    public ColorRectangle(double width, double height, String color) {
        super(width, height);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "\n color = " + this.color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        ColorRectangle that = (ColorRectangle) obj;
        return color != null ? color.equals(that.color) : that.color == null;
    }
}

class ToString {
    public static void main(String[] args) {
        System.out.println("Test 1 :");
        Rectangle rect = new Rectangle(12.5, 4.0);
        System.out.println(rect);
        System.out.println();

        System.out.println("Test 2 :");
        ColorRectangle rect1 = new ColorRectangle(12.5, 4.0, "rouge");
        System.out.println(rect1);
        System.out.println();

        System.out.println("Test 3 :");
        Rectangle rect2 = new ColorRectangle(12.5, 4.0, new String("rouge"));
        System.out.println(rect2);

        System.out.println(rect1.equals(rect2));
        System.out.println(rect2.equals(rect1));
        System.out.println(rect1.equals(null));
        System.out.println(rect.equals(rect1));
        System.out.println(rect1.equals(rect));
    }
}

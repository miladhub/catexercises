package cat.ch6;

public abstract class Shape {
    public abstract double area();
    public abstract double circ();
}

class Circle extends Shape {
    private final double r;

    Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public double circ() {
        return 2 * Math.PI * r;
    }
}

class Rect extends Shape {
    private final double d, h;

    Rect(double d, double h) {
        this.d = d;
        this.h = h;
    }

    @Override
    public double area() {
        return d * h;
    }

    @Override
    public double circ() {
        return 2 * (d + h);
    }
}

// Had to change all subclasses to add the circ function
// Only had to touch this to add a new shape
class Square extends Shape {
    private final double e;

    Square(double e) {
        this.e = e;
    }

    @Override
    public double area() {
        return e * e;
    }

    @Override
    public double circ() {
        return 4 * e;
    }
}

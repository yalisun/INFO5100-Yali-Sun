package Q1;

class Shape {
        protected String name;
        protected double perimeter;
        protected double area;

        public Shape() {
            this("Shape");
        }

        public Shape(String name) {
            this.name = name;
        }

        public void draw() {
            System.out.println("Drawing" + name);
        }

        public void getArea() {
            System.out.println(String.format("%.2f", area));
        }

        public void getPerimeter() {
            System.out.println(String.format("%.2f", perimeter));
        }
}

class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            super("Circle");
            this.radius = radius;
        }

        @Override
        public void getArea() {
            this.area =  Math.PI * Math.pow(radius, 2);
            super.getArea();
        }

        @Override
        public void getPerimeter() {
            this.perimeter = 2 * Math.PI * radius;
            super.getPerimeter();
        }
}

class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            super("Rectangle");
            this.width = width;
            this.height = height;
        }

        @Override
        public void getArea() {
            this.area = width * height;
            super.getArea();
        }

        @Override
        public void getPerimeter() {
            this.perimeter = (width + height) * 2;
            super.getPerimeter();
        }
}

class Square extends Shape {
        private double side;

        public Square(double side) {
            super("Square");
            this.side = side;
        }

        @Override
        public void getArea() {
            this.area = side * side;
            super.getArea();
        }

        @Override
        public void getPerimeter() {
            this.perimeter = 4 * side;
            super.getPerimeter();
        }
}

public class ShapeTester {
        public static void main(String[] args) {
            Shape s = new Shape();
            Rectangle r = new Rectangle(2.0, 3.0);
            Circle c = new Circle(4.0);
            Square sq = new Square(4.0);

            r.getArea();
            r.getPerimeter();
            c.getArea();
            c.getPerimeter();
            sq.getArea();
            sq.getPerimeter();
            r.draw();
            c.draw();
            s.draw();
            sq.draw();
        }
}
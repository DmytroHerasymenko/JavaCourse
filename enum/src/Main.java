/**
 * Created by dima on 15.02.17.
 */
enum Factories{
    TRIANGLE_FACTORY, CIRCLE_FACTORY;
}

class Factory{
    public static GeometryFigureFactory getFactory(Factories factories ){
        switch (factories){
            case TRIANGLE_FACTORY: return TriangleFactory.getInstance();
            case CIRCLE_FACTORY: return CircleFactory.getInstance();
        }
        return null;
    }
}

abstract class GeometryFigureFactory{
    public abstract Shape getShape();
}

class TriangleFactory extends GeometryFigureFactory{
    static GeometryFigureFactory instance = new TriangleFactory();
    Shape figure = new Triangle();
    public static GeometryFigureFactory getInstance(){
        return instance;
    }
    public Shape getShape(){
        return figure;
    }
}

class CircleFactory extends GeometryFigureFactory{
    static GeometryFigureFactory instance = new CircleFactory();
    public static GeometryFigureFactory getInstance(){
        return instance;
    }
    public Shape getShape(){
        return new Circle();
    }
}

abstract class Shape{
    public abstract void show();
}

class Triangle extends Shape{
    public void show(){
        System.out.println("Triangle");
    }
}

class Circle extends Shape{
    public void show(){
        System.out.println("Circle");
    }
}

public class Main {
    public static void main(String[] args) {
        GeometryFigureFactory factory = Factory.getFactory(Factories.CIRCLE_FACTORY);
        Shape product = factory.getShape();
        product.show();
    }
}

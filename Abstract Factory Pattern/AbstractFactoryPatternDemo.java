
/*Step-1: Declare a interface */
interface Shape {
    void draw();
}

/*Step-2: Implements the interface */
class RoundedRectangle implements Shape {
    public void draw() {
        System.out.println("Inside RoundedRectangle::draw() method.");
    }
}

class RoundedSquare implements Shape {
    public void draw() {
        System.out.println("Inside RoundedSquare::draw()");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Inside Rectangle::draw()");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Inside Square::draw()");
    }
}

/*Step-3: Create abstract factory */
abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}

/*Step-4: create factory class */
class ShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

class RoundedShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType){
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        }
        else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        return null;
    }
}

/*Step-5: Factory generator/producer */
class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if(rounded){
            return new RoundedShapeFactory();
        }
        else{
            return new ShapeFactory();
        }
    }
}

/*Step-6: Main class */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        //get an object of shape Rectangle
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        //call draw method of Shape Rectangle 
        shape1.draw();
        //get an object of shape Square
        Shape shape2 = shapeFactory.getShape("SQUARE");
        //call draw method of Shape Square 
        shape2.draw();
        //get chape factory 
        AbstractFactory shapeFactory2 = FactoryProducer.getFactory(true);
        Shape shape3 = shapeFactory2.getShape("RECTANGLE");
        shape3.draw();
        Shape shape4 = shapeFactory2.getShape("SQUARE");
        shape4.draw();
    }
}

package structural;

/**
 * Created by dima on 15.02.17.
 */
abstract class Element{
    abstract public void show();
}

class Picture extends Element{
    public void show(){
        System.out.println("picture");
    }
}

abstract class Decorator extends Element{
    Element element;
    public Decorator(Element element){
        this.element = element;
    }
}

class Frame extends Decorator{
    public Frame(Element element){
        super(element);
    }
    public void show(){
        element.show();
        System.out.println("frame");
    }
}

class Pattern extends Decorator{
    public Pattern(Element element){
        super(element);
    }
    public void show(){
        element.show();
        System.out.println("pattern");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Element picture = new Picture();
        Element pictureInFrame = new Frame(picture);
        pictureInFrame.show();
        Element pictureInFrameWithPattern = new Pattern(pictureInFrame);
        pictureInFrameWithPattern.show();
    }
}

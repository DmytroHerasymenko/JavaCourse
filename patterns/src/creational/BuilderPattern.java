package creational;

/**
 * Created by dima on 15.02.17.
 */
abstract class Building{
    String base;
    String wall;
    String roof;
    public abstract void setFundament(String base);
    public abstract void setWall(String wall);
    public abstract void setRoof(String roof);
}

class Cottage extends Building{
    @Override
    public void setFundament(String base) {
        this.base = base;
    }
    @Override
    public void setWall(String wall) {
        this.wall = wall;
    }
    @Override
    public void setRoof(String roof) {
        this.roof = roof;
    }
}

class SkyScraper extends Building{
    @Override
    public void setFundament(String base) {
        this.base = base;
    }
    @Override
    public void setWall(String wall) {
        this.wall = wall;
    }
    @Override
    public void setRoof(String roof) {
        this.roof = roof;
    }
}

abstract class Builder {
    Building building;
    public Building getBuilding(){
        return building;
    }
    public abstract void buildBase();
    public abstract void buildWall();
    public abstract void buildRoof();
}

class CottageBuilder1 extends Builder {
    public CottageBuilder1(){
        building = new Cottage();
    }
    @Override
    public void buildBase() {
        building.setFundament("base");
    }
    @Override
    public void buildWall() {
        building.setWall("wall");
    }
    @Override
    public void buildRoof() {
        building.setRoof("roof");
    }
}

class SkyScriperBuilder1 extends Builder {
    public SkyScriperBuilder1(){
        building = new SkyScraper();
    }
    @Override
    public void buildBase() {
        building.setFundament("base");
    }
    @Override
    public void buildWall() {
        building.setWall("wall");
    }
    @Override
    public void buildRoof() {
        building.setRoof("roof");
    }
}

class Forman{
    Builder builder1;
    public Forman (Builder builder1){
        this.builder1 = builder1;
    }
    public void createBuilding(){
        builder1.buildBase();
        builder1.buildWall();
        builder1.buildRoof();
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Builder builder1 = new CottageBuilder1();
        Forman forman = new Forman(builder1);
        forman.createBuilding();
        Building building = builder1.getBuilding();
    }
}

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {

    public int width;
    public int height;
    public List<Animal> animals = new ArrayList<Animal>();


    public AbstractWorldMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    public boolean canMoveTo(Vector2d position, Animal animal){
        int Ax=animal.getPosition().getx();
        int Ay=animal.getPosition().gety();
        int Dx=position.getx();
        int Dy=position.gety();
        MapDirection direction = animal.getDirection();
        if((Math.abs(Dx-Ax)==1 || Ax-Dx==this.width-1 )&& Dy==Ay && direction==MapDirection.EAST && !(this.objectAt(new Vector2d(Dx, Dy)) instanceof Animal)){
            return true;
        }
        else if((Math.abs(Dx-Ax)==1 || Dx-Ax==this.width-1 )&& Dy==Ay && direction==MapDirection.WEST && !(this.objectAt(new Vector2d(Dx, Dy)) instanceof Animal)){
            return true;
        }
        else if((Math.abs(Dy-Ay)==1 || Ay-Dy==this.height-1 )&& Dx==Ax && direction==MapDirection.NORTH && !(this.objectAt(new Vector2d(Dx, Dy)) instanceof Animal)){
            return true;
        }
        else if((Math.abs(Dy-Ay)==1 || Dy-Ay==this.height-1 )&& Dx==Ax && direction==MapDirection.SOUTH && !(this.objectAt(new Vector2d(Dx, Dy)) instanceof Animal)){
            return true;
        }
        return false;
    }


    public boolean place(Animal animal){
        if(this.objectAt(animal.getPosition()) instanceof Animal){
            return false;
        }
        else{
            animals.add(animal);
            return true;
        }
    }


    public void run(MoveDirection[] directions){
        for (int i = 0; i < directions.length; i++) {
            animals.get(i%animals.size()).move(directions[i]);
            System.out.println(this.toString());
        }
    }

    public boolean isOccupied(Vector2d position){
        for (Animal animal : animals) {
            if (position.equals(animal.getPosition())) {
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position){
        for (Animal animal : animals) {
            if (position.equals(animal.getPosition())) {
                return animal;
            }
        }
        return null;
    }
    public String toString(){
        MapVisualizer mv = new MapVisualizer(this);
        return (mv.draw(new Vector2d(0,0), new Vector2d(this.width-1, this.height-1)));
    }
}

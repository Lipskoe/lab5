import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap  {

    public List<Grass> grasslist = new ArrayList<Grass>();
    Random r = new Random();

    public GrassField(int width, int height, int grassFieldsNo){
        super(width, height);
        for (int i = 0; i < grassFieldsNo; i++) {
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            while (this.isOccupied(new Vector2d(x,y))){
                x = r.nextInt(width);
                y = r.nextInt(height);
            }
            grasslist.add(new Grass(new Vector2d(x, y)));
        }
    }

    public boolean isOccupied(Vector2d position){
        for (Animal animal : animals) {
            if (position.equals(animal.getPosition())) {
                return true;
            }
        }
        for (Grass grass : grasslist) {
            if (position.equals(grass.getPosition())) {
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
        for (Grass grass : grasslist) {
            if (position.equals(grass.getPosition())) {
                return grass;
            }
        }
        return null;
    }
}

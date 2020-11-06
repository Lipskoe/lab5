import org.junit.Test;
import org.junit.Assert;

public class IntegrationTest{


    @Test
    public void RectangularMapTest(){
        String[] StringInstructions = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(StringInstructions);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assert.assertEquals(MapDirection.SOUTH, map.animals.get(0).getDirection());
        Assert.assertEquals(new Vector2d(2,4), map.animals.get(0).getPosition());
        Assert.assertEquals(MapDirection.NORTH, map.animals.get(1).getDirection());
        Assert.assertEquals(new Vector2d(3,2), map.animals.get(1).getPosition());
    }

    @Test
    public void GrassFieldTest(){
        String[] StringInstructions = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(StringInstructions);
        GrassField map = new GrassField(10, 5, 10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        Assert.assertEquals(MapDirection.SOUTH, map.animals.get(0).getDirection());
        Assert.assertEquals(new Vector2d(2,4), map.animals.get(0).getPosition());
        Assert.assertEquals(MapDirection.NORTH, map.animals.get(1).getDirection());
        Assert.assertEquals(new Vector2d(3,2), map.animals.get(1).getPosition());
    }
}
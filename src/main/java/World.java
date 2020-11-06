public class World {
    public static void main(String[] args) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map = new GrassField(10, 5, 10);
        Vector2d[] positions = { new Vector2d(2,2),new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        System.out.println(map.toString());
        engine.run();

        RectangularMap map2 = new RectangularMap(10, 5);
        IEngine engine2 = new SimulationEngine(directions, map2, positions);
        System.out.println(map2.toString());
        engine2.run();
    }
}


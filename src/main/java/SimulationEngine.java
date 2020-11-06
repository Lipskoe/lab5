public class SimulationEngine implements IEngine {

    public MoveDirection[]  directions;
    public AbstractWorldMap map;
    public Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map, Vector2d[] positions){
        this.directions=directions;
        this.map=map;
        this.positions=positions;
        int i;
        for(i=0; i < positions.length; i++){
            map.place(new Animal(map,positions[i]));
        }

    }

    public void run(){
        map.run(directions);
    }

}
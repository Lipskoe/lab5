

public class Animal {

    private Vector2d position;
    private MapDirection direction;
    private AbstractWorldMap map;

    public Animal(AbstractWorldMap map, Vector2d initialPosition){
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
        this.map=map;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public MapDirection getDirection(){
        return this.direction;
    }


    public String toString(){
        return direction.toString();
    }

    public void move(MoveDirection direction){
        Vector2d newposition;
        switch(direction) {
            case FORWARD:
                newposition=this.position.add(this.direction.toUnitVector());
                if (newposition.getx()>map.width-1){
                    newposition.setx(newposition.getx()-map.width);
                } else if (newposition.getx()<0) {
                    newposition.setx(newposition.getx()+map.width);
                }
                else if (newposition.gety()>map.height-1) {
                    newposition.sety(newposition.gety()-map.height);
                }
                else if (newposition.gety()<0) {
                    newposition.sety(newposition.gety()+map.height);
                }
                if (map.canMoveTo(newposition, this)){
                    this.position=newposition;
                }
                else {
                    System.out.println("position"+newposition.toString()+"is occupied");
                }
                break;
            case BACKWARD:
                newposition=this.position.substract(this.direction.toUnitVector());
                if (newposition.getx()>map.width){
                    newposition.setx(newposition.getx()-map.width);
                } else if (newposition.getx()<0) {
                    newposition.setx(newposition.getx()+map.width);
                }
                else if (newposition.gety()>map.height) {
                    newposition.sety(newposition.gety()-map.height);
                }
                else if (newposition.gety()<0) {
                    newposition.sety(newposition.gety()+map.height);
                }
                if (map.canMoveTo(newposition, this)){
                    this.position=newposition;
                }
                else {
                    System.out.println("position"+newposition.toString()+"is occupied");
                }
                break;
            case RIGHT:
                this.direction=this.direction.next();
                break;
            case LEFT:
                this.direction=this.direction.previous();
                break;
        }
    }
}


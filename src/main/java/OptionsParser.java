
public class OptionsParser {


    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] EnumArray = new MoveDirection[args.length];
        int i=0;
        for(String argument : args){
            switch(argument){
                case "forward":
                case "f":
                    EnumArray[i]=(MoveDirection.FORWARD);
                    i++;
                    break;
                case "backward":
                case "b":
                    EnumArray[i]=(MoveDirection.BACKWARD);
                    i++;
                    break;
                case "right":
                case "r":
                    EnumArray[i]=(MoveDirection.RIGHT);
                    i++;
                    break;
                case "left":
                case "l":
                    EnumArray[i]=(MoveDirection.LEFT);
                    i++;
                    break;
            }
        }
        // Counting how many string elements were actually proper directions (f, b, l, r)
        int counter = 0;
        for (MoveDirection direction : EnumArray) {
            if (direction != null)
                counter++;
        }

        // Creating EnumArray with size of the proper directions count and filling it with values
        MoveDirection[] ProperEnumArray = new MoveDirection[counter];
        System.arraycopy(EnumArray, 0, ProperEnumArray, 0, ProperEnumArray.length);
        return ProperEnumArray;
    }

}

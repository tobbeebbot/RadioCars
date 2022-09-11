package World;

public class Car implements SimulationVehicle {
    // fields
    int posX;
    int posY;
    Direction direction;

    public Car(int posX, int posY, Direction dir) {
        this.posX = posX;
        this.posY = posY;

        // convert based on order of enum. Be careful! :)
        this.direction = dir;
    }

    public int getX() {
        return this.posX;
    }

    public int getY() {
        return this.posY;
    }

    public void turnLeft() {
        switch (direction) {
            case EAST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case NORTH:
                direction = Direction.WEST;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
            case NORTH:
                direction = Direction.EAST;
                break;
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public void moveForward() {
        move(1);
    }

    public void moveBackward() {
        move(-1);
    }

    private void move(int distance) {
        switch (direction) {
            case EAST:
                posX += distance;
                break;
            case SOUTH:
                posY += distance;
                break;
            case WEST:
                posX -= distance;
                break;
            case NORTH:
                posY -= distance;
                break;
            default:
                throw new RuntimeException("Bad direction");
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Position: ").append(posX).append(", ").append(posY)
                .append(". Direction: ").append(direction.name()).append(".");
        return sb.toString();
    }
}

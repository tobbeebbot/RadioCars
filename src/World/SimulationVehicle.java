package World;

public interface SimulationVehicle {
    void turnLeft();
    void turnRight();
    void moveForward();
    void moveBackward();
    void setDirection(Direction direction);

    int getX();
    int getY();
}

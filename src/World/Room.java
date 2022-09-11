package World;

public class Room {
    int width;
    int height;

    public Room(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isInside(SimulationVehicle vehicle) {
        int carX = vehicle.getX();
        int carY = vehicle.getY();

        if (carX < 0 || carX >= width)
            return false;
        return carY >= 0 && carY < height;
    }
}

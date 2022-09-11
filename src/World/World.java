package World;

public class World {
    SimulationVehicle vehicle;
    Room room;

    public World(Room room, SimulationVehicle vehicle) {
        this.vehicle = vehicle;
        this.room = room;
    }

    public SimulationVehicle getVehicle() {
        return vehicle;
    }

    public Room getRoom() {
        return room;
    }
}

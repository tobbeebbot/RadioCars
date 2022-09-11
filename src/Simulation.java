import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Commands.Command;
import World.*;

public class Simulation {
    World world;
    List<Command> commands;

    public Simulation(Room room, SimulationVehicle vehicle, List<Command> commands) {
        world = new World(room, vehicle);
        this.commands = commands;
    }

    public void run() {
        System.out.println("Starting simulation");
        for (Command cmd : commands) {
            if (cmd.apply(world)) {
                System.out.println("Applying command to " + cmd);
                System.out.println(world.getVehicle().toString());
            } else {
                System.out.println("Car crashed into a wall! See below:");
                System.out.println(world.getVehicle());
                return;
            }
        }
        System.out.println("Car made it to the end of simulation!");
        System.out.println(world.getVehicle().toString());
    }

    public static Optional<Simulation> fromString(String input) {
        String[] tokens = input.split(" ");

        if (tokens.length < 5) {
            System.out.println("Error, need at minimum 5 arguments.");
            return Optional.empty();
        }

        Optional<Integer> roomWidth = safeParse(tokens[0]);
        Optional<Integer> roomHeight = safeParse(tokens[1]);
        if (roomWidth.isEmpty() || roomHeight.isEmpty()) {
            System.out.println("Error while parsing room dimensions.");
            return Optional.empty();
        }
        Room room = new Room(roomWidth.get(), roomHeight.get());

        Optional<Integer> carXPosition = safeParse(tokens[2]);
        Optional<Integer> carYPosition = safeParse(tokens[3]);
        if (carXPosition.isEmpty() || carYPosition.isEmpty()) {
            System.out.println("Error while parsing car position.");
            return Optional.empty();
        }

        Optional<Direction> carDirection = parseDirection(tokens[4]);
        if (carDirection.isEmpty()) {
            System.out.println("Error while parsing car direction.");
            return Optional.empty();
        }
        SimulationVehicle car = new Car(carXPosition.get(), carYPosition.get(), carDirection.get());

        if (!room.isInside(car)) {
            System.out.println("Invalid starting position. Car is outside of room.");
            return Optional.empty();
        }

        // parse the control commands
        List<Command> cmdList = new ArrayList<>();
        for (int i = 5; i < tokens.length; i++) {
            Optional<Command> cmd = Command.create(tokens[i]);
            cmd.ifPresent(cmdList::add);
            if (cmd.isEmpty()) {
                System.out.println("Could not parse command " + tokens[i] + ".");
                return Optional.empty();
            }
        }

        return Optional.of(new Simulation(room, car, cmdList));
    }

    private static Optional<Direction> parseDirection(String token) {
        switch (token) {
            case "N":
                return Optional.of(Direction.NORTH);
            case "S":
                return Optional.of(Direction.SOUTH);
            case "W":
                return Optional.of(Direction.WEST);
            case "E":
                return Optional.of(Direction.EAST);
            default:
                return Optional.empty();
        }
    }

    private static Optional<Integer> safeParse(String token) {
        try {
            return Optional.of(Integer.parseInt(token));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}

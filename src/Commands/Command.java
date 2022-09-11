package Commands;

import World.*;

import java.util.Optional;

public abstract class Command {
    public abstract boolean apply(World world);

    public static Optional<Command> create(String token) {
        switch (token)
        {
            case "F":
                return Optional.of(new ForwardCmd());
            case "B":
                return Optional.of(new BackwardCmd());
            case "L":
                return Optional.of(new TurnLeftCmd());
            case "R":
                return Optional.of(new TurnRightCmd());
            case "E":
                return Optional.of(new SetDirectionCmd(Direction.EAST));
            case "S":
                return Optional.of(new SetDirectionCmd(Direction.SOUTH));
            case "W":
                return Optional.of(new SetDirectionCmd(Direction.WEST));
            case "N":
                return Optional.of(new SetDirectionCmd(Direction.NORTH));
            default:
                return Optional.empty();
        }
    }
}

class ForwardCmd extends Command {
    @Override
    public boolean apply(World world) {
        SimulationVehicle vehicle = world.getVehicle();
        vehicle.moveForward();
        return world.getRoom().isInside(vehicle);
    }

    public String toString() {
        return "move car forward.";
    }
}

class BackwardCmd extends Command {
    @Override
    public boolean apply(World world) {
        SimulationVehicle vehicle = world.getVehicle();
        vehicle.moveBackward();
        return world.getRoom().isInside(vehicle);
    }

    public String toString() {
        return  "move car backward.";
    }
}

class TurnLeftCmd extends Command {
    @Override
    public boolean apply(World world) {
        world.getVehicle().turnLeft();
        return true;
    }

    public String toString() {
        return "turn car to the left.";
    }
}

class TurnRightCmd extends Command {
    @Override
    public boolean apply(World world) {
        world.getVehicle().turnRight();
        return true;
    }

    public String toString() { return "turn car to the right."; }
}

class SetDirectionCmd extends Command {
    Direction direction;
    public SetDirectionCmd(Direction direction) {
        this.direction = direction;
    }
    @Override
    public boolean apply(World world) {
        world.getVehicle().setDirection(direction);
        return true;
    }

    public String toString() { return "turn the car to the " + direction.name().toLowerCase() + "."; }
}
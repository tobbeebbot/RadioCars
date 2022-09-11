import org.junit.jupiter.api.Test;

import java.util.Optional;

class SimulationTest {

    @Test
    void run() {
    }

    @Test
    void testFromStringMinimumInputCorrect() {
        String input = "3 3 2 2 E";
        assert(Simulation.fromString(input).isPresent());

        input = "3 3 2 2 E F B L R";
        assert(Simulation.fromString(input).isPresent());
    }

    @Test
    void testFromStringCarOutside() {
        String input = "3 3 4 2 E";
        assert(Simulation.fromString(input).isEmpty());
    }

    @Test
    void testFromStringIncorrectInput() {

        // too short
        String input = "3 3 2";
        assert(Simulation.fromString(input).isEmpty());

        input = "X 3 2 4 N"; // X not valid
        assert(Simulation.fromString(input).isEmpty());

        input = "4 4 X 1 0"; // X not valid
        assert(Simulation.fromString(input).isEmpty());

        input = "4 4 1 1 O"; // O not valid direction
        assert(Simulation.fromString(input).isEmpty());

        input = "4 4 1 1 N B F X"; // X not valid command id
        assert(Simulation.fromString(input).isEmpty());
    }
}
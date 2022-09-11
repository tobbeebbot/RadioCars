import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        // Using Scanner for Getting Input from User
        while (true) {
            Scanner in = new Scanner(System.in);

            String instruction = in.nextLine();

            Optional<Simulation> sim = Simulation.fromString(instruction);
            sim.ifPresentOrElse(
                    Simulation::run,
                    () -> System.out.println("Because of errors the simulation could not be run."));
        }
    }
}

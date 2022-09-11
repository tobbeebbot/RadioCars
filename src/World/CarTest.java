package World;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        car = new Car(0, 0, Direction.EAST);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void testInitialPosition() {
        assert(car.getX() == 0);
        assert(car.getY() == 0);
    }

    @org.junit.jupiter.api.Test
    void testMoveForward() {
        car.moveForward();
        assert(car.getX() == 1);
        assert(car.getY() == 0);
        car.moveForward();
        assert(car.getX() == 2);
        assert(car.getY() == 0);
    }

    @org.junit.jupiter.api.Test
    void testTravelInCircleRight() {
        car.moveForward();
        car.turnRight();
        assert(car.getDirection() == Direction.SOUTH);
        car.moveForward();
        car.turnRight();
        assert(car.getDirection() == Direction.WEST);
        car.moveForward();
        car.turnRight();
        assert(car.getDirection() == Direction.NORTH);
        car.moveForward();
        assertEquals(0, car.getX());
        assertEquals(0, car.getY());
        car.turnRight();
        assert (car.getDirection() == Direction.EAST);
    }

    @org.junit.jupiter.api.Test
    void testTravelInCircleLeft() {
        car.moveForward();
        car.turnLeft();
        assert(car.getDirection() == Direction.NORTH);
        car.moveForward();
        car.turnLeft();
        assert(car.getDirection() == Direction.WEST);
        car.moveForward();
        car.turnLeft();
        assert(car.getDirection() == Direction.SOUTH);
        car.moveForward();
        assertEquals(0, car.getX());
        assertEquals(0, car.getY());
        car.turnLeft();
        assert(car.getDirection() == Direction.EAST);
    }
}
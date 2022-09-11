package World;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    Room room;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        room = new Room(5,5);
    }

    @Test
    void testIsInside() {
        Car car1 = new Car(0,0, Direction.NORTH);
        Car car2 = new Car(3,4, Direction.NORTH);
        Car car3 = new Car(-1, 2, Direction.NORTH);
        Car car4 = new Car(3, 5, Direction.NORTH);

        assertTrue(room.isInside(car1));
        assertTrue(room.isInside(car2));
        assertFalse(room.isInside(car3));
        assertFalse(room.isInside(car4));
    }
}
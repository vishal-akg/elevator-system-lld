package domain.state;

import entities.door.DoorCloseCallback;
import entities.elevator.ElevatorCar;

public interface ElevatorDoorState {
    void open(ElevatorCar elevatorCar, DoorCloseCallback callback);
    void close(ElevatorCar elevatorCar, DoorCloseCallback callback);

    default void open(ElevatorCar elevatorCar) {
        open(elevatorCar, null);
    }

    default void close(ElevatorCar elevatorCar) {
        close(elevatorCar, null);
    }
}

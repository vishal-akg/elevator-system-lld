package domain.state;

import entities.door.DoorCloseCallback;
import entities.elevator.ElevatorCar;

public class ElevatorDoorClosedState implements ElevatorDoorState{
    @Override
    public void open(ElevatorCar elevatorCar, DoorCloseCallback callback) {
        if (elevatorCar.canOpenElevatorDoor()) {
            elevatorCar.setDoorState(new ElevatorDoorOpeningState(elevatorCar, callback));
        }
    }

    @Override
    public void close(ElevatorCar elevatorCar, DoorCloseCallback callback) {
        System.out.println("Elevator door is already closed.");
    }
}

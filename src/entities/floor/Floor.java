package entities.floor;

import domain.ElevatorControlSystem;
import entities.Direction;
import entities.elevator.ElevatorCar;

public class Floor {
    private Integer floorNumber;
    private ButtonPanel buttonPanel;

    public Floor(ElevatorControlSystem elevatorControlSystem, Integer floorNumber) {
        this.floorNumber = floorNumber;
        this.buttonPanel = new ButtonPanel(elevatorControlSystem, floorNumber);
    }

    private ElevatorCar requestElevatorUp() {
        return buttonPanel.up();
    }

    private ElevatorCar requestElevatorDown() {
        return buttonPanel.down();
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public ElevatorCar requestElevator(Direction direction) {
        ElevatorCar elevatorCar = direction == Direction.UP ? requestElevatorUp() : requestElevatorDown();
        elevatorCar.goToFloor(floorNumber);
        return elevatorCar;
    }
}

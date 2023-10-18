package domain.command;

import domain.ElevatorControlSystem;
import entities.Direction;
import entities.elevator.ElevatorCar;

public class RequestElevatorOnFloor implements Command<ElevatorCar> {
    private ElevatorControlSystem elevatorControlSystem;
    private Integer floorNumber;
    private Direction direction;

    public RequestElevatorOnFloor(ElevatorControlSystem elevatorControlSystem, Integer floorNumber, Direction direction) {
        this.elevatorControlSystem = elevatorControlSystem;
        this.floorNumber = floorNumber;
        this.direction = direction;
    }

    @Override
    public ElevatorCar execute() {
        return elevatorControlSystem.requestElevatorOnFloor(floorNumber, direction);
    }
}

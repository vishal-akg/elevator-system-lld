package domain.command;

import entities.elevator.ElevatorCar;
import entities.floor.Floor;

public class MoveToFloorCommand implements Command<Boolean> {
    private Floor floor;
    private ElevatorCar elevatorCar;

    public MoveToFloorCommand(ElevatorCar elevatorCar, Floor floor) {
        this.elevatorCar = elevatorCar;
        this.floor = floor;
    }


    @Override
    public Boolean execute() {
        return elevatorCar.addFloorRequest(floor);
    }
}

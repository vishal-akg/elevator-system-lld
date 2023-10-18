package domain.state;

import entities.elevator.ElevatorCar;

public class ElevatorReachedTheFloorState implements ElevatorState{

    @Override
    public void move(ElevatorCar elevatorCar) {
        Integer floorToServe = elevatorCar.getNextFloorToServe();
        if (floorToServe != null) {
            Integer currentFloor = elevatorCar.getCurrentFloor();
            if (currentFloor > floorToServe) {
                elevatorCar.setElevatorState(new ElevatorMovingDownState(elevatorCar, floorToServe));
            } else {
                elevatorCar.setElevatorState(new ElevatorMovingUpState(elevatorCar, floorToServe));
            }
        }
    }
}

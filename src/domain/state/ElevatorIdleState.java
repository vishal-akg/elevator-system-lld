package domain.state;

import entities.elevator.ElevatorCar;

public class ElevatorIdleState implements ElevatorState{
    @Override
    public void move(ElevatorCar elevatorCar) {
        Integer floorToServe = elevatorCar.getNextFloorToServe();

        if (floorToServe != null) {
            Integer currentFloor = elevatorCar.getCurrentFloor();
            System.out.println(currentFloor + "," + floorToServe);
            if (currentFloor > floorToServe ) {
                elevatorCar.setElevatorState(new ElevatorMovingDownState(elevatorCar, floorToServe));
            } else {
                elevatorCar.setElevatorState(new ElevatorMovingUpState(elevatorCar, floorToServe));
            }
        }
    }

    @Override
    public String toString() {
        return "Elevator is idle, currently at floor";
    }
}

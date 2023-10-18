package entities.display;

import domain.observer.Observer;
import domain.state.*;
import entities.elevator.ElevatorCar;
import entities.elevator.ElevatorStatus;
import entities.floor.Floor;

public class ElevatorDisplay implements Observer {

    @Override
    public void update(Integer id, Floor floor, ElevatorState elevatorState, ElevatorStatus status,
                       ElevatorDoorState doorState) {

        if (status == ElevatorStatus.ACTIVE) {
            String elevatorDisplayString = null;
            String doorDisplayString = null;

            if (doorState instanceof ElevatorDoorClosedState) {
                doorDisplayString = " door is closed now";
            } else if (doorState instanceof ElevatorDoorClosingState) {
                doorDisplayString = " door is closing now.";
            } else if (doorState instanceof ElevatorDoorOpeningState) {
                doorDisplayString = " door is opening now.";
            } else if (doorState instanceof ElevatorDoorOpenedState) {
                doorDisplayString = " door is opened now.";
            }

            if (elevatorState instanceof ElevatorMovingUpState) {
                elevatorDisplayString = String.format("Elevator car #%d moving upward, currently at floor %s",
                        id, floor.getFloorNumber());
            } else if (elevatorState instanceof ElevatorMovingDownState) {
                elevatorDisplayString = String.format("Elevator car #%d is moving downward, currently at floor %s", id,
                        floor.getFloorNumber());
            } else if (elevatorState instanceof ElevatorReachedTheFloorState) {
                elevatorDisplayString = String.format("Elevator car #%d reached the floor %s %s", id,
                        floor.getFloorNumber(), doorDisplayString);
            } else if (elevatorState instanceof ElevatorIdleState) {
                elevatorDisplayString = String.format("Elevator #%d is idle, currently at floor %s %s",
                        id, floor.getFloorNumber(), doorDisplayString);
            }

            if (elevatorDisplayString != null) {
                System.out.println(elevatorDisplayString);
            }

        } else {
            System.out.println("Elevator is under maintenance");
        }

    }
}

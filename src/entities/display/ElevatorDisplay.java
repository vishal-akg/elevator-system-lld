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
            System.out.println(id + " " + elevatorState + ", floor " + floor.getFloorNumber() +  ", " + doorState);
        } else {
            System.out.println("Elevator is under maintenance");
        }

    }
}

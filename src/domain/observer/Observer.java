package domain.observer;

import domain.state.ElevatorDoorState;
import domain.state.ElevatorState;
import entities.elevator.ElevatorCar;
import entities.elevator.ElevatorStatus;
import entities.floor.Floor;

public interface Observer {
    void update(Integer id, Floor floor, ElevatorState elevatorState, ElevatorStatus elevatorStatus, ElevatorDoorState elevatorDoorState);
}

package domain.state;

import entities.elevator.ElevatorCar;

public interface ElevatorState {
    void move(ElevatorCar elevatorCar);
}

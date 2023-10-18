package domain.factory;

import domain.ElevatorControlSystem;
import entities.floor.Floor;

public class FloorFactory {
    public Floor create(ElevatorControlSystem elevatorControlSystem, Integer floorNumber) {
        return new Floor(elevatorControlSystem, floorNumber);
    }
}

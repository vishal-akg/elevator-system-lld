package domain.factory;

import entities.elevator.ElevatorCar;
import entities.floor.Floor;

import java.util.List;

public interface ElevatorCarFactory {
    ElevatorCar create(Integer id, List<Floor> floors);
}

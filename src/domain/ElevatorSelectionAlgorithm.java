package domain;

import entities.Direction;
import entities.elevator.ElevatorCar;

import java.util.List;

public interface ElevatorSelectionAlgorithm {
    ElevatorCar findBestElevatorCar(List<ElevatorCar> elevatorCars, Integer floorNumber, Direction direction);
}

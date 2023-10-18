package domain;

import entities.Direction;
import entities.elevator.ElevatorCar;

import java.util.List;
import java.util.Random;

public class RandomElevatorSelectionAlgorithm implements ElevatorSelectionAlgorithm{
    private Random random;
    public RandomElevatorSelectionAlgorithm() {
        this.random = new Random();
    }
    @Override
    public ElevatorCar findBestElevatorCar(List<ElevatorCar> elevatorCars, Integer floorNumber, Direction direction) {
        return elevatorCars.get(random.nextInt(elevatorCars.size()));
    }
}

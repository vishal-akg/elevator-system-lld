package domain;

import domain.factory.ElevatorCarFactory;
import domain.factory.FloorFactory;
import entities.Direction;
import entities.display.ElevatorDisplay;
import entities.elevator.ElevatorCar;
import entities.floor.Floor;

import java.util.ArrayList;
import java.util.List;

public class ElevatorControlSystem {
    private static ElevatorControlSystem instance;
    private ElevatorSelectionAlgorithm elevatorSelectionAlgorithm;
    private List<ElevatorCar> elevatorCars;
    private List<Floor> floors;

    private ElevatorControlSystem(ElevatorSelectionAlgorithm elevatorSelectionAlgorithm, ElevatorCarFactory elevatorFactory, FloorFactory floorFactory, Integer numberOfElevators, Integer numberOfFloors) {
        this.elevatorSelectionAlgorithm = elevatorSelectionAlgorithm;
        this.elevatorCars = new ArrayList<>(numberOfElevators);
        this.floors = new ArrayList<>(numberOfFloors + 1);

        for (int i = 0; i < numberOfFloors; i++ ) {
            floors.add(floorFactory.create(this, i));
        }

        for (int i = 0; i < numberOfFloors; i++) {
            ElevatorCar elevatorCar = elevatorFactory.create(i, floors);
            elevatorCar.addObservers(new ElevatorDisplay());
            elevatorCars.add(elevatorCar);
        }
    }

    public ElevatorCar requestElevatorOnFloor(Integer floorNumber, Direction direction) {
        return elevatorSelectionAlgorithm.findBestElevatorCar(elevatorCars, floorNumber, direction);
    }

    public Floor getFloorByNumber(Integer floorNumber) {
        return floors.get(floorNumber);
    }

    public static class Builder {
        private ElevatorSelectionAlgorithm elevatorSelectionAlgorithm;
        private ElevatorCarFactory elevatorCarFactory;
        private FloorFactory floorFactory;
        private Integer numberOfFloors;
        private Integer numberOfElevators;

        public Builder elevatorSelectionAlgorithm(ElevatorSelectionAlgorithm elevatorSelectionAlgorithm) {
            this.elevatorSelectionAlgorithm = elevatorSelectionAlgorithm;
            return this;
        }

        public Builder elevatorCarFactory(ElevatorCarFactory elevatorCarFactory) {
            this.elevatorCarFactory = elevatorCarFactory;
            return this;
        }

        public Builder floorFactory(FloorFactory floorFactory) {
            this.floorFactory = floorFactory;
            return this;
        }

        public Builder numberOfElevators(Integer numberOfElevators) {
            this.numberOfElevators = numberOfElevators;
            return this;
        }

        public Builder numberOfFloors(Integer numberOfFloors) {
            this.numberOfFloors = numberOfFloors;
            return this;
        }

        public ElevatorControlSystem build() {
            if (instance == null) {
                synchronized (ElevatorControlSystem.class) {
                    if (instance == null) {
                        instance = new ElevatorControlSystem(elevatorSelectionAlgorithm, elevatorCarFactory, floorFactory, numberOfElevators, numberOfFloors);
                    }
                }
            }
            return instance;
        }
    }
}

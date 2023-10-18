package domain.factory;

import domain.elvator.FloorSelectionAlgorithm;
import entities.elevator.ElevatorCar;
import entities.elevator.PassengerElevatorCar;
import entities.floor.Floor;

import java.util.List;

public class PassengerElevatorCarFactory implements ElevatorCarFactory{
    private FloorSelectionAlgorithm floorSelectionAlgorithm;

    public PassengerElevatorCarFactory(FloorSelectionAlgorithm floorSelectionAlgorithm) {
        this.floorSelectionAlgorithm = floorSelectionAlgorithm;
    }

    @Override
    public ElevatorCar create(Integer id, List<Floor> floors) {
        return new PassengerElevatorCar(id, floorSelectionAlgorithm, floors);
    }
}

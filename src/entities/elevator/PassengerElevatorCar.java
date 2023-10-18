package entities.elevator;

import domain.elvator.FloorSelectionAlgorithm;
import entities.floor.Floor;

import java.util.List;

public class PassengerElevatorCar extends ElevatorCar{
    public PassengerElevatorCar(Integer id, FloorSelectionAlgorithm algorithm, List<Floor> floors) {
        super(id, algorithm, floors);
    }
}

import domain.ElevatorControlSystem;
import domain.RandomElevatorSelectionAlgorithm;
import domain.elvator.FirstComeFirstServeFloorSelectionAlgorithm;
import domain.factory.FloorFactory;
import domain.factory.PassengerElevatorCarFactory;
import entities.Direction;
import entities.elevator.ElevatorCar;
import entities.floor.Floor;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ElevatorControlSystem elevatorControlSystem = new ElevatorControlSystem.Builder()
                .elevatorSelectionAlgorithm(new RandomElevatorSelectionAlgorithm())
                .elevatorCarFactory(new PassengerElevatorCarFactory(new FirstComeFirstServeFloorSelectionAlgorithm()))
                .floorFactory(new FloorFactory())
                .numberOfElevators(3)
                .numberOfFloors(30)
                .build();

        Floor floor15 = elevatorControlSystem.getFloorByNumber(5);
        ElevatorCar elevatorCar15 = floor15.requestElevator(Direction.DOWN);
        elevatorCar15.goToFloor(6);
        elevatorCar15.goToFloor(8);
        elevatorCar15.goToFloor(10);
        elevatorCar15.goToFloor(12);
        elevatorCar15.goToFloor(15);
    }
}
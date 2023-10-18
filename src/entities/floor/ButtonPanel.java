package entities.floor;

import domain.ElevatorControlSystem;
import domain.command.RequestElevatorOnFloor;
import entities.Direction;
import entities.button.Button;
import entities.button.RequestElevatorButton;
import entities.elevator.ElevatorCar;

public class ButtonPanel {
    private Button<ElevatorCar> up;
    private Button<ElevatorCar> down;

    public ButtonPanel(ElevatorControlSystem elevatorControlSystem, Integer floorNumber) {
        up = new RequestElevatorButton(new RequestElevatorOnFloor(elevatorControlSystem, floorNumber, Direction.UP));
        down = new RequestElevatorButton(new RequestElevatorOnFloor(elevatorControlSystem, floorNumber, Direction.DOWN));
    }

    public ElevatorCar up() {
        return up.pressed();
    }

    public ElevatorCar down() {
        return down.pressed();
    }
}

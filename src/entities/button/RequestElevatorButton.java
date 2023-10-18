package entities.button;

import domain.command.Command;
import entities.elevator.ElevatorCar;

public class RequestElevatorButton implements Button<ElevatorCar> {
    private Command<ElevatorCar> command;

    public RequestElevatorButton(Command<ElevatorCar> command) {
        this.command = command;
    }


    @Override
    public ElevatorCar pressed() {
        return command.execute();
    }
}

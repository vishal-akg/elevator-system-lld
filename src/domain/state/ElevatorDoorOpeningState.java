package domain.state;

import entities.door.DoorCloseCallback;
import entities.elevator.ElevatorCar;

import java.util.Timer;
import java.util.TimerTask;

public class ElevatorDoorOpeningState implements ElevatorDoorState{
    public ElevatorDoorOpeningState(ElevatorCar elevatorCar, DoorCloseCallback callback) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                elevatorCar.setDoorState(new ElevatorDoorOpenedState(elevatorCar, callback));
                timer.cancel();
            }
        }, 1000);
    }
    @Override
    public void open(ElevatorCar elevatorCar, DoorCloseCallback callback) {

    }

    @Override
    public void close(ElevatorCar elevatorCar, DoorCloseCallback callback) {

    }

    @Override
    public String toString() {
        return "door is opening.";
    }
}

package domain.state;

import entities.door.DoorCloseCallback;
import entities.elevator.ElevatorCar;

import java.util.Timer;
import java.util.TimerTask;

public class ElevatorDoorOpenedState implements ElevatorDoorState{
    public ElevatorDoorOpenedState(ElevatorCar elevatorCar, DoorCloseCallback callback) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                elevatorCar.setDoorState(new ElevatorDoorClosingState(elevatorCar, callback));
                timer.cancel();
            }
        }, 1000);
    }
    @Override
    public void open(ElevatorCar elevatorCar, DoorCloseCallback callback) {
        System.out.println("Elevator door is already opened.");
    }

    @Override
    public void close(ElevatorCar elevatorCar, DoorCloseCallback callback) {
        elevatorCar.setDoorState(new ElevatorDoorClosingState(elevatorCar, callback));
    }
}

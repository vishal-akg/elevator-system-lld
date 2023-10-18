package domain.state;

import entities.elevator.ElevatorCar;

import java.util.Timer;
import java.util.TimerTask;

public class ElevatorMovingDownState implements ElevatorState{
    public ElevatorMovingDownState(ElevatorCar elevatorCar, Integer floorToServe) {
        Integer nextFloor = elevatorCar.getCurrentFloor() - 1;

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (nextFloor.equals(floorToServe)) {
                    elevatorCar.movedToTheFloor(floorToServe);
                    elevatorCar.setElevatorState(new ElevatorReachedTheFloorState());
                    elevatorCar.reachedTheFloor(floorToServe);
                } else {
                    elevatorCar.movedToTheFloor(nextFloor);
                    elevatorCar.setElevatorState(new ElevatorMovingDownState(elevatorCar, floorToServe));
                }
                timer.cancel();
            }
        }, 1000);
    }
    @Override
    public void move(ElevatorCar elevatorCar) {
        System.out.println("Elevator car is already moving down");
    }

    @Override
    public String toString() {
        return "Elevator is moving down";
    }
}

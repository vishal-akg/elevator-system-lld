package entities.elevator;

import domain.command.MoveToFloorCommand;
import domain.elvator.FloorSelectionAlgorithm;
import domain.observer.Observer;
import domain.state.*;
import entities.button.Button;
import entities.button.MoveRequestButton;
import entities.door.DoorCloseCallback;
import entities.floor.Floor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ElevatorCar {
    private Integer id;
    private Integer capacity;
    private List<Floor> floors;
    private FloorSelectionAlgorithm algorithm;
    private Map<Integer, Button<Boolean>> buttons;
    private List<Floor> floorRequest;
    private ElevatorState elevatorState;
    private ElevatorStatus elevatorStatus;
    private ElevatorDoorState elevatorDoorState;
    private List<Observer> observers;
    private Floor currentFloor;

    public ElevatorCar(Integer id, FloorSelectionAlgorithm algorithm, List<Floor> floors) {
        this.id = id;
        this.algorithm = algorithm;
        this.elevatorState = new ElevatorIdleState();
        this.elevatorDoorState = new ElevatorDoorClosedState();
        this.elevatorStatus = ElevatorStatus.ACTIVE;
        this.floors = floors;
        this.floorRequest = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.buttons = new HashMap<>(floors.size() + 1);

        for (Floor floor: floors) {
            this.buttons.putIfAbsent(floor.getFloorNumber(), new MoveRequestButton(new MoveToFloorCommand(this, floor)));
        }
        this.currentFloor = floors.get(0);
    }
    public Boolean addFloorRequest(Floor floor) {
        floorRequest.add(floor);
        if (elevatorState instanceof ElevatorIdleState) {
            elevatorState.move(this);
        }
        return true;
    }

    public Integer getNextFloorToServe() {
        Floor nextFloorToServe = algorithm.getNextFloor(floorRequest);
        if (nextFloorToServe != null) {
            return nextFloorToServe.getFloorNumber();
        }
        return null;
    }

    public boolean hasFloorsToServe() {
        return !floorRequest.isEmpty();
    }

    public Integer getCurrentFloor() {
        return currentFloor.getFloorNumber();
    }

    public void setElevatorState(ElevatorState state) {
        this.elevatorState = state;
        notifyObservers();
    }

    public void movedToTheFloor(Integer floorNumber) {
        this.currentFloor = floors.get(floorNumber);
    }

    public void reachedTheFloor(Integer floorNumber) {
        final ElevatorCar self = this;
        elevatorDoorState.open(this, new DoorCloseCallback() {
            @Override
            public void onDoorClosed() {
                self.servedTheFloor(self.currentFloor);
                elevatorState.move(self);
            }
        });
    }

    public void openElevatorDoor() {
        elevatorDoorState.open(this);
    }

    public void closeElevatorDoor() {
        elevatorDoorState.close(this);
    }

    private void servedTheFloor(Floor floor) {
        floorRequest.remove(floor);
    }

    public boolean canOpenElevatorDoor() {
        return elevatorState instanceof ElevatorIdleState ||
                elevatorState instanceof ElevatorReachedTheFloorState;
    }

    public void setDoorState(ElevatorDoorState doorState) {
        elevatorDoorState = doorState;
        notifyObservers();
    }

    public Boolean goToFloor(Integer floorNumber) {
        return this.buttons.get(floorNumber).pressed();
    }

    public void addObservers(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(id, currentFloor, elevatorState, elevatorStatus, elevatorDoorState);
        }
    }
}

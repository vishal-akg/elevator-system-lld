package domain.elvator;

import entities.floor.Floor;

import java.util.List;

public class FirstComeFirstServeFloorSelectionAlgorithm implements FloorSelectionAlgorithm{

    @Override
    public Floor getNextFloor(List<Floor> floors) {
        return floors != null && !floors.isEmpty() ? floors.get(0) : null;
    }
}

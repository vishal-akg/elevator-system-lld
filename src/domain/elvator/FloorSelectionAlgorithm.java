package domain.elvator;

import entities.floor.Floor;

import java.util.List;

public interface FloorSelectionAlgorithm {
    Floor getNextFloor(List<Floor> floors);
}

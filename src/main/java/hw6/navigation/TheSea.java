package hw6.navigation;

import hw6.ships.JustAnotherShip;

/**
 * Represents the sea battlefield.
 * Stores the status of each sea area.
 *
 * @author Fedorov Sergei
 * @version 1.1
 */
public class TheSea {
    public final int width = 10;
    public final int height = 10;

    public enum SeaAreaType {empty, nearTheShip, ship, shot, miss}

    SeaAreaType[][] battlefield;

    public TheSea() {
        battlefield = new SeaAreaType[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                battlefield[i][j] = SeaAreaType.empty;
            }
        }
    }

    public void placeTheShip(JustAnotherShip ship) {
        for (Coordinates coord : ship.getCoords()) {
            battlefield[coord.column][coord.line] = SeaAreaType.ship;
        }
        for (Coordinates coord : ship.getEnvironment()) {
            battlefield[coord.column][coord.line] = SeaAreaType.nearTheShip;
        }
    }

    public void setTheEnvironment(Coordinates[] coords) {
        for (Coordinates coord : coords) {
            battlefield[coord.column][coord.line] = SeaAreaType.miss;
        }
    }

    public SeaAreaType getStatus(Coordinates coord) {
        return battlefield[coord.column][coord.line];
    }

    public void setStatus(Coordinates coord, SeaAreaType newType) {
        battlefield[coord.column][coord.line] = newType;
    }
}

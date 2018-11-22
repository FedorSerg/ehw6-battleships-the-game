package hw6.navigation;

import hw6.ships.JustAnotherShip;

public class TheSea {
    public final int width = 10;
    public final int height = 10;

    public enum SeaArea {empty, nearTheShip, ship, shot}

    SeaArea[][] battlefield;

    public TheSea() {
        battlefield = new SeaArea[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                battlefield[i][j] = SeaArea.empty;
            }
        }
    }

    public SeaArea getStatus(Coordinates coord) {
        return battlefield[coord.column][coord.line];
    }

    public void placeTheShip(JustAnotherShip ship) {
        for (Coordinates coord : ship.getCoords()) {
            battlefield[coord.column][coord.line] = SeaArea.ship;
        }
        for (Coordinates coord : ship.getEnvironment()) {
            battlefield[coord.column][coord.line] = SeaArea.nearTheShip;
        }
    }

}

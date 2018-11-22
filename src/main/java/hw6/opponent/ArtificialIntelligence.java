package hw6.opponent;

import hw6.navigation.Coordinates;
import hw6.navigation.TheSea;
import hw6.ships.JustAnotherShip;

import java.util.Random;

public class ArtificialIntelligence {
    public Coordinates detectedShip = new Coordinates(-1, -1);

    public JustAnotherShip[] generateField(){
        JustAnotherShip[] generated = new JustAnotherShip[10];

        return generated;
    }

    public Coordinates fire(TheSea field) {
        if (detectedShip.getColumn() == -1 || detectedShip.getLine() == -1) {
            return new Coordinates(new Random().nextInt(9), new Random().nextInt(9));
        } else {
            if (detectedShip.getColumn() > 0 && field.getStatus(
                    new Coordinates(detectedShip.getColumn() - 1, detectedShip.getLine())).equals(TheSea.SeaArea.empty)) {
                return new Coordinates(detectedShip.getColumn() - 1, detectedShip.getLine());
            } else if (detectedShip.getColumn() < 9 && field.getStatus(
                    new Coordinates(detectedShip.getColumn() + 1, detectedShip.getLine())).equals(TheSea.SeaArea.empty)) {
                return new Coordinates(detectedShip.getColumn() + 1, detectedShip.getLine());
            } else if (detectedShip.getLine() > 0 && field.getStatus(
                    new Coordinates(detectedShip.getColumn(), detectedShip.getLine() - 1)).equals(TheSea.SeaArea.empty)) {
                return new Coordinates(detectedShip.getColumn(), detectedShip.getLine() - 1);
            } else if (detectedShip.getLine() > 0 && field.getStatus(
                    new Coordinates(detectedShip.getColumn(), detectedShip.getLine() - 1)).equals(TheSea.SeaArea.empty)) {
                return new Coordinates(detectedShip.getColumn(), detectedShip.getLine() - 1);
            } else {
                detectedShip.setCoords(-1,-1);
                return new Coordinates(new Random().nextInt(9), new Random().nextInt(9));
            }
        }
    }
}

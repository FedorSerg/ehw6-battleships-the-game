package hw6.players;

import hw6.navigation.Coordinates;
import hw6.navigation.TheSea;
import hw6.ships.JustAnotherShip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The 'brain' of the opponent. Helps to decide where to shoot.
 *
 * @author Fedorov Sergei
 * @version 2.1
 */
public class ArtificialIntelligence {
    private ArrayList priority;

    public ArtificialIntelligence() {
        priority = new ArrayList();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                priority.add(new Coordinates(i, j));
            }
        }
        Collections.shuffle(priority);
    }

    public JustAnotherShip[] generateTheEvilFleet(TheSea field) {
        JustAnotherShip[] generated = new JustAnotherShip[10];
        switch (new Random().nextInt(4)) {
            case 0:
                generated[0] = new JustAnotherShip(new Coordinates("G3"), new Coordinates("J3"));

                generated[1] = new JustAnotherShip(new Coordinates("B5"), new Coordinates("D5"));
                generated[2] = new JustAnotherShip(new Coordinates("B9"), new Coordinates("D9"));

                generated[3] = new JustAnotherShip(new Coordinates("C7"), new Coordinates("D7"));
                generated[4] = new JustAnotherShip(new Coordinates("B2"), new Coordinates("C2"));
                generated[5] = new JustAnotherShip(new Coordinates("F1"), new Coordinates("G1"));
                generated[6] = new JustAnotherShip(new Coordinates("F5"));
                generated[7] = new JustAnotherShip(new Coordinates("A7"));
                generated[8] = new JustAnotherShip(new Coordinates("H7"));
                generated[9] = new JustAnotherShip(new Coordinates("I10"));
                break;
            case 1:
                generated[0] = new JustAnotherShip(new Coordinates("B2"), new Coordinates("B5"));

                generated[1] = new JustAnotherShip(new Coordinates("I7"), new Coordinates("I9"));
                generated[2] = new JustAnotherShip(new Coordinates("B9"), new Coordinates("D9"));

                generated[3] = new JustAnotherShip(new Coordinates("E7"), new Coordinates("D7"));
                generated[4] = new JustAnotherShip(new Coordinates("D2"), new Coordinates("D3"));
                generated[5] = new JustAnotherShip(new Coordinates("F1"), new Coordinates("G1"));
                generated[6] = new JustAnotherShip(new Coordinates("E5"));
                generated[7] = new JustAnotherShip(new Coordinates("G4"));
                generated[8] = new JustAnotherShip(new Coordinates("G7"));
                generated[9] = new JustAnotherShip(new Coordinates("G10"));
                break;
            case 2:
                generated[0] = new JustAnotherShip(new Coordinates("C6"), new Coordinates("C9"));

                generated[1] = new JustAnotherShip(new Coordinates("I5"), new Coordinates("G5"));
                generated[2] = new JustAnotherShip(new Coordinates("G8"), new Coordinates("G10"));

                generated[3] = new JustAnotherShip(new Coordinates("E2"), new Coordinates("E3"));
                generated[4] = new JustAnotherShip(new Coordinates("I1"), new Coordinates("H1"));
                generated[5] = new JustAnotherShip(new Coordinates("A6"), new Coordinates("A7"));
                generated[6] = new JustAnotherShip(new Coordinates("B2"));
                generated[7] = new JustAnotherShip(new Coordinates("A10"));
                generated[8] = new JustAnotherShip(new Coordinates("I3"));
                generated[9] = new JustAnotherShip(new Coordinates("J9"));
                break;
            case 3:
                generated[0] = new JustAnotherShip(new Coordinates("A1"), new Coordinates("A4"));

                generated[1] = new JustAnotherShip(new Coordinates("A6"), new Coordinates("A8"));
                generated[2] = new JustAnotherShip(new Coordinates("C1"), new Coordinates("E1"));

                generated[3] = new JustAnotherShip(new Coordinates("G1"), new Coordinates("H1"));
                generated[4] = new JustAnotherShip(new Coordinates("A10"), new Coordinates("B10"));
                generated[5] = new JustAnotherShip(new Coordinates("J1"), new Coordinates("J2"));
                generated[6] = new JustAnotherShip(new Coordinates("C3"));
                generated[7] = new JustAnotherShip(new Coordinates("E7"));
                generated[8] = new JustAnotherShip(new Coordinates("G4"));
                generated[9] = new JustAnotherShip(new Coordinates("H9"));
                break;
        }
        for (JustAnotherShip ship : generated) {
            field.placeTheShip(ship);
        }

        return generated;
    }

    public Coordinates fire() {
        Coordinates target = (Coordinates) priority.get(0);
        removeFromPriority(target);
        return target;
    }

    public void setHighPriority(Coordinates coord) {
        if (priority.indexOf(coord) != -1) {
            priority.add(0, priority.get(priority.indexOf(coord)));
            priority.remove(priority.lastIndexOf(coord));
        }
    }

    public void removeFromPriority(Coordinates coord) {
        if (priority.indexOf(coord) != -1) {
            priority.remove(priority.indexOf(coord));
        }
    }
}

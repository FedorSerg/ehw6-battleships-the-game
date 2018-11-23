package hw6.dialog;

import hw6.navigation.Coordinates;
import hw6.navigation.SeaAppearance;
import hw6.navigation.TheSea;
import hw6.players.ArtificialIntelligence;
import hw6.players.Player;
import hw6.ships.JustAnotherShip;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * The main dialog with a player happends here.
 * The 'startTheGame' method compiles the functional of all other classes to run the game
 *
 * @author Fedorov Sergei
 * @version 1.4
 */
public class MainDialog {
    public void startTheGame() {
        showLogo();
        JustAnotherShip[] myShips = new JustAnotherShip[10];
        SeaAppearance theBattlefield = new SeaAppearance();
        TheSea myField = new TheSea();
        TheSea opponentField = new TheSea();
        theBattlefield.showTheSea(myField, 0, opponentField, 0);


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Place your battleships:");
            String area;

            System.out.println("Place a battleship (four-funnel ship):");
            System.out.println("Head:");
            String area1 = reader.readLine();
            while (!isTheStringOk(area1) || isTheFieldTaken(area1, myField)) {
                if (!isTheStringOk(area1)) {
                    System.err.println("Incorrect input, you should enter coordinates like 'A1', 'J10'");
                }
                if (isTheFieldTaken(area1, myField)) {
                    System.out.println("The area is already taken");
                }
                area1 = reader.readLine();
            }
            System.out.println("Tail:");
            String area2 = reader.readLine();
            while (!isTheStringOk(area2) || isTheFieldTaken(area2, myField) ||
                    !isTheShipNormEnough(new Coordinates(area1), new Coordinates(area2), 4)) {
                if (!isTheStringOk(area2)) {
                    System.err.println("Incorrect input, you should enter coordinates like 'A1', 'J10'");
                }
                if (isTheFieldTaken(area2, myField)) {
                    System.out.println("The area is already taken");
                }
                if (!isTheShipNormEnough(new Coordinates(area1), new Coordinates(area2), 4)) {
                    System.out.println("The ship must be straight and long enough");
                }
                area2 = reader.readLine();
            }
            myShips[0] = new JustAnotherShip(new Coordinates(area1), new Coordinates(area2));
            myField.placeTheShip(myShips[0]);
            theBattlefield.showTheSea(myField, 0, opponentField, 0);

            System.out.println("Place two cruisers (three-funnel ships):");
            for (int i = 1; i < 3; i++) {
                System.out.println("Head:");
                area1 = reader.readLine();
                while (!isTheStringOk(area1) || isTheFieldTaken(area1, myField)) {
                    if (!isTheStringOk(area1)) {
                        System.err.println("Incorrect input, you should enter coordinates like 'A1', 'J10'");
                    }
                    if (isTheFieldTaken(area1, myField)) {
                        System.out.println("The area is already taken");
                    }
                    area1 = reader.readLine();
                }
                System.out.println("Tail:");
                area2 = reader.readLine();
                while (!isTheStringOk(area2) || isTheFieldTaken(area2, myField) ||
                        !isTheShipNormEnough(new Coordinates(area1), new Coordinates(area2), 3)) {
                    if (!isTheStringOk(area2)) {
                        System.err.println("Incorrect input, you should enter coordinates like 'A1', 'J10'");
                    }
                    if (isTheFieldTaken(area2, myField)) {
                        System.out.println("The area is already taken");
                    }
                    if (!isTheShipNormEnough(new Coordinates(area1), new Coordinates(area2), 3)) {
                        System.out.println("The ship must be straight and long enough");
                    }
                    area2 = reader.readLine();
                }
                myShips[i] = new JustAnotherShip(new Coordinates(area1), new Coordinates(area2));
                myField.placeTheShip(myShips[i]);
                theBattlefield.showTheSea(myField, 0, opponentField, 0);
            }

            System.out.println("Place three destroyers (two-funnel ships):");
            for (int i = 3; i < 6; i++) {
                System.out.println("Head:");
                area1 = reader.readLine();
                while (!isTheStringOk(area1) || isTheFieldTaken(area1, myField)) {
                    if (!isTheStringOk(area1)) {
                        System.err.println("Incorrect input, you should enter coordinates like 'A1', 'J10'");
                    }
                    if (isTheFieldTaken(area1, myField)) {
                        System.out.println("The area is already taken");
                    }
                    area1 = reader.readLine();
                }
                System.out.println("Tail:");
                area2 = reader.readLine();
                while (!isTheStringOk(area2) || isTheFieldTaken(area2, myField) ||
                        !isTheShipNormEnough(new Coordinates(area1), new Coordinates(area2), 2)) {
                    if (!isTheStringOk(area2)) {
                        System.err.println("Incorrect input, you should enter coordinates like 'A1', 'J10'");
                    }
                    if (isTheFieldTaken(area2, myField)) {
                        System.out.println("The area is already taken");
                    }
                    if (!isTheShipNormEnough(new Coordinates(area1), new Coordinates(area2), 2)) {
                        System.out.println("The ship must be straight and long enough");
                    }
                    area2 = reader.readLine();
                }
                myShips[i] = new JustAnotherShip(new Coordinates(area1), new Coordinates(area2));
                myField.placeTheShip(myShips[i]);
                theBattlefield.showTheSea(myField, 0, opponentField, 0);
            }

            System.out.println("Place four submarines (single-funnel ships):");
            for (int i = 6; i < 10; i++) {
                area = reader.readLine();
                while (!isTheStringOk(area) || isTheFieldTaken(area, myField)) {
                    if (!isTheStringOk(area)) {
                        System.err.println("Incorrect input, you should enter coordinates like 'A1', 'J10'");
                    }
                    if (isTheFieldTaken(area, myField)) {
                        System.out.println("The area is already taken");
                    }
                    area = reader.readLine();
                }

                myShips[i] = new JustAnotherShip(new Coordinates(area));
                myField.placeTheShip(myShips[i]);

                theBattlefield.showTheSea(myField, 0, opponentField, 0);
            }

            Player player = new Player(myShips, new Random().nextInt() % 2 == 0);
            ArtificialIntelligence theEvilMind = new ArtificialIntelligence();
            JustAnotherShip[] opponentShips = theEvilMind.generateTheEvilFleet(opponentField);
            Player opponent = new Player(opponentShips, !player.passTheTurn);
            theBattlefield.showTheSea(myField, player.lifeTotal, opponentField, opponent.lifeTotal);

            System.out.println("The battle begins!");
            System.out.println();

            while (player.lifeTotal > 0 && opponent.lifeTotal > 0) {
                if (!player.passTheTurn) {
                    System.out.println("Your turn!");
                    System.out.println("Target:");
                    area = reader.readLine();
                    while (!isTheStringOk(area) /*|| !isTheFieldTaken(area, myField)*/) {
                        if (!isTheStringOk(area)) {
                            System.err.println("Incorrect input, you should enter coordinates like 'A1', 'J10'");
                        }
                        area = reader.readLine();
                    }
                    System.out.println("BOOM");
                    Coordinates boomCoords = new Coordinates(area);
                    switch (opponentField.getStatus(boomCoords)) {
                        case empty:
                        case nearTheShip:
                            opponentField.setStatus(boomCoords, TheSea.SeaAreaType.miss);
                            System.out.println("Missed!");
                            player.passTheTurn = true;
                            opponent.passTheTurn = false;
                            break;
                        case ship:
                            System.out.println("KADOOM");
                            opponentField.setStatus(boomCoords, TheSea.SeaAreaType.shot);
                            for (JustAnotherShip ship : opponentShips) {
                                if (ship.takeTheArea(boomCoords)) {
                                    Coordinates[] damageArea = ship.damage();
                                    if (damageArea.length > 0) {
                                        opponentField.setTheEnvironment(damageArea);
                                        opponent.lifeTotal--;
                                    }
                                }
                            }
                            System.out.println("Got it!");
                            break;
                    }
                } else {
                    System.out.println("Opponent's turn.");

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("BOOM");
                    Coordinates boomCoords = theEvilMind.fire();
                    switch (myField.getStatus(boomCoords)) {
                        case empty:
                            System.out.println("Ha, missed!");
                        case nearTheShip:
                            System.out.println("That was close!");
                            myField.setStatus(boomCoords, TheSea.SeaAreaType.miss);
                            player.passTheTurn = false;
                            opponent.passTheTurn = true;
                            break;
                        case ship:
                            System.out.println("KADOOM");
                            myField.setStatus(boomCoords, TheSea.SeaAreaType.shot);
                            for (JustAnotherShip ship : myShips) {
                                if (ship.takeTheArea(boomCoords)) {
                                    Coordinates[] damageArea = ship.damage();
                                    if (damageArea.length > 0) {
                                        myField.setTheEnvironment(damageArea);
                                        for (Coordinates coord : damageArea) {
                                            theEvilMind.removeFromPriority(coord);
                                        }
                                        player.lifeTotal--;
                                    } else {
                                        for (Coordinates coord : boomCoords.getEnvironment()) {
                                            theEvilMind.setHighPriority(coord);
                                        }
                                    }

                                }
                            }

                            System.out.println("Our ship was damaged!");
                            break;
                    }
                }
                theBattlefield.showTheSea(myField, player.lifeTotal, opponentField, opponent.lifeTotal);
                System.out.println();
            }

            if (player.lifeTotal > 0) {
                System.out.println("                    Victory!");
                System.out.println("                Congratulations!");
            } else {
                System.out.println("                    You lose!");
                System.out.println("    This time the opponent was better in tactics.");
            }
            showLogo();
            System.out.println("made by Fedorov Sergei (https://github.com/FedorSerg)");
        } catch (IOException er) {
            er.printStackTrace();
        }
    }

    private boolean isTheStringOk(@NotNull String area) {
        return (area.length() > 1 && area.length() <= 3 &&
                area.substring(0, 1).matches("[A-J]") &&
                area.substring(1).matches("[1-9]|10"));
    }

    private boolean isTheFieldTaken(@NotNull String area, TheSea myField) {
        return isTheStringOk(area) && !(myField.getStatus(new Coordinates(area)).equals(TheSea.SeaAreaType.empty));
    }

    private boolean isTheFieldFireable(@NotNull String area, TheSea myField) {
        return isTheStringOk(area) && (myField.getStatus(new Coordinates(area)).equals(TheSea.SeaAreaType.empty) ||
                myField.getStatus(new Coordinates(area)).equals(TheSea.SeaAreaType.nearTheShip) ||
                myField.getStatus(new Coordinates(area)).equals(TheSea.SeaAreaType.ship));
    }

    private boolean isTheShipNormEnough(@NotNull Coordinates area1, Coordinates area2, int l) {
        return (area1.getLine() == area2.getLine() || area1.getColumn() == area2.getColumn()) &&
                Math.abs(area1.getLine() - area2.getLine() + area1.getColumn() - area2.getColumn()) + 1 == l;
    }

    private void showLogo() {
        System.out.println();
        System.out.println("                          oOOooOo              ");
        System.out.println("                     oOoo||   oOoOO            ");
        System.out.println("                    ||   ||  ||                ");
        System.out.println("                  { BATTLESHIPS }              ");
        System.out.println("     ~ ~ ~ ~ ~ ~ ~ \\ THE  GAME / ~ ~ ~ ~ ~ ~ ~ ");
        System.out.println("        ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~    ");
        System.out.println();
    }
}

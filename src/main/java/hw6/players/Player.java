package hw6.players;

import hw6.ships.JustAnotherShip;
import org.jetbrains.annotations.NotNull;

/**
 * Just an adjuvant class. Represents the human and the computer as the players.
 *
 * @author Fedorov Sergei
 * @version 1
 */
public class Player {
    public int lifeTotal;
    public boolean passTheTurn;

    public Player(@NotNull JustAnotherShip[] ships, boolean turn) {
        this.lifeTotal = ships.length;
        this.passTheTurn = turn;
    }

}

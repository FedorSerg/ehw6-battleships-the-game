package hw6.dialog;

import hw6.ships.JustAnotherShip;
import org.jetbrains.annotations.NotNull;

public class Player {
    public int lifeTotal;
    boolean passTheTurn;

    public Player(@NotNull JustAnotherShip[] ships, boolean turn) {
        this.lifeTotal = ships.length;
        this.passTheTurn = turn;
    }

}

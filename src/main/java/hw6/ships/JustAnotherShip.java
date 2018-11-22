package hw6.ships;

import hw6.navigation.Coordinates;
import org.jetbrains.annotations.NotNull;

public class JustAnotherShip {
    Coordinates[] coords;
    int durability;

    enum ShipType {horizontal, vertical}
    ShipType type;

    public JustAnotherShip(@NotNull Coordinates head, @NotNull Coordinates tail) {

        if (head.getColumn() > tail.getColumn() || head.getLine() > tail.getLine()) {
            Coordinates helper = new Coordinates(head.getColumn(), head.getLine());
            head = new Coordinates(tail.getColumn(), tail.getLine());
            tail = new Coordinates(helper.getColumn(), helper.getLine());
        }
        this.coords = new Coordinates[
                (tail.getColumn() - head.getColumn()) + (tail.getLine() - head.getLine()) + 1];

        if (head.getColumn() == tail.getColumn()) {
            for (int i = 0; i < this.coords.length; i++) {
                this.coords[i] = new Coordinates(head.getColumn(), head.getLine() + i);
            }
            type = ShipType.vertical;
        } else if (head.getLine() == tail.getLine()) {
            for (int i = 0; i < this.coords.length; i++) {
                this.coords[i] = new Coordinates(head.getColumn() + i, head.getLine());
            }
            type = ShipType.horizontal;
        }
        this.durability = this.coords.length;
    }

    @Override
    public String toString() {
        return "Column = " + coords[0].getColumn() + "; line = " + coords[0].getLine();
    }

    private boolean isItInTheCorner() {
        if (isItPokesTheBorder() && isItNearTheBorder()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isItPokesTheBorder() {
        if (type.equals(ShipType.vertical) &&
                (coords[0].getLine() == 0 || coords[coords.length - 1].getLine() == 9)) {
            return true;
        }
        if (type.equals(ShipType.horizontal) &&
                (coords[0].getColumn() == 0 || coords[coords.length - 1].getColumn() == 9)) {
            return true;
        }
        return false;
    }

    private boolean isItNearTheBorder() {
        if (type.equals(ShipType.horizontal) &&
                (coords[0].getLine() == 0 || coords[0].getLine() == 9)) {
            return true;
        }
        if (type.equals(ShipType.vertical) &&
                (coords[0].getColumn() == 0 || coords[0].getColumn() == 9)) {
            return true;
        }
        return false;
    }

    public void damage(Coordinates coords) {
        durability--;
        if (durability <= 0) {
            this.getEnvironment();
        }
    }

    public Coordinates[] getEnvironment() {
        Coordinates[] emptyArea;

        if (isItInTheCorner()) {
            emptyArea = new Coordinates[this.coords.length + 2];
        } else if (isItPokesTheBorder()) {
            emptyArea = new Coordinates[2 * this.coords.length + 3];
        } else if (isItNearTheBorder()) {
            emptyArea = new Coordinates[this.coords.length + 4];
        } else {
            emptyArea = new Coordinates[2 * this.coords.length + 6];
        }
        if (type.equals(ShipType.vertical)) {
            for (int i = 0, k = 0; i < coords.length; i++) {
                if (i == 0 && coords[i].getLine() > 0) {
                    emptyArea[k] = new Coordinates(coords[i].getColumn(), coords[i].getLine() - 1);
                    k++;
                    if (coords[i].getColumn() > 0) {
                        emptyArea[k] = new Coordinates(coords[i].getColumn() - 1, coords[i].getLine() - 1);
                        k++;
                    }
                    if (coords[i].getColumn() < 9) {
                        emptyArea[k] = new Coordinates(coords[i].getColumn() + 1, coords[i].getLine() - 1);
                        k++;
                    }
                }

                if (coords[i].getColumn() > 0) {
                    emptyArea[k] = new Coordinates(coords[i].getColumn() - 1, coords[i].getLine());
                    k++;
                }
                if (coords[i].getColumn() < 9) {
                    emptyArea[k] = new Coordinates(coords[i].getColumn() + 1, coords[i].getLine());
                    k++;
                }

                if (i == coords.length - 1 && coords[i].getLine() < 9) {
                    emptyArea[k] = new Coordinates(coords[i].getColumn(), coords[i].getLine() + 1);
                    k++;
                    if (coords[i].getColumn() > 0) {
                        emptyArea[k] = new Coordinates(coords[i].getColumn() - 1, coords[i].getLine() + 1);
                        k++;
                    }
                    if (coords[i].getColumn() < 9) {
                        emptyArea[k] = new Coordinates(coords[i].getColumn() + 1, coords[i].getLine() + 1);
                        k++;
                    }
                }
            }
        } else {
            for (int i = 0, k = 0; i < coords.length; i++) {
                if (i == 0 && coords[i].getColumn() > 0) {
                    emptyArea[k] = new Coordinates(coords[i].getColumn() - 1, coords[i].getLine());
                    k++;
                    if (coords[i].getLine() > 0) {
                        emptyArea[k] = new Coordinates(coords[i].getColumn() - 1, coords[i].getLine() - 1);
                        k++;
                    }
                    if (coords[i].getLine() < 9) {
                        emptyArea[k] = new Coordinates(coords[i].getColumn() - 1, coords[i].getLine() + 1);
                        k++;
                    }
                }

                if (coords[i].getLine() > 0) {
                    emptyArea[k] = new Coordinates(coords[i].getColumn(), coords[i].getLine() - 1);
                    k++;
                }
                if (coords[i].getLine() < 9) {
                    emptyArea[k] = new Coordinates(coords[i].getColumn(), coords[i].getLine() + 1);
                    k++;
                }

                if (i == coords.length - 1 && coords[i].getColumn() < 9) {
                    emptyArea[k] = new Coordinates(coords[i].getColumn() + 1, coords[i].getLine());
                    k++;
                    if (coords[i].getLine() > 0) {
                        emptyArea[k] = new Coordinates(coords[i].getColumn() + 1, coords[i].getLine() - 1);
                        k++;
                    }
                    if (coords[i].getLine() < 9) {
                        emptyArea[k] = new Coordinates(coords[i].getColumn() + 1, coords[i].getLine() + 1);
                        k++;
                    }
                }
            }
        }
        return emptyArea;
    }

    public Coordinates[] getCoords() {
        return this.coords;
    }
}
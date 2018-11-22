package hw6.navigation;

import org.jetbrains.annotations.NotNull;

public class Coordinates {
    int column;
    int line;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return column == that.column &&
                line == that.line;
    }

    public void setCoords(int c, int l) {
        this.column = c;
        this.line = l;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public Coordinates(int column, int line) {
        this.column = column;
        this.line = line;
    }

    public Coordinates(@NotNull String area) {

        this.column = (int) area.charAt(0) - 65;
        this.line = Integer.parseInt("" + area.substring(1)) - 1;
    }
}

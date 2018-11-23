package hw6.navigation;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * The most important class in the project.
 * Represents an area of the battlefield.
 *
 * @author Fedorov Sergei
 * @version 1.5
 */
public class Coordinates {
    private int column;
    private int line;

    public Coordinates(int column, int line) {
        this.column = column;
        this.line = line;
    }

    public Coordinates(@NotNull String area) {

        this.column = (int) area.charAt(0) - 65;
        this.line = Integer.parseInt("" + area.substring(1)) - 1;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return column == that.column &&
                line == that.line;
    }

    public Coordinates[] getEnvironment() {
        ArrayList result = new ArrayList();
        if (column > 0) result.add(new Coordinates(column - 1, line));
        if (column < 9) result.add(new Coordinates(column + 1, line));
        if (line > 0) result.add(new Coordinates(column, line - 1));
        if (line < 9) result.add(new Coordinates(column, line + 1));


        Coordinates[] newResult = new Coordinates[result.size()];
        result.toArray(newResult);
        return newResult;
    }

}

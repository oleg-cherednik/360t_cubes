package cop.cube.domain.cube;

import cop.cube.domain.SquareShape;

/**
 * Represents cub side with set of method for the side. This is stateless implementation. Real data is {@code data} array, all methods work with it
 * and do not create additional temporary arrays.
 *
 * @author Oleg Cherednik
 * @since 14.04.2018
 */
@SuppressWarnings("MethodCanBeVariableArityMethod")
abstract class CubeSide {

    private final char marker;

    protected CubeSide(char marker) {
        this.marker = marker;
    }

    public final char getMarker() {
        return marker;
    }

    public abstract boolean isSolved(char[][][] data);

    public abstract void clear(char[][][] data);

    public abstract boolean add(SquareShape shape, char[][][] data);

    public abstract boolean[][] mask(char[][][] data);

    protected final void clear(int x, int y, int z, char[][][] data) {
        data[y][x][z] = data[y][x][z] == marker ? '\0' : data[y][x][z];
    }

    protected final boolean add(boolean taken, int x, int y, int z, char[][][] data) {
        if (taken) {
            if (data[y][x][z] != '\0' && data[y][x][z] != marker)
                return false;

            data[y][x][z] = marker;
        }

        return true;
    }

    protected static int width(char[][][] data) {
        return data.length;
    }

    protected static boolean isTaken(int x, int y, int z, char[][][] data) {
        return data[y][x][z] != '\0';
    }

}

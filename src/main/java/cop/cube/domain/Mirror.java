package cop.cube.domain;

/**
 * @author Oleg Cherednik
 * @since 13.04.2018
 */
@SuppressWarnings("MethodCanBeVariableArityMethod")
public enum Mirror {
    OFF {
        @Override
        public void apply(boolean[][] mask) {
        }
    },
    HORIZONTAL {
        @Override
        public void apply(boolean[][] mask) {
            if (mask == null)
                return;

            final int width = mask.length;

            for (int y1 = 0, y2 = width - 1; y1 < y2; y1++, y2--)
                for (int x = 0; x < width; x++)
                    swap(x, y1, x, y2, mask);
        }
    };

    public abstract void apply(boolean[][] mask);

    protected static void swap(int x1, int y1, int x2, int y2, boolean[][] mask) {
        boolean tmp = mask[y1][x1];
        mask[y1][x1] = mask[y2][x2];
        mask[y2][x2] = tmp;
    }
}

package reverse;

import java.util.Arrays;

/**
 * ReverseMinC
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseMinC extends BaseReverse {

  public static final void main(final String[] args) {
    new ReverseMinC().run();
  }

  @Override
  protected final void printMatrix(final int[][] matrix) {
    int maxCols = 0;
    for (final int[] row : matrix) {
      maxCols = Math.max(maxCols, row.length);
    }

    final int[] colMin = new int[maxCols];
    Arrays.fill(colMin, Integer.MAX_VALUE);

    final int[][] result = new int[matrix.length][];

    for (int i = matrix.length - 1; i >= 0; i--) {
      final int[] row = matrix[i];

      for (int j = 0; j < row.length; j++) {
        colMin[j] = Math.min(colMin[j], row[j]);
      }

      final int[] out = new int[row.length];
      for (int j = 0; j < row.length; j++) {
        out[j] = colMin[j];
      }
      result[i] = out;
    }

    final StringBuilder out = new StringBuilder();
    for (final int[] row : result) {
      out.setLength(0);
      for (final int v : row) {
        if (!out.isEmpty()) {
          out.append(" ");
        }
        out.append(v);
      }
      System.out.println(out);
    }
  }
}

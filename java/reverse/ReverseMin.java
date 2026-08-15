package reverse;

import java.util.Arrays;

/**
 * ReverseMin
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseMin extends BaseReverse {

  public static final void main(final String[] args) {
    new ReverseMin().run();
  }

  @Override
  protected final void printMatrix(final int[][] matrix) {
    int maxCols = 0;
    for (final int[] row : matrix) {
      maxCols = Math.max(maxCols, row.length);
    }

    final int[] cs = new int[maxCols];
    final int[] cc = new int[maxCols + 1];
    Arrays.fill(cs, Integer.MAX_VALUE);
    Arrays.fill(cc, Integer.MAX_VALUE);

    final int[][] result = new int[matrix.length][];

    for (int i = matrix.length - 1; i >= 0; i--) {
      final int[] row = matrix[i];
      for (int j = row.length - 1; j >= 0; j--) {
        cs[j] = Math.min(cs[j], row[j]);
        cc[j] = Math.min(cc[j + 1], cs[j]);
      }
      result[i] = Arrays.copyOf(cc, row.length);
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

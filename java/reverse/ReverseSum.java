package reverse;

/**
 * ReverseSum
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseSum extends BaseReverse {

  public static final void main(final String[] args) {
    new ReverseSum().run();
  }

  @Override
  protected final void printMatrix(final int[][] matrix) {
    int maxCols = 0;
    for (final int[] row : matrix) {
      maxCols = Math.max(maxCols, row.length);
    }

    final int[] colSum = new int[maxCols];

    for (final int[] row : matrix) {
      for (int j = 0; j < row.length; j++) {
        colSum[j] += row[j];
      }
    }

    final StringBuilder out = new StringBuilder();
    for (final int[] row : matrix) {
      int rowSum = 0;
      for (final int v : row) {
        rowSum += v;
      }

      out.setLength(0);
      for (int j = 0; j < row.length; j++) {
        final int sum = rowSum + colSum[j] - row[j];

        if (!out.isEmpty()) {
          out.append(" ");
        }
        out.append(sum);
      }
      System.out.println(out);
    }
  }
}

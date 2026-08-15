package reverse;

/**
 * ReverseAvg
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseAvg extends BaseReverse {

  public static final void main(final String[] args) {
    new ReverseAvg().run();
  }

  @Override
  protected final void printMatrix(final int[][] matrix) {
    int maxCols = 0;
    for (final int[] row : matrix) {
      maxCols = Math.max(maxCols, row.length);
    }

    final long[] colSum = new long[maxCols];
    final int[] colCount = new int[maxCols];

    for (final int[] row : matrix) {
      for (int j = 0; j < row.length; j++) {
        colSum[j] += row[j];
        colCount[j]++;
      }
    }

    final StringBuilder out = new StringBuilder();
    for (final int[] row : matrix) {
      long rowSum = 0;
      for (final int v : row) {
        rowSum += v;
      }
      final int rowLen = row.length;

      out.setLength(0);
      for (int j = 0; j < row.length; j++) {
        final long sum = rowSum + colSum[j] - row[j];
        final int count = rowLen + colCount[j] - 1;

        if (!out.isEmpty()) {
          out.append(" ");
        }
        out.append(sum / count);
      }
      System.out.println(out);
    }
  }
}

package reverse;

/**
 * ReverseRotate
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseRotate extends BaseReverse {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new ReverseRotate().run();
  }

  @Override
  protected final void printMatrix(final int[][] matrix) {
    final int columns = matrix.length;

    int rows = 0;
    for (int[] row : matrix) {
      rows = Math.max(rows, row.length);
    }

    int[] rowSize = new int[rows + 1];
    for (int[] row : matrix) {
      if (row.length > 0) {
        rowSize[0]++;
        if (row.length < rows) {
          rowSize[row.length]--;
        }
      }
    }
    for (int i = 1; i < rows; i++) {
      rowSize[i] += rowSize[i - 1];
    }

    int[][] output = new int[rows][];
    for (int i = 0; i < rows; i++) {
      output[i] = new int[rowSize[i]];
    }
    int[] fillPos = new int[rows];

    for (int j = columns - 1; j >= 0; j--) {
      final int[] row = matrix[j];
      for (int i = 0; i < row.length; i++) {
        output[i][fillPos[i]++] = row[i];
      }
    }

    final StringBuilder out = new StringBuilder();
    for (int i = 0; i < rows; i++) {
      out.setLength(0);
      for (int v : output[i]) {
        if (!out.isEmpty()) {
          out.append(" ");
        }
        out.append(v);
      }
      System.out.println(out);
    }
  }
}

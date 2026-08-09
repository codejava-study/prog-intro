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

  /**
   * (non-Javadoc)
   *
   * @see reverse.BaseReverse#printMatrix(int[][])
   */
  @Override
  protected final void printMatrix(final int[][] matrix) {
    int rows = 0;
    final int columns = matrix.length;

    for (int i = 0; i < matrix.length; i++) {
      rows = Math.max(rows, matrix[i].length);
    }

    for (int i = 0; i < rows; i++) {

      final StringBuilder out = new StringBuilder();
      for (int j = columns - 1; j >= 0; j--) {

        if (matrix[j].length > i) {
          if (!out.isEmpty()) {
            out.append(" ");
          }
          out.append(matrix[j][i]);
        }
      }

      System.out.println(out.toString());
    }
  }
}

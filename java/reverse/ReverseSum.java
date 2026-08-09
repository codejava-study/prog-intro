package reverse;

/**
 * ReverseSum
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseSum extends BaseReverse {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new ReverseSum().run();
  }

  /**
   * (non-Javadoc)
   *
   * @see reverse.BaseReverse#printMatrix(int[][])
   */
  @Override
  protected final void printMatrix(final int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {

      final StringBuilder out = new StringBuilder();
      for (int j = 0; j < matrix[i].length; j++) {

        int sum = -matrix[i][j];

        for (int k = 0; k < matrix.length; k++) {
          if (matrix[k].length > j) {
            sum += matrix[k][j];
          }
        }

        for (int k = 0; k < matrix[i].length; k++) {
          sum += matrix[i][k];
        }

        if (!out.isEmpty()) {
          out.append(" ");
        }
        out.append(sum);
      }

      System.out.println(out.toString());
    }
  }
}

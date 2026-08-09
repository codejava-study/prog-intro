package reverse;

/**
 * ReverseMaxC
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseMaxC extends BaseReverse {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new ReverseMaxC().run();
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

        int max = matrix[i][j];

        for (int k = i; k < matrix.length; k++) {
          if (matrix[k].length > j) {
            max = Math.max(max, matrix[k][j]);
          }
        }

        if (!out.isEmpty()) {
          out.append(" ");
        }
        out.append(max);
      }

      System.out.println(out.toString());
    }
  }
}

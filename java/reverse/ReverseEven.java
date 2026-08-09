package reverse;

/**
 * ReverseEven
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseEven extends BaseReverse {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new ReverseEven().run();
  }

  /**
   * (non-Javadoc)
   *
   * @see reverse.BaseReverse#printMatrix(int[][])
   */
  @Override
  protected final void printMatrix(final int[][] matrix) {
    for (int i = matrix.length - 1; i >= 0; i--) {
      final int[] row = matrix[i];

      if (row.length == 0) {
        System.out.println();
      } else {
        final StringBuilder out = new StringBuilder();
        for (int j = row.length - 1; j >= 0; j--) {
          if ((i + j) % 2 == 0) {
            if (!out.isEmpty()) {
              out.append(" ");
            }
            out.append(row[j]);
          }
        }

        System.out.println(out.toString());
      }
    }
  }
}

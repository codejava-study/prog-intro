package reverse;

/**
 * Reverse
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class Reverse extends BaseReverse {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new Reverse().run();
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

      final StringBuilder out = new StringBuilder();
      for (int j = row.length - 1; j >= 0; j--) {
        if (!out.isEmpty()) {
          out.append(" ");
        }
        out.append(row[j]);
      }

      System.out.println(out.toString());
    }
  }
}

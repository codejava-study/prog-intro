package reverse;

/**
 * ReverseMax
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseMax extends BaseReverse {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new ReverseMax().run();
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
          for (int l = j; l < matrix[k].length; l++) {
            max = Math.max(max, matrix[k][l]);
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

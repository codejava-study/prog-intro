package reverse;

/**
 * ReverseAvg
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class ReverseAvg extends BaseReverse {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new ReverseAvg().run();
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

        long sum = -matrix[i][j];
        int count = -1;

        for (int k = 0; k < matrix.length; k++) {
          if (matrix[k].length > j) {
            sum += matrix[k][j];
            count++;
          }
        }

        for (int k = 0; k < matrix[i].length; k++) {
          sum += matrix[i][k];
          count++;
        }

        if (!out.isEmpty()) {
          out.append(" ");
        }
        out.append(sum / count);
      }

      System.out.println(out.toString());
    }
  }
}

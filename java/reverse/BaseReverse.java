package reverse;

/**
 * BaseReverse
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public abstract class BaseReverse {
  protected final void run() {
    final int[][] matrix = ReverseUtil.readData();
    printMatrix(matrix);
  }

  /**
   * @param matrix
   */
  protected abstract void printMatrix(int[][] matrix);
}

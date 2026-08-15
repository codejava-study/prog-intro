package reverse;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * BaseReverse
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public abstract class BaseReverse {
  protected final void run() {

    final PrintStream buffered =
        new PrintStream(new BufferedOutputStream(System.out, 1 << 16), false);
    System.setOut(buffered);

    try {
      int[][] matrix = ReverseUtil.readData();
      printMatrix(matrix);
    } catch (IOException e) {
      System.out.println("General IO exception occurer, reason: " + e.getMessage());
    } finally {
      buffered.flush();
    }
  }

  /**
   * @param matrix
   */
  protected abstract void printMatrix(int[][] matrix);
}

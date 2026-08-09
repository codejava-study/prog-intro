package reverse;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ReverseUtil
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public class ReverseUtil {

  /**
   * @return
   */
  public static int[][] readData() {
    final Scanner sc = new Scanner(System.in);
    final StringBuilder sb = new StringBuilder();
    int[][] matrix = new int[0][];
    int rowPos = 0;

    while (sc.hasNextLine()) {
      final String line = sc.nextLine();
      int[] lineNumbers = new int[0];
      int linePos = 0;

      for (final char ch : line.toCharArray()) {
        if (!Character.isWhitespace(ch)) {
          sb.append(ch);
        } else {
          if (!sb.isEmpty()) {
            final int number = Integer.parseInt(sb.toString());
            lineNumbers = add(number, lineNumbers, linePos++);
            sb.setLength(0);
          }
        }
      }

      if (!sb.isEmpty()) {
        final int number = Integer.parseInt(sb.toString());
        lineNumbers = add(number, lineNumbers, linePos++);
        sb.setLength(0);
      }

      lineNumbers = Arrays.copyOf(lineNumbers, linePos);
      matrix = add(lineNumbers, matrix, rowPos++);
    }
    sc.close();

    return Arrays.copyOf(matrix, rowPos);
  }

  /**
   * @param lineNumbers
   * @param matrix
   * @param at
   * @return
   */
  private static int[][] add(final int[] lineNumbers, int[][] matrix, final int at) {
    if (at >= matrix.length) {
      matrix = Arrays.copyOf(matrix, (matrix.length + 1) * 2);
    }

    matrix[at] = lineNumbers;
    return matrix;
  }

  /**
   * @param number
   * @param lineNumbers
   * @param at
   * @return
   */
  private static int[] add(final int number, int[] lineNumbers, final int at) {
    if (at >= lineNumbers.length) {
      lineNumbers = Arrays.copyOf(lineNumbers, (lineNumbers.length + 1) * 2);
    }

    lineNumbers[at] = number;
    return lineNumbers;
  }

  private ReverseUtil() {}
}

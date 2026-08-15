package reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * ReverseUtil
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public class ReverseUtil {

  private static final int BUFFER_SIZE = 8096;

  /**
   * @return
   * @throws IOException
   */
  public static int[][] readData() throws IOException {

    final Reader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

    final StringBuilder sb = new StringBuilder();
    int[][] matrix = new int[0][];
    int[] lineNumbers = new int[0];
    int pos = 0;

    int lineNumber = 0;

    char[] buffer = new char[BUFFER_SIZE];
    int read = reader.read(buffer);

    while (read != -1) {

      for (int i = 0; i < read; i++) {

        char ch = buffer[i];

        if (ch == '\n') {
          if (!sb.isEmpty()) {
            final String stringNumber = sb.toString().toLowerCase();
            final int number;
            if (stringNumber.endsWith("o")) {
              number =
                  new BigInteger(stringNumber.substring(0, stringNumber.length() - 1), 8)
                      .intValue();
            } else {
              number = Integer.parseInt(stringNumber);
            }
            lineNumbers = add(number, lineNumbers, pos++);
            sb.setLength(0);
          }

          lineNumbers = Arrays.copyOf(lineNumbers, pos);
          matrix = add(lineNumbers, matrix, lineNumber++);

          lineNumbers = new int[0];
          pos = 0;
        }

        if (isValidChar(ch)) {
          sb.append(ch);
        } else {
          if (!sb.isEmpty()) {
            final String stringNumber = sb.toString().toLowerCase();
            final int number;
            if (stringNumber.endsWith("o")) {
              number =
                  new BigInteger(stringNumber.substring(0, stringNumber.length() - 1), 8)
                      .intValue();
            } else {
              number = Integer.parseInt(stringNumber);
            }
            lineNumbers = add(number, lineNumbers, pos++);
            sb.setLength(0);
          }
        }
      }
      read = reader.read(buffer);
    }

    return Arrays.copyOf(matrix, lineNumber);
  }

  private static boolean isValidChar(char ch) {
    return (!Character.isWhitespace(ch))
        && (Character.getType(ch) != Character.START_PUNCTUATION)
        && (Character.getType(ch) != Character.END_PUNCTUATION);
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

package sum;

/**
 * Summator
 *
 * @param <T>
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public abstract class Summator<T> {

  /**
   * @return
   */
  protected abstract T zero();

  /**
   * @param s
   * @return
   */
  protected abstract T parse(final String s);

  /**
   * @param a
   * @param b
   * @return
   */
  protected abstract T add(final T a, final T b);

  /**
   * @param args
   */
  protected final void run(final String[] args) {
    final StringBuilder sb = new StringBuilder();
    T sum = zero();

    for (final String arg : args) {
      for (final char ch : arg.toCharArray()) {
        if (!Character.isWhitespace(ch)) {
          sb.append(ch);
        } else {
          sum = updateSum(sum, sb);
        }
      }
      sum = updateSum(sum, sb);
    }

    System.out.println(sum);
  }

  /**
   * @param sum
   * @param sb
   * @return
   */
  protected final T updateSum(T sum, final StringBuilder sb) {
    if (!sb.isEmpty()) {
      sum = add(sum, parse(sb.toString()));
      sb.setLength(0);
    }

    return sum;
  }
}

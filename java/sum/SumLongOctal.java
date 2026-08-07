package sum;

import java.math.BigInteger;

/**
 * SumLongOctal
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class SumLongOctal extends Summator<Long> {
  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new SumLongOctal().run(args);
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#zero()
   */
  @Override
  protected final Long zero() {
    return 0L;
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#parse(java.lang.String)
   */
  @Override
  protected final Long parse(String s) {
    s = s.toLowerCase();

    if (s.endsWith("o")) {
      return new BigInteger(s.substring(0, s.length() - 1), 8).longValue();

    } else {
      return Long.parseLong(s);
    }
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#add(java.lang.Object, java.lang.Object)
   */
  @Override
  protected Long add(final Long a, final Long b) {
    return a + b;
  }
}

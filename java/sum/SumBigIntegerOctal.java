package sum;

import java.math.BigInteger;

/**
 * SumBigIntegerOctal
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class SumBigIntegerOctal extends Summator<BigInteger> {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new SumBigIntegerOctal().run(args);
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#zero()
   */
  @Override
  protected final BigInteger zero() {
    return BigInteger.ZERO;
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#parse(java.lang.String)
   */
  @Override
  protected final BigInteger parse(String s) {

    s = s.toLowerCase();

    if (s.endsWith("o")) {
      return new BigInteger(s.substring(0, s.length() - 1), 8);
    } else {
      return new BigInteger(s);
    }
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#add(java.lang.Object, java.lang.Object)
   */
  @Override
  protected BigInteger add(final BigInteger a, final BigInteger b) {
    return a.add(b);
  }
}

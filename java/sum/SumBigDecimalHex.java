package sum;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * SumBigDecimalHex
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class SumBigDecimalHex extends Summator<BigDecimal> {

  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new SumBigDecimalHex().run(args);
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#zero()
   */
  @Override
  protected final BigDecimal zero() {
    return BigDecimal.ZERO;
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#parse(java.lang.String)
   */
  @Override
  protected final BigDecimal parse(String s) {
    s = s.toLowerCase();

    if (s.startsWith("0x")) {
      s = s.substring(2);

      if (s.contains("s")) {
        final int sIndex = s.indexOf("s");

        final BigInteger mantissa = new BigInteger(s.substring(0, sIndex), 16);
        final BigInteger exponent = new BigInteger(s.substring(sIndex + 1), 16);

        return new BigDecimal(mantissa).scaleByPowerOfTen(exponent.negate().intValueExact());

      } else {
        return new BigDecimal(new BigInteger(s, 16));
      }

    } else {
      return new BigDecimal(s);
    }
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#add(java.lang.Object, java.lang.Object)
   */
  @Override
  protected final BigDecimal add(final BigDecimal a, final BigDecimal b) {
    return a.add(b);
  }
}

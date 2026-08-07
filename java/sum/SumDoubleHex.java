package sum;

/**
 * SumDoubleHex
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class SumDoubleHex extends Summator<Double> {
  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new SumDoubleHex().run(args);
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#zero()
   */
  @Override
  protected final Double zero() {
    return 0.0;
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#parse(java.lang.String)
   */
  @SuppressWarnings("removal")
  @Override
  protected final Double parse(String s) {
    s = s.toLowerCase();

    if (s.startsWith("0x")) {
      if (s.contains(".")) {
        return Double.parseDouble(s);
      } else {
        return new Long(Long.parseLong(s.substring(2), 16)).doubleValue();
      }
    } else {
      return Double.parseDouble(s);
    }
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#add(java.lang.Object, java.lang.Object)
   */
  @Override
  protected final Double add(final Double a, final Double b) {
    return a + b;
  }
}

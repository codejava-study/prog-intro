package sum;

/**
 * SumHex
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class SumHex extends Summator<Integer> {
  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new SumHex().run(args);
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#zero()
   */
  @Override
  protected final Integer zero() {
    return 0;
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#parse(java.lang.String)
   */
  @SuppressWarnings("removal")
  @Override
  protected final Integer parse(String s) {
    s = s.toLowerCase();

    if (s.startsWith("0x")) {
      return new Long(Long.parseLong(s.substring(2), 16)).intValue();
    } else {
      return Integer.parseInt(s);
    }
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#add(java.lang.Object, java.lang.Object)
   */
  @Override
  protected final Integer add(final Integer a, final Integer b) {
    return a + b;
  }
}

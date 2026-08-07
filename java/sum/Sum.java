package sum;

/**
 * Sum
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class Sum extends Summator<Integer> {
  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new Sum().run(args);
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
  @Override
  protected final Integer parse(final String s) {
    return Integer.parseInt(s);
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

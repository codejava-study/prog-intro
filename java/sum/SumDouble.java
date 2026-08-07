package sum;

/**
 * SumDouble
 *
 * @author Doschennikov Nikita (doschennicovn@gmail.com)
 */
public final class SumDouble extends Summator<Double> {
  /**
   * @param args
   */
  public static final void main(final String[] args) {
    new SumDouble().run(args);
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
  @Override
  protected final Double parse(final String s) {
    return Double.parseDouble(s);
  }

  /**
   * (non-Javadoc)
   *
   * @see Summator#add(java.lang.Object, java.lang.Object)
   */
  @Override
  protected Double add(final Double a, final Double b) {
    return a + b;
  }
}

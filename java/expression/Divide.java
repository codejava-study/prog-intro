package expression;

import java.math.BigDecimal;
import java.math.BigInteger;

/** Divide */
public class Divide extends BinaryExpression {

  public Divide(AnyExpression left, AnyExpression right) {
    super(left, right);
  }

  @Override
  protected int apply(int a, int b) {
    return a / b;
  }

  @Override
  protected String operationSymbol() {
    return "/";
  }

  @Override
  protected BigInteger apply(BigInteger a, BigInteger b) {
    return a.divide(b);
  }

  @Override
  protected BigDecimal apply(BigDecimal a, BigDecimal b) {
    return a.divide(b);
  }

  @Override
  public int priority() {
    return 2;
  }

  @Override
  public boolean isConstOrVariable() {
    return false;
  }

  @Override
  public boolean isLeftAssociative() {
    return false;
  }
}

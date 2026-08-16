package expression.exceptions;

import expression.AnyExpression;
import expression.BinaryExpression;
import java.math.BigDecimal;
import java.math.BigInteger;

/** CheckedSubtract */
public class CheckedSubtract extends BinaryExpression {

  public CheckedSubtract(AnyExpression left, AnyExpression right) {
    super(left, right);
  }

  @Override
  protected int apply(int a, int b) {
    return a - b;
  }

  @Override
  protected String operationSymbol() {
    return "-";
  }

  @Override
  protected BigInteger apply(BigInteger a, BigInteger b) {
    return a.subtract(b);
  }

  @Override
  protected BigDecimal apply(BigDecimal a, BigDecimal b) {
    return a.subtract(b);
  }

  @Override
  public int priority() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'priority'");
  }

  @Override
  public boolean isConstOrVariable() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isConstOrVariable'");
  }

  @Override
  public boolean isLeftAssociative() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isLeftAssociative'");
  }
}

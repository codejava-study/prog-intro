package expression.exceptions;

import expression.Expression;
import expression.UnaryExpression;

/** CheckedNegate */
public class CheckedNegate extends UnaryExpression {

  public CheckedNegate(Expression right) {
    super(right);
  }
}

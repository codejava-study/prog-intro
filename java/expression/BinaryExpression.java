package expression;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/** BinaryExpression */
public abstract class BinaryExpression implements AnyExpression {
  private final AnyExpression left;
  private final AnyExpression right;

  public BinaryExpression(AnyExpression left, AnyExpression right) {
    this.left = left;
    this.right = right;
  }

  protected abstract int apply(int a, int b);

  protected abstract BigInteger apply(BigInteger a, BigInteger b);

  protected abstract BigDecimal apply(BigDecimal a, BigDecimal b);

  protected abstract String operationSymbol();

  protected boolean canOmitRightParens(AnyExpression right) {
    return false;
  }

  @Override
  public String toString() {
    return "(" + left.toString() + " " + operationSymbol() + " " + right.toString() + ")";
  }

  @Override
  public String toMiniString() {
    final int leftPriority = left.priority();
    final int thisPriority = this.priority();
    final int rightPriority = right.priority();

    final StringBuilder miniString = new StringBuilder();

    if ((leftPriority < thisPriority) && !left.isConstOrVariable()) {
      miniString.append("(" + left.toMiniString() + ")");
    } else {
      miniString.append(left.toMiniString());
    }

    miniString.append(" " + operationSymbol() + " ");

    if (((thisPriority > rightPriority)
            || ((thisPriority == rightPriority) && !canOmitRightParens(right)))
        && !right.isConstOrVariable()) {
      miniString.append("(" + right.toMiniString() + ")");
    } else {
      miniString.append(right.toMiniString());
    }

    return miniString.toString();
  }

  @Override
  public int evaluate(int x) {
    return apply(left.evaluate(x), right.evaluate(x));
  }

  @Override
  public int evaluate(int x, int y, int z) {
    return apply(left.evaluate(x, y, z), right.evaluate(x, y, z));
  }

  @Override
  public int evaluate(List<Integer> variables) {
    return apply(left.evaluate(variables), right.evaluate(variables));
  }

  @Override
  public BigInteger evaluateBi(List<BigInteger> variables) {
    return apply(left.evaluateBi(variables), right.evaluateBi(variables));
  }

  @Override
  public BigDecimal evaluateBd(List<BigDecimal> variables) {
    return apply(left.evaluateBd(variables), right.evaluateBd(variables));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = (left == null) ? 0 : left.hashCode();
    result = prime * result + ((right == null) ? 0 : right.hashCode());
    result = prime * result + operationSymbol().hashCode();
    result ^= (result >>> 16);
    result *= 0x85ebca6b;
    result ^= (result >>> 13);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    BinaryExpression other = (BinaryExpression) obj;
    if (left == null) {
      if (other.left != null) return false;
    } else if (!left.equals(other.left)) return false;
    if (right == null) {
      if (other.right != null) return false;
    } else if (!right.equals(other.right)) return false;
    return true;
  }
}

package expression;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/** Const */
public class Const implements AnyExpression {

  private int c;
  private BigInteger bi;
  private BigDecimal bd;
  private final String stringRepresentation;

  public Const(int c) {
    this.c = c;
    this.stringRepresentation = String.valueOf(c);
  }

  public Const(BigInteger bi) {
    this.c = bi.intValue();
    this.bi = bi;
    this.stringRepresentation = bi.toString();
  }

  public Const(BigDecimal bd) {
    this.c = bd.intValue();
    this.bd = bd;
    this.stringRepresentation = bd.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
        prime * result + ((stringRepresentation == null) ? 0 : stringRepresentation.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Const other = (Const) obj;
    if (stringRepresentation == null) {
      if (other.stringRepresentation != null) return false;
    } else if (!stringRepresentation.equals(other.stringRepresentation)) return false;
    return true;
  }

  @Override
  public String toString() {
    return stringRepresentation;
  }

  @Override
  public String toMiniString() {
    return toString();
  }

  @Override
  public int evaluate(int x) {
    return c;
  }

  @Override
  public int evaluate(int x, int y, int z) {
    return c;
  }

  @Override
  public int evaluate(List<Integer> variables) {
    return c;
  }

  @Override
  public BigInteger evaluateBi(List<BigInteger> variables) {
    return bi;
  }

  @Override
  public BigDecimal evaluateBd(List<BigDecimal> variables) {
    return bd;
  }

  @Override
  public int priority() {
    return Integer.MIN_VALUE;
  }

  @Override
  public boolean isConstOrVariable() {
    return true;
  }

  @Override
  public boolean isLeftAssociative() {
    return true;
  }
}

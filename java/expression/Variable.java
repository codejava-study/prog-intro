package expression;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/** Variable */
public class Variable implements AnyExpression {
  private final String variableName;
  private int number;

  public Variable(String variableName) {
    this.variableName = variableName;
  }

  public Variable(int number) {
    this.number = number;
    this.variableName = "$" + number;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((variableName == null) ? 0 : variableName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Variable other = (Variable) obj;
    if (variableName == null) {
      if (other.variableName != null) return false;
    } else if (!variableName.equals(other.variableName)) return false;
    return true;
  }

  @Override
  public int evaluate(int x) {
    return x;
  }

  @Override
  public int evaluate(int x, int y, int z) {
    return switch (variableName) {
      case "x" -> x;
      case "y" -> y;
      case "z" -> z;
      default -> {
        throw new AssertionError("Unknown variable name: " + variableName);
      }
    };
  }

  @Override
  public int evaluate(List<Integer> variables) {
    return variables.get(number);
  }

  @Override
  public String toString() {
    return variableName;
  }

  @Override
  public String toMiniString() {
    return toString();
  }

  @Override
  public BigDecimal evaluateBd(List<BigDecimal> variables) {
    return variables.get(number);
  }

  @Override
  public BigInteger evaluateBi(List<BigInteger> variables) {
    return variables.get(number);
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

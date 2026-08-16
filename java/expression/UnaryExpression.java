package expression;

/** UnaryExpression */
public abstract class UnaryExpression implements Expression {
  private final Expression right;

  public UnaryExpression(Expression right) {
    this.right = right;
  }

  @Override
  public int evaluate(int x) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'evaluate'");
  }
}

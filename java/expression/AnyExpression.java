package expression;

/** AnyExpression */
public interface AnyExpression
    extends Expression,
        TripleExpression,
        ListExpression,
        BigDecimalListExpression,
        BigIntegerListExpression {

  int priority();

  boolean isConstOrVariable();

  boolean isLeftAssociative();
}

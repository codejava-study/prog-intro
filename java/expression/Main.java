package expression;

import java.math.BigInteger;
import java.util.List;

/** Main */
public class Main {

  public static void main(final String[] args) {

    System.out.println(
        new Subtract(new Multiply(new Const(2), new Variable("x")), new Const(3)).evaluate(5));

    System.out.println(
        new Subtract(new Multiply(new Const(2), new Variable("x")), new Const(3)).toString());

    System.out.println(
        new Multiply(new Const(2), new Variable("x"))
            .equals(new Multiply(new Const(2), new Variable("x"))));

    System.out.println(
        new Multiply(new Const(2), new Variable("x"))
            .equals(new Multiply(new Variable("x"), new Const(2))));

    System.out.println(
        new Subtract(new Add(new Variable("x"), new Variable("y")), new Const(1))
            .evaluate(2, 3, 5));

    System.out.println(
        new Subtract(new Add(new Variable("x"), new Variable("y")), new Const(1)).toString());

    System.out.println(
        new Subtract(new Add(new Variable(0), new Variable(1)), new Const(1))
            .evaluate(List.of(2, 3)));

    System.out.println(
        new Subtract(new Add(new Variable(0), new Variable(1)), new Const(1)).toString());

    System.out.println(
        new Subtract(new Add(new Variable(0), new Variable(1)), new Const(BigInteger.ONE))
            .evaluateBi(List.of(BigInteger.TWO, BigInteger.ONE.add(BigInteger.TWO))));

    System.out.println(
        new Subtract(new Add(new Variable(0), new Variable(1)), new Const(BigInteger.ONE))
            .toString());
  }
}

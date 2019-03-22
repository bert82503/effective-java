package effectivejava.third.chapter7.item42;

import java.util.function.DoubleBinaryOperator;

/**
 * Enum with function object fields & constant-specific behavior (Page 195)
 * 具有函数对象字段和常量特定行为的枚举
 *
 * @see DoubleBinaryOperator#applyAsDouble(double, double)
 */
public enum Operation {
    /**
     * 加法
     */
    PLUS  ("+", (x, y) -> x + y),
    /**
     * 减法
     */
    MINUS ("-", (x, y) -> x - y),
    /**
     * 乘法
     */
    TIMES ("*", (x, y) -> x * y),
    /**
     * 除法
     */
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator binaryOperator;

    Operation(String symbol, DoubleBinaryOperator binaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = binaryOperator;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return binaryOperator.applyAsDouble(x, y);
    }

    /**
     * Main method from Item 34 (Page 163)
     */
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}

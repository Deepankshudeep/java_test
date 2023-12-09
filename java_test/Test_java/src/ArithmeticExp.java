//Submitted by: Deepankshu Deep Singh
//ID: C0893296

// Abstract class for arithmetic expressions
abstract class ArithmeticExp {
    public abstract int evaluate();

    public abstract String toString();
}

/** This is the Main class */
class ArithmeticOperation {
    /** Constants for representing the types*/
    public static final int Enter_Number_value = 1;
    public static final int Enter_Sum_Value = 2;
    public static final int Enter_Multiply_value = 3;
    public static final int Enter_modulo_value = 4; // New type for modulo

    public static void main(String[] args) {
        // Constructing the expression 3 + 2 * 5 % 4
        ArithmeticExp term = new ModExp(
                new SumExp(
                        new NumberExp(3),
                        new ProductExp(
                                new NumberExp(2),
                                new NumberExp(5)
                        )
                ),
                new NumberExp(4)
        );

        System.out.println(term.toString() + " = " + term.evaluate());
    }
}

// Class creation for number
class NumberExp extends ArithmeticExp {
    private int value;

    public NumberExp(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

// Abstract binary expression class
abstract class BinaryExp extends ArithmeticExp {
    protected ArithmeticExp left;
    protected ArithmeticExp right;

    public BinaryExp(ArithmeticExp left, ArithmeticExp right) {
        this.left = left;
        this.right = right;
    }
}

// Class creation for sum
class SumExp extends BinaryExp {
    public SumExp(ArithmeticExp left, ArithmeticExp right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
    }
}

// Class creation for product
class ProductExp extends BinaryExp {
    public ProductExp(ArithmeticExp left, ArithmeticExp right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }
}

// Class creation for modulo
class ModExp extends BinaryExp {
    public ModExp(ArithmeticExp left, ArithmeticExp right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        int divisor = right.evaluate();
        if (divisor == 0) {
            System.out.println("Error: Division by zero");
            return 0; // or handle it differently as needed
        }
        return left.evaluate() % divisor;
    }

    @Override
    public String toString() {
        return left.toString() + " % " + right.toString();
    }
}


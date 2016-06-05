package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Multiply operation.
 */
public class Multiply
        extends GeneralOperation
        implements Operation {

    /**
     * Constructor.
     * @param op1
     * @param op2
     */
    public Multiply(int op1, int op2) {
        super(op1, op2);
    }

    /**
     * Performs calculate() method from Operation interface.
     * @return
     */
    public int[] calculate() {
        result[0] = argOne * argTwo;
        result[1] = 0;
        return result;
    }
}

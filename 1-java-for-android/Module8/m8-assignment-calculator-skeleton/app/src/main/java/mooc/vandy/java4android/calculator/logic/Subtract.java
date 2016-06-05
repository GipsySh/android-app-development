package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Subtract operation.
 */
public class Subtract
        extends GeneralOperation
        implements Operation {

    /**
     * Constructor.
     * @param op1
     * @param op2
     */
    public Subtract(int op1, int op2) {
        super(op1, op2);
    }

    /**
     * Performs calculate() method from Operation interface.
     * @return
     */
    public int[] calculate () {
        result[0] = argOne - argTwo;
        result[1] = 0;
        return result;
    }
}

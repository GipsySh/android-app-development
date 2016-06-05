package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Add operation.
 */
public class Add
        extends GeneralOperation
        implements Operation {

    /**
     * Constructor
     * @param op1
     * @param op2
     */
    public Add(int op1, int op2) {
        super(op1, op2);
    }

    /**
     * Performs calculate() method from Operation interface
     * @return
     */
    public int[] calculate() {
        result[0] = argOne + argTwo;
        result[1] = 0;
        return result;
    }

}

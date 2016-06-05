package mooc.vandy.java4android.calculator.logic;

/**
 * Perform the Divide operation.
 */
public class Divide
        extends GeneralOperation
        implements Operation {

    /**
     * Constructor.
     * @param op1
     * @param op2
     */
    public Divide(int op1, int op2) {
        super(op1, op2);
    }

    /**
     * Performs calculate() method from Operation interface.
     * @return
     */
    public int[] calculate () {
        result[0] = argOne / argTwo;
        result[1] = argOne % argTwo;
        return result;
    }

    /**
     * Overriden toString() method from GeneralOperation class.
     * @return
     */
    public String toString() {
        return (Integer.toString(result[0]) + " R: " + Integer.toString(result[1]));
    }
}

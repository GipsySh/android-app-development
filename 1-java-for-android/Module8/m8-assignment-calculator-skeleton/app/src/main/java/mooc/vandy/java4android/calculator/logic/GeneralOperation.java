package mooc.vandy.java4android.calculator.logic;

/**
 * Perform general operation.
 * Implement fields and methods that are common for all operations.
 */
public class GeneralOperation {

    // size of array contains the result:
    // 1st element - the quotient for division and the final result for others
    // 2d element  - the reminder for division, equals 0 for others
    protected static final int ARRAY_SIZE = 2;

    public int argOne;                          // the 1st argument
    public int argTwo;                          // the 2d argument
    public int[] result = new int[ARRAY_SIZE];  // result

    /**
     * Constructor.
     * @param op1
     * @param op2
     */
    public GeneralOperation(int op1, int op2) {
        argOne = op1;
        argTwo = op2;
    }

    /**
     * Overriden toString() method.
     * @return
     */
    public String toString() {
        return Integer.toString(result[0]);
    }
}

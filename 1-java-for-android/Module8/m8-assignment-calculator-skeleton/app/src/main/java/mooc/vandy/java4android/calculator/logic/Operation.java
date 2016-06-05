package mooc.vandy.java4android.calculator.logic;

/**
 * Defines the interface for calculations.
 */
public interface Operation {
    /**
     * Array contains calculations resuls:
     * int[0] - the quotient for division and the final result for others
     * int[1] - the reminder for division, equals 0 for others
     */
    public int[] calculate();
}

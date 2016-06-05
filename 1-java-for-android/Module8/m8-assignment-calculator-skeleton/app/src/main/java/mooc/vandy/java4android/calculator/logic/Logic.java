package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

/**
 * Performs an operation selected by the user.
 */
public class Logic 
       implements LogicInterface {

    static final int ADDITION       = 1;
    static final int SUBSTRACTION   = 2;
    static final int MULTIPLICATION = 3;
    static final int DIVSION        = 4;

    /**
     * Reference to the Activity output.
     */
    protected ActivityInterface mOut;

    /**
     * Constructor initializes the field.
     */
    public Logic(ActivityInterface out){
        mOut = out;
    }

    /**
     * Perform the @a operation on @a argumentOne and @a argumentTwo.
     */
    public void process(int argumentOne,
                        int argumentTwo,
                        int operation){
        // TODO -- start your code here

        switch (operation) {

            case ADDITION: {
                Add op = new Add(argumentOne, argumentTwo);
                op.result = op.calculate();
                mOut.print(op.toString());
                break;
            }

            case SUBSTRACTION: {
                Subtract op = new Subtract(argumentOne, argumentTwo);
                op.result = op.calculate();
                mOut.print(op.toString());
                break;
            }

            case MULTIPLICATION: {
                Multiply op = new Multiply(argumentOne, argumentTwo);
                op.result = op.calculate();
                mOut.print(op.toString());
                break;
            }

            case DIVSION: {
                Divide op = new Divide(argumentOne, argumentTwo);
                try {
                    op.result = op.calculate();
                    mOut.print(op.toString());
                }
                catch (ArithmeticException e) {
                    mOut.print("Error: " + e.getMessage());
                }
                break;
            }
        }

    }
}

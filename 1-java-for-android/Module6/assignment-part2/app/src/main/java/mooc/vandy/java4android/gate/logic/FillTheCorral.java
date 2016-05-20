package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- I added my code in here

    /**
     * Randomly sets the direction of each gate's swing.
     * @param gate
     * @param selectDirection
     */
    public void setCorralGates(Gate[] gate, Random selectDirection) {

        for (Gate item : gate) {
            if (selectDirection.nextBoolean()) item.open(Gate.IN);
            else  item.open(Gate.OUT);
        }

    }

    /**
     * Checks if there is any opened gate.
     * @param corral
     * @return
     */
    public boolean anyCorralAvailable(Gate[] corral) {

        boolean available = false;

        for (Gate gate : corral) {
            if (gate.getSwingDirection() == Gate.IN) {
                available = true;
                break;
            }
        }

        return available;
    }

    /**
     * Simulates moving snails from a pasture into corrals.
     * @param corral
     * @param rand
     * @return
     */
    public void corralSnails(Gate[] corral, Random rand) {
        int snailsMove;             // random count of snails to move to the corral
        int snailsPasture = 5;      // count of snails out to pasture
        int attempt = 0;            // count of snails movement attempt
        Gate gate;                  // selected gate
        int corralNumber;

        mOut.println("Initial gate setup:");

        for (int i=0; i<corral.length; i++)
            mOut.println("Gate " + i + ": " + corral[i]);

        while (snailsPasture>0) {

            snailsMove = rand.nextInt(5)+1;

            corralNumber = rand.nextInt(corral.length);
            gate = corral[corralNumber];

            if (!gate.isLocked()) {

                if (gate.getSwingDirection() == Gate.IN) {
                    snailsPasture = snailsPasture - gate.thru(snailsMove);
                }

                if (gate.getSwingDirection() == Gate.OUT) {
                    snailsPasture = snailsPasture + gate.thru(snailsMove);
                }

                mOut.println(snailsMove
                            + " are trying to move through corral "
                            + corralNumber);
            }
            attempt++;
        };

        mOut.println("It took "
                    + attempt
                    + " attempts to corral all of the snails.");
    }
    
}

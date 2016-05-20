package mooc.vandy.java4android.gate.logic;

import java.net.HttpRetryException;
import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Size of escargatoire (which is a nursery of snails)
     */
    public static final int HERD = 24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate eastGate,
                       Gate westGate) {
        mOut = out;

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);

        mWestGate = westGate;
        mWestGate.open(Gate.IN);
    }

    // TODO -- I added my code in here

    /**
     * Simulates moving of the snails.
     * @param rand
     */
    public void simulateHerd(Random rand) {

        int gateDirection;
        int movedCount;
        int countPen = HERD;                    // number of snails in the pen
        int countPasture = HERD - countPen;     // number of snails in the pasture

        Gate gate = new Gate();

        printHerdState(countPen, countPasture);

        for (int i=0; i<MAX_ITERATIONS; i++) {

            if (countPasture > 0) {
                gate = selectGate(rand);        // if there are some snails out to pasture
            }
            else
                gate = mEastGate;               // if there are no snails out to pasture open the exit gate

            // if enter (IN) gate is opened
            if (gate.equals(mWestGate)) {

                // generate random number of snails out to pasture to move
                movedCount = rand.nextInt(countPasture)+1;

                // in attempt to move snails more than it is in the pen, move all available
                if (movedCount > countPasture) {
                    countPen = HERD;
                    countPasture= HERD - countPen;
                }
                else {
                    countPen = countPen + gate.thru(movedCount);
                    countPasture = HERD - countPen;
                }
            }

            // if exit (OUT) gate is opened
            if (gate.equals(mEastGate)) {

                // generate random number of snails in the pen to move
                movedCount = rand.nextInt(countPen)+1;

                // in attempt to move snails more than it is in the pen, move all available
                if (movedCount > countPen) {
                    countPasture= HERD;
                    countPen = HERD - countPasture;
                }
                else {
                    countPasture = countPasture - gate.thru(movedCount);
                    countPen = HERD - countPasture;
                }
            }

            printHerdState(countPen, countPasture);
        }

    }

    /**
     * Randomly selects a gate.
     * @param rand
     * @return
     */
    private Gate selectGate(Random rand) {

        Gate gate = new Gate();

        if (rand.nextBoolean()) gate = mEastGate;
        else gate = mWestGate;

        return gate;
    }

    /**
     * Prints out the information about the herd state.
     * @param countPen
     * @param countPasture
     */
    private void printHerdState(int countPen, int countPasture) {
        mOut.println("There are currently "
                + countPen
                + " snails in the pen and "
                + countPasture
                + " snails in the pasture"
        );
    }

}

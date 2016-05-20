package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {

    // TODO -- Fill your code in here
    public static final int IN = 1;     // swing direction to inward
    public static final int OUT = -1;   // swing direction to outward

    private int mSwing;                 // indicates direction the gate is able to swing
    private boolean mLocked;            // indicates the locked gate state

    /**
     * Constructor initializes the fields.
     */
    public Gate() {
        mSwing = 0;
        mLocked = true;
    }

    /**
     * Sets direction the gate is able to swing
     * @param direction
     * @return
     */
    public boolean setSwing(int direction) {
        if (direction==IN || direction==OUT) {
            mSwing = direction;
            return true;
        }
        else
            return false;
    }

    /**
     * Gets direction the gate is able to swing
     * @return
     */
    public int getSwingDirection() {
        return mSwing;
    }

    /**
     * Sets the gate to opened state
     * @param direction
     * @return
     */
    public boolean open(int direction) {
        if (setSwing(direction)) {
            mLocked = false;
            return true;
        }
        else
            return false;
    }

    /**
     * Sets the gate to closed (locked) state
     */
    public void close() {
        mLocked = true;
        mSwing = 0;
    }

    /**
     * Checks if the gate is locked
     * @return
     */
    public boolean isLocked() {
        if (mLocked) return true;
        else return false;
    }

    /**
     * Returns the delta count depending on the gate's state
     * @param count
     * @return
     */
    public int thru(int count) {
        int deltaCount = 0;
        if (!mLocked) {
            if (mSwing == IN) deltaCount=count;
            if (mSwing == OUT) deltaCount=0-count;
        }
        return deltaCount;
    }

    /**
     * Overrides toString() method
     * @return
     */
    public String toString() {
        String msg = "";

        if (!mLocked) {
            if (mSwing == 0) msg = "This gate is not locked and swings but the swing is not set properly";
            if (mSwing == IN) msg = "This gate is not locked and swings to enter the pen only";
            if (mSwing == OUT) msg = "This gate is not locked and swings to exit the pen only";
        }
        else
            msg = "This gate is locked";
        return msg;
    }
}

package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    
    // TODO -- Fill in your code here

    public static final int IN = 1;     // swing direction to inward
    public static final int OUT = -1;   // swing direction to outward

    private int mSwing;                 // indicates direction the gate is able to swing
    private boolean mLocked;            // indicates the locked gate state

    public Gate() {
        mSwing = 0;
        mLocked = true;
    }

    /**
     * Set direction the gate is able to swing
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
     * Get direction the gate is able to swing
     * @return
     */
    public int getSwingDirection() {
        return mSwing;
    }

    /**
     *
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
     *
     */
    public void close() {
        mLocked = true;
        mSwing = 0;
    }

    /**
     *
     * @return
     */
    public boolean isLocked() {
        if (mLocked) return true;
        else return false;
    }

    /**
     *
     * @param count
     * @return
     */
    public int thru(int count) {
        int deltaCount = 0;
        if (!mLocked) {
            if (mSwing == IN) deltaCount=count;
            if (mSwing == OUT) deltaCount=-count;
        }
        return deltaCount;
    }

    /**
     *
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

package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage 
       extends House {

    private boolean mSecondFloor;

    /**
     * Constructor.
     * @param dimension
     * @param lotLength
     * @param lotWidth
     */
    public Cottage(int dimension, int lotLength, int lotWidth) {
        super(dimension, dimension, lotLength, lotWidth);
    }

    /**
     * Constructor.
     * @param dimension
     * @param lotLength
     * @param lotWidth
     * @param owner
     * @param secondFloor
     */
    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean secondFloor) {
        super(dimension, dimension, lotLength, lotWidth);
        super.mOwner = owner;
        mSecondFloor = secondFloor;
    }

    /**
     * Checks if the cottage has two floors.
     * @return
     */
    public boolean hasSecondFloor() {
        return mSecondFloor;
    }

    /**
     * Overrides the default toString() method.
     * @return
     */
    public String toString() {
        String msg;

        if (mSecondFloor)
            msg = super.toString() + "; is a two story cottage";
        else
            msg = super.toString() + "; is a cottage";

        return msg;
    }
    
}


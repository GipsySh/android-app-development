package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House 
       extends Building {
       
    protected String mOwner;
    protected boolean mPool;

    /**
     * Constructor.
     * @param length
     * @param width
     * @param lotLength
     * @param lotWidth
     */
    public House (int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
    }

    /**
     * Constructor.
     * @param length
     * @param width
     * @param lotLength
     * @param lotWidth
     * @param owner
     */
    public House (int length, int width, int lotLength, int lotWidth, String owner) {
        super(length, width, lotLength, lotWidth);
        mOwner = owner;
    }

    /**
     * Constructor.
     * @param length
     * @param width
     * @param lotLength
     * @param lotWidth
     * @param owner
     * @param pool
     */
    public House (int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        super(length, width, lotLength, lotWidth);
        mOwner = owner;
        mPool = pool;
    }

    /**
     * Gets the house owner.
     * @return
     */
    public String getOwner() {
        return mOwner;
    }

    /**
     * Checks if the house has a pool.
     * @return
     */
    public boolean hasPool() {
        return mPool;
    }

    /**
     * Sets the house owner.
     * @param owner
     */
    public void setOwner(String owner) {
        mOwner = owner;
    }

    /**
     * Sets if the house has a pool.
     * @param pool
     */
    public void setPool(boolean pool) {
        mPool = pool;
    }

    /**
     * Overrides the default toString() method.
     * @return
     */
    public String toString() {

        String msg = "Owner: ";

        if (mOwner == null)
            msg = msg + "n/a";
        else
            msg = msg + mOwner;

        if (mPool)
            msg = msg + "; has a pool";

        if (super.calcLotArea() > super.calcBuildingArea())
            msg = msg + "; has a big open space";

        return msg;
    }

    /**
     * Overrides the default equals() method.
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {

        boolean result = false;

        if (obj instanceof House) {
            result =    ( this.calcBuildingArea() == ((House) obj).calcBuildingArea() ) &&
                        ( this.calcLotArea() == ((House) obj).calcLotArea() );
        }

        return result;
    }
}

package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {

    private int mLength;
    private int mWidth;
    private int mLotLength;
    private int mLotWidth;

    /**
     * Constructor.
     * @param length
     * @param width
     * @param lotLength
     * @param lotWidth
     */
    public Building(int length, int width, int lotLength, int lotWidth) {
        mLength = length;
        mWidth = width;
        mLotLength = lotLength;
        mLotWidth = lotWidth;
    }

    /**
     * Gets the building length.
     * @return
     */
    public int getLength() {
        return mLength;
    }

    /**
     * Gets the building width.
     * @return
     */
    public int getWidth() {
        return mWidth;
    }

    /**
     * Gets the lot length.
     * @return
     */
    public int getLotLength() {
        return mLotLength;
    }

    /**
     * Gets the lot width.
     * @return
     */
    public int getLotWidth() {
        return mLotWidth;
    }

    /**
     * Set the building length.
     * @param length
     */
    public void setLength(int length) {
        mLength = length;
    }


    /**
     * Set the building width.
     * @param width
     */
    public void setWidth(int width) {
        mWidth = width;
    }

    /**
     * Set the lot length.
     * @param lotLength
     */
    public void setLotLength (int lotLength) {
        mLotLength = lotLength;
    }


    /**
     * Set the lot width.
     * @param lotWidth
     */
    public void setLotWidth (int lotWidth) {
        mLotWidth = lotWidth;
    }

    /**
     * Calculates the building area.
     * @return
     */
    public int calcBuildingArea() {
        return mLength * mWidth;
    }

    /**
     * Calculated the lot area.
     * @return
     */
    public int calcLotArea() {
        return mLotLength * mLotWidth;
    }

    /**
     * Overrides the default toString() method.
     * @return
     */
    public String toString() {
        String msg = "";

        return msg;
    }
    
}

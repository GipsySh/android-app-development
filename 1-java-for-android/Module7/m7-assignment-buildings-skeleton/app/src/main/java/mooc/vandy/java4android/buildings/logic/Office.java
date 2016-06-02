package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office 
       extends Building {

    private String mBusinessName;
    private int mParkingSpace;
    private static int sTotalOffices = 0;

    /**
     * Constructor.
     * @param length
     * @param width
     * @param lotLength
     * @param lotWidth
     */
    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        sTotalOffices += 1;
    }

    /**
     * Constructor.
     * @param length
     * @param width
     * @param lotLength
     * @param lotWidth
     * @param businessName
     */
    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        super(length, width, lotLength, lotWidth);
        mBusinessName = businessName;
        sTotalOffices += 1;
    }

    /**
     * Constructor.
     * @param length
     * @param width
     * @param lotLength
     * @param lotWidth
     * @param businessName
     * @param parkingSpace
     */
    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpace) {
        super(length, width, lotLength, lotWidth);
        mBusinessName = businessName;
        mParkingSpace = parkingSpace;
        sTotalOffices += 1;
    }

    /**
     * Gets the office name.
     * @return
     */
    public String getBusinessName() {
        return mBusinessName;
    }

    /**
     * Gets the parking spaces near the office.
     * @return
     */
    public int getParkingSpaces() {
        return mParkingSpace;
    }

    /**
     * Sets the ofiice name.
     */
    public void setBusinessName(String businessName) {
        mBusinessName = businessName;
    }

    /**
     * Sets the parking spaces near the office.
     * @param parkingSpace
     */
    public void setParkingSpaces(int parkingSpace) {
        mParkingSpace = parkingSpace;
    }

    /**
     * Overrides the default toString() method.
     * @return
     */
    public String toString() {

        String msg = "Business: ";

        if (mBusinessName == null)
            msg = msg + "unoccupied";
        else
            msg = msg + mBusinessName;

        if (mParkingSpace != 0)
            msg = msg + "; has " + mParkingSpace + " parking spaces";

        msg = msg + " (total offices: " + sTotalOffices + ")";
        return msg;
    }

    /**
     * Overrides the default equals() method.
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {

        boolean result = false;

        if (obj instanceof Office) {
            result =    ( this.calcBuildingArea() == ((Office) obj).calcBuildingArea() ) &&
                        ( this.mParkingSpace == ((Office) obj).getParkingSpaces() );
        }

        return result;
    }
    
}

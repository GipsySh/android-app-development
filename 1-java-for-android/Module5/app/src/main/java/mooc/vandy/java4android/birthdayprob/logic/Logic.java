package mooc.vandy.java4android.birthdayprob.logic;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import mooc.vandy.java4android.birthdayprob.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 *
 */
public class Logic implements LogicInterface {

    // This is a String to be used in Logging (if/when you decide you need it for debugging)
    public static final String TAG = Logic.class.getName();

    /*
    * This is the variable that stores our OutputInterface instance.
    * <p>
    * This is how we will interact with the User Interface [MainActivity.java].
    * <p>
    * it is called 'out' because it is where we 'out-put' our results. (It is also the 'in-put'
    * from where we get values from, but it only needs 1 name, and 'out' is good enough)
    */
    OutputInterface out;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface _out){
        out = _out;
    }

    /**
     * This is the method that will (eventually) get called when the on-screen button labelled
     * 'Process...' is pressed.
     */
    public void process() {

        int groupSize = out.getSize();
        int simulationCount = out.getCount();

        if (groupSize < 2 || groupSize > 365) {
            out.makeAlertToast("Group Size must be in the range 2-365.");
            return;
        }
        if (simulationCount <= 0) {
            out.makeAlertToast("Simulation Count must be positive.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        out.println("For a group of " + groupSize + " people, the percentage");
        out.println("of times that two people share the same birthday is");
        out.println(String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     */
    public double calculate(int size, int count) {

        // TODO -- I added my code here

        Integer intBirthdayDate;       // single random generated birthday date
        String strBirthdayDate; // single random generated birthday date a a String (for ArrayList)
        double percent;         // final result (in percentages)

        int matchCount = 0;     // a number of matched birthday dates

        // loop for simulations count
        for (int i=1; i<=count; i++) {

            Map<Integer,Integer> arrBirthday = new HashMap<Integer,Integer>(size);

            Random date = new Random();
            date.setSeed(i);

            // loop for persons in a group
            for (int j=1; j<=size; j++) {
                
                intBirthdayDate = date.nextInt(365);

                // if there are no matched birthdays
                if (!arrBirthday.containsValue(intBirthdayDate)) {
                    arrBirthday.put(Integer.valueOf(j),intBirthdayDate);
                }
                else {
                    matchCount++;       // increment the matched birthday
                    j = size+1;         // stop the loop for persons and go to the next simulation
                }
            }

        }

        percent = ((double)matchCount/count)*100.0;

        return percent;
       
    }

    // TODO -- I added my code here

    /**
     * This is the method that checks if the generated date matches with any element in the array.
     * <p>
     *      int element - generated date
     *      int[] arr   - array of dates
     */
    public boolean isInArray(int element, int[] arr) {
        boolean inArray = false;

        for (int i=0; i<arr.length; i++) {
           if (element==arr[i]) {
               inArray = true;
               i = arr.length;      // stop the loop
           }
        }

        return inArray;
    }

    /**
     * This is the method that fills the array elements by -1.
     * <p>
     *      int[] arr   - array for filling
     */
    public int[] cleanArray(int[] arr) {

        for (int i=0; i<arr.length; i++) {
            arr[i] = -1;
        }

        return arr;
    }
}

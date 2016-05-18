package mooc.vandy.java4android.diamonds.logic;

import android.provider.Settings;
import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        // TODO -- I added my code here

        // execute for each line
        for (int i=0; i<=size*2; i++) {

            // check if the 1st or the last line
            if ((i == 0) || (i == size * 2)) {
                for (int j=0; j<=size*2+1; j++) {
                    if (j == 0)                 // if the 1st character in the line
                        mOut.print("+");
                    else if (j == size * 2 + 1) // if the last character in the line
                        mOut.println("+");
                    else
                        mOut.print("-");
                }
            }

            else {
                mOut.print("|");    // print the left side of the picture frame

                // check if at the center of the diamond
                if (i == size) {
                    mOut.print("<");
                    fillDiamond(i, 2*(i-1));
                    mOut.print(">");
                }

                // check if the top half of the diamond
                else if (i < size) {
                    fillSpaces(size-i);
                    mOut.print("/");
                    fillDiamond(i, 2*(i-1));
                    mOut.print("\\");
                    fillSpaces(size-i);
                }

                // check if the bottom half of the diamond
                else if (i > size) {
                    fillSpaces(i%size);
                    mOut.print("\\");
                    fillDiamond(i, 2*(size-(i%size)-1));
                    mOut.print("/");
                    fillSpaces(i%size);
                }

                mOut.println("|");     // print the right side of the picture frame
            }

        }
    }

    // TODO -- I added my code here

    /**
     * This is the method that fills the diamond inside
     *      int lineNumber       - the current row number
     *      int charactersCount - the number of characters to fill
     *
     * The even row is filled by '-' charecters
     * The odd row is filled by '=' charaters
     */
    public void fillDiamond(int lineNumber, int charactersCount) {
        for (int k=0; k<charactersCount; k++) {
            if ((lineNumber % 2)==0)
                mOut.print("-");  // if even row print '-'
            else
                mOut.print("=");  // if odd row print '='
        }
    }

    /**
     * This is the method that fills space around the diamond
     *      int charactersCount - the number of characters to fill
     */
    public void fillSpaces(int charactersCount) {
        for (int k=0; k<charactersCount; k++)
            mOut.print(" ");
    }
}

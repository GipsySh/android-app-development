package mooc.vandy.java4android.buildings.logic;

import android.view.ViewDebug;

import java.io.FileNotFoundException;

import mooc.vandy.java4android.buildings.ui.OutputInterface;

/**
 * This Neighborhood utility class provides static helper methods the
 * print a Building List and calculate the area of a Building list.
 * A utility class in Java should always be final and have a private
 * constructor, as per https://en.wikipedia.org/wiki/Utility_class.
 */
public final class Neighborhood {

    /**
     * Constructor.
     */
    public Neighborhood() {
        // Utility classes should always be final and have a private constructor
    }

    /**
     * Prints the list of buildings.
     * @param buildings
     * @param header
     * @param out
     */
    public static void print(Building[] buildings, String header, OutputInterface out) {

        out.println(header);
        out.println("----------");

        for (Building item : buildings) {
            out.println(item.toString());
        }
    }

    /**
     * Calculates the total area of the lot of buildings.
     * @param buildings
     * @return
     */
    public static int calcArea(Building[] buildings) {

        int area = 0;

        for (Building item : buildings) {

            area = area + item.calcLotArea();
        }
        return area;
    }
    
}

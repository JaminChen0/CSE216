package geometry;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

/**
 * This class is given to you as an outline for testing your code. You can modify this as you want, but please keep in
 * mind that the lines already provided here as expected to work exactly as they are.
 *
 * @author Ritwik Banerjee
 */
public class GeometryTest {

    public static void main(String... args) {
        testRadialGraphSymmetries();
        testSquareSymmetries();
    }

    private static void testRadialGraphSymmetries() {
        /*Point center = new Point("center", 0, 0);
        Point east   = new Point("east", 1, 0);
        Point west   = new Point("west", -1, 0);
        Point north  = new Point("north", 0, 1);
        Point south  = new Point("south", 0, -1);

        RadialGraph g1 = new RadialGraph(center, Arrays.asList(north, south, east, west));
        RadialGraph g2 = g1.rotateBy(45);
        RadialGraph g3 = g1.rotateBy(360);
        RadialGraph g4 = g1.rotateBy(180);

        RadialGraphSymmetries graphSymmetries = new RadialGraphSymmetries();
        System.out.println(graphSymmetries.areSymmetric(g1, g2)); // must return false
        System.out.println(graphSymmetries.areSymmetric(g1, g3)); // must return true
        System.out.println(graphSymmetries.areSymmetric(g3, g4)); // must return true

        // obtain all the symmetries (including the identity) of g1, and print them one by one (remember that printing
        // will give the string representation of each radial graph, which must follow the specification of Shape's
        // toString() method)
        List<RadialGraph> symmetries = graphSymmetries.symmetriesOf(g1);
        for (RadialGraph g : symmetries) System.out.println(g);*/

        /*Point upright   = new Point("upright", 1, 1);
        Point upleft    = new Point("upleft", -1, 1);
        Point downleft  = new Point("downleft", -1, -1);
        Point downright = new Point("downright", 1, -1);
        Point east      = new Point("east", 1, 0);
        Point north     = new Point("north", 0, 1);
        Point west      = new Point("west", -1, 0);
        Point south     = new Point("south", 0, -1);

        Square sq1 =  new Square(upright, upleft, downleft, downright);
        Square sq2 = sq1.rotateBy(45);
        Square sq3 = sq1.rotateBy(90);
        System.out.println(sq3);
        Square sq4 = sq1.translateBy(1,1);
        System.out.println(sq4);

        Square sq5 =new Square(east, north, west, south);
        Square sq6 = sq1.rotateBy(90);
        System.out.println(sq6);
        Square sq7 = sq1.translateBy(0,-0.5);
        System.out.println(sq7);*/







    }

    private static void testSquareSymmetries() {

        /*Square sq1 = new Square(new Point("upper-right", 1, 1), new Point("upper-left", 0, 1),
                new Point("lower-left", 0, 0), new Point("lower-right", 1, 0));
        Square sq2 = sq1.rotateBy(30);
        Square sq3 = sq1.rotateBy(180);

        SquareSymmetries squareSymmetries = new SquareSymmetries();
        squareSymmetries.areSymmetric(sq1, sq2); // must return false
        squareSymmetries.areSymmetric(sq1, sq3); // must return true

        // obtain all the 8 symmetries (including the identity) of sq1, and print them one by one (remember that printing
        // will give the string representation of each square, which must follow the specification of Shape's toString()
        // method)
        List<Square> symmetries = squareSymmetries.symmetriesOf(sq1);
        for (Square s : symmetries) System.out.println(s);*/

        /*Point upright   = new Point("upright", 1, 1);
        Point upleft    = new Point("upleft", -1, 1);
        Point downleft  = new Point("downleft", -1, -1);
        Point downright = new Point("downright", 1, -1);
        Point east      = new Point("east", 1, 0);
        Point north     = new Point("north", 0, 1);
        Point west      = new Point("west", -1, 0);
        Point south     = new Point("south", 0, -1);

        Square sq1 =  new Square(upright, upleft, downleft, downright);
        Square sq2 = sq1.rotateBy(45);
        Square sq3 = sq1.rotateBy(90);
        System.out.println(sq3);
        Square sq4 = sq1.translateBy(1,1);
        System.out.println(sq4);

        Square sq5 =new Square(east, north, west, south);
        Square sq6 = sq1.rotateBy(90);
        System.out.println(sq6);
        Square sq7 = sq1.translateBy(0,-0.5);
        System.out.println(sq7);*/

        /*Point  origin       = new Point("origin", 0, 0);
        Point  right        = new Point("right", 1, 0);
        Point  upright      = new Point("upright", 1, 1);
        Point  up           = new Point("up", 0, 1);
        Square sq1 =  new Square(origin, right, upright, up);

        SquareSymmetries squareSymmetries = new SquareSymmetries();
        List<Square> symmetries = squareSymmetries.symmetriesOf(sq1);
        for (Square s : symmetries) System.out.println(s);*/

        /*Point  origin       = new Point("origin", 0, 0);
        Point  right        = new Point("right", 1, 0);
        Point  upright      = new Point("upright", 1, 1);
        Point  up           = new Point("up", 0, 1);
        Square sq1 = new Square(origin, right, upright, up);
        Square sq2 = new Square(new Point("up", 0, 0),new Point("upright", 1, 0),
                new Point("right", 1, 1),new Point("origin", 0, 1)) ;
        SquareSymmetries squareSymmetries = new SquareSymmetries();
        System.out.println(squareSymmetries.areSymmetric(sq1, sq2));*/
        Point  origin       = new Point("origin", 0, 0);
        Point  right        = new Point("right", 1, 0);
        Point  upright      = new Point("upright", 1, 1);
        Point  up           = new Point("up", 0, 1);
        Square sq1 =  new Square(origin, right, upright, up);
        SquareSymmetries squareSymmetries = new SquareSymmetries();
        List<Square> symmetries = squareSymmetries.symmetriesOf(sq1);
        for (Square s : symmetries) System.out.println(s);



    }
}

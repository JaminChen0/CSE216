package geometry;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Square extends Shape {

    Point center;
    List<Point> list = new ArrayList<>();
    @Override
    public Point center() {
        return center;
    }

    private void sortPointsByAngle(List<Point> list) {
        Comparator<Point> com = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double angle1 = (double)Math.round(Math.toDegrees(Math.atan2(o1.y - center.y, o1.x - center.x))*100)/100;
                double angle2 = (double)Math.round(Math.toDegrees(Math.atan2(o2.y - center.y, o2.x - center.x))*100)/100;

                // Normalize angles to the range of 0 to 360 degrees
                if (angle1 < 0) {
                    angle1 += 360;
                }
                if (angle2 < 0) {
                    angle2 += 360;
                }
                return (int) (angle1-angle2);
            }
        };

        Collections.sort(list, com);
    }
    @Override
    public Square rotateBy(int degrees) {
        double rad = Math.toRadians(degrees);

        List<Point> list2 = new ArrayList<>();
        for(int i=0; i< list.size(); i++) {
            Point temp = new Point(
                    list.get(i).name,
                    ((list.get(i).x - center.x) * Math.cos(rad) - (list.get(i).y - center.y) * Math.sin(rad)) + center.x,
                    ((list.get(i).x -center.x) * Math.sin(rad) + (list.get(i).y - center.y) * Math.cos(rad)) + center.y
            );
            list2.add(i,temp);
        }

        //sort
        sortPointsByAngle(list2);
        return new Square(list2.get(0), list2.get(1), list2.get(2), list2.get(3));
    }

    @Override
    public Square translateBy(double x, double y) {
        List<Point> list2 = new ArrayList<>();
        for(int i=0; i< list.size(); i++) {
            /*System.out.println(list.get(i));*/
            Point temp = new Point(
                    list.get(i).name,
                    list.get(i).x + x,
                    list.get(i).y + y
            );
            list2.add(i,temp);
        }
        return new Square(list2.get(0), list2.get(1), list2.get(2), list2.get(3));
    }

    @Override
    public String toString() {
        //print
        /*String str = "[";
        for (int i = 0; i < list.size(); i++) {
            str = str + "(" + list.get(i).name + ", " + (double)Math.round(list.get(i).x*100)/100 + ", " + (double)Math.round(list.get(i).y*100)/100 + ")";
        }
        str = str + "]";*/

        String str = "[";
        for (int i = 0; i < list.size(); i++) {
            double x = Math.abs(list.get(i).x) < 1e-8 ? 0 : list.get(i).x;
            double y = Math.abs(list.get(i).y) < 1e-8 ? 0 : list.get(i).y;
            str = str + "(" + list.get(i).name + ", " + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ")";
        }
        str = str + "]";

        return str;
    }

    public Square(Point a, Point b, Point c, Point d) {
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        center = new Point(
                "center",
                (a.x + b.x + c.x + d.x ) / 4,
                (a.y + b.y + c.y + d.y ) / 4);


        // check if four edge^2 are all equal
        /*try{*/
        if ( !(
                (Math.abs(
                        (Math.pow( (list.get(0).x - list.get(1).x), 2) + Math.pow( (list.get(0).y - list.get(1).y), 2))
                - (Math.pow( (list.get(1).x - list.get(2).x), 2) + Math.pow( (list.get(1).y - list.get(2).y), 2))
                ) <0.01)
                && (Math.abs(
                        (Math.pow( (list.get(1).x - list.get(2).x), 2) + Math.pow( (list.get(1).y - list.get(2).y), 2))
                - (Math.pow( (list.get(2).x - list.get(3).x), 2) + Math.pow( (list.get(2).y - list.get(3).y), 2))
                ) <0.01)
                && (Math.abs(
                        (Math.pow( (list.get(2).x - list.get(3).x), 2) + Math.pow( (list.get(2).y - list.get(3).y), 2))
                - (Math.pow( (list.get(3).x - list.get(0).x), 2) + Math.pow( (list.get(3).y - list.get(0).y), 2))
                ) <0.01)
                )
            )
        {
            throw new IllegalArgumentException(": No a Square");
        }
        /*}*/
        /*catch(IllegalArgumentException excp){
            System.out.println( excp + ": No a Square");
        }*/
    }


    public static void main(String... args) {

        Point upright   = new Point("upright", 1, 1);
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
        System.out.println(sq7);

    }


}

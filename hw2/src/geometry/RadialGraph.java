package geometry;
import java.util.*;

public class RadialGraph extends Shape {
    Point center;
    List<Point> list = new ArrayList<>();
    public RadialGraph(Point center, List<Point> neighbors) {
        this.center = center;
        double edgeLengthSquare = (Math.pow(neighbors.get(0).x-center.x, 2) + Math.pow(neighbors.get(0).y-center.y, 2));
        /*try {*/
            for (int i = 0; i < neighbors.size(); i++) {
                double idiot=Math.abs( (Math.pow(neighbors.get(i).x-center.x, 2) + Math.pow(neighbors.get(i).y-center.y, 2)));
                if ((idiot - edgeLengthSquare)>0.01 ){
                    /*throw new IllegalArgumentException();*/
                    /*throw new IllegalArgumentException("Edges have different length");*/
                }
                else {
                    list.add(neighbors.get(i));
                    }
            }
        /*}*/
        /*catch(IllegalArgumentException excp){
            System.out.println( excp + ": Edges have different length");
        }*/

        sortPointsByAngle();

    }
    private void sortPointsByAngle() {
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


    public RadialGraph(Point center) {
        this.center = center;
    }

    @Override
    public RadialGraph rotateBy(int degrees) {
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
        RadialGraph rg = new RadialGraph(center, list2);
        return rg;
    }




    @Override
    public RadialGraph translateBy(double x, double y) {
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
        Point newCenter = new Point("center",center.x + x, center.y + y);
        return new RadialGraph(newCenter, list2);
    }

    @Override
    public String toString() {
        /*String str = "[(center"+ ", " + center.x + ", " + center.y + ")";

        for (int i = 0; i < list.size(); i++) {
            str = str + "; (" + list.get(i).name + ", " + (double)Math.round(list.get(i).x*100)/100 + ", " + (double)Math.round(list.get(i).y*100)/100 +")";
        }
        str = str + "]";*/

        double Cx = Math.abs(center.x < 1e-8 ? 0 : center.x);
        double Cy = Math.abs(center.y < 1e-8 ? 0 : center.y);
        String str = "[("+ center.name + ", " + String.format("%.2f", center.x) + ", " + String.format("%.2f", center.y) + ")";
        for (int i = 0; i < list.size(); i++) {
            double x = Math.abs(list.get(i).x) < 1e-8 ? 0 : list.get(i).x;
            double y = Math.abs(list.get(i).y) < 1e-8 ? 0 : list.get(i).y;
            str = str + "; (" + list.get(i).name + ", " + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ")";
        }
        str = str + "]";

        return str;
    }

    @Override
    public Point center() {
        return center;
    }

    /* Driver method given to you as an outline for testing your code. You can modify this as you want, but please keep
     * in mind that the lines already provided here as expected to work exactly as they are (some lines have additional
     * explanation of what is expected) */
    public static void main(String... args) {
        Point center = new Point("center", 3, 3);
        RadialGraph lonely = new RadialGraph(center);
        Shape g = new RadialGraph(center);
        Shape g1=g.translateBy(0,0);
        System.out.println(g1);



    }
}

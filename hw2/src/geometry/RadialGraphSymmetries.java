package geometry;
import java.util.*;
public class RadialGraphSymmetries implements Symmetries<RadialGraph>{

    @Override
    public boolean areSymmetric(RadialGraph shape, RadialGraph shape2){

        RadialGraphSymmetries graphSymmetries = new RadialGraphSymmetries();
        List<RadialGraph> l = graphSymmetries.symmetriesOf(shape);

        //compare
        for(int i=0; i<l.size(); i++){
            if(l.get(i).toString().equals( shape2.toString() )){
                return true;
            }
        }
        return false;
    }

    private double degreeBetweenTwo (RadialGraph shape, int index1, int index2){
        double angle1 = (double)Math.round(Math.toDegrees(Math.atan2(shape.list.get(index1).y - shape.center.y, shape.list.get(index1).x - shape.center.x))*100)/100;
        double angle2 = (double)Math.round(Math.toDegrees(Math.atan2(shape.list.get(index2).y - shape.center.y, shape.list.get(index2).x - shape.center.x))*100)/100;
        if (angle1 < 0) {
            angle1 += 360;
        }
        if (angle2 < 0) {
            angle2 += 360;
        }
        return (angle1-angle2);
    }


    @Override
    public List<RadialGraph> symmetriesOf(RadialGraph shape) {

        List<RadialGraph> l = new ArrayList<>();
        int n = shape.list.size();

        if(n ==0 ){
            l.add(shape);
            return l;
        }

        RadialGraphSymmetries graphSymmetries = new RadialGraphSymmetries();

        //find the degree between edge0 and edge1
        double degree = 360 - graphSymmetries.degreeBetweenTwo(shape,n-1 ,0);

        //check if each degree between every two edges are the same
        boolean check = true;
        for(int i=0; i<(n-1); i++){
            double degree2 = graphSymmetries.degreeBetweenTwo(shape,i+1 ,i);
            if(degree != degree2){
                check = false;
            }
        }

        if(check) {
            for (int i = 0; i < n; i++) {
                l.add(shape.rotateBy((int)degree * i));
            }
            return l;
        }
        else{

            l.add(shape.rotateBy(0));
            RadialGraph r = shape;
            for(int j = 0; j < (n-1); j++){
                double degree3 = graphSymmetries.degreeBetweenTwo(shape,j+1 ,j);
                r = r.rotateBy((int)degree3);
                boolean check2 = true;
                for(int k = 0; k < shape.list.size(); k++){
                    double idotx = Math.abs(shape.list.get(k).x - r.list.get(k).x);
                    double idoty = Math.abs(shape.list.get(k).y - r.list.get(k).y);
                    if( (idotx >0.01) && (idoty>0.01) ){
                        check2= false;
                    }
                }
                if(check2){
                    l.add(r);
                }
            }
            return l;
        }
    }


    public static void main(String... args){
        Point center    = new Point("center", 1, 1);
        Point north     = new Point("north", 1, 1 + Math.sqrt(2));
        Point southwest = new Point("southwest", 0, 0);
        Point southeast = new Point("southeast", 2, 0);
        RadialGraph g1 = new RadialGraph(center, Arrays.asList(north, southeast, southwest));
        RadialGraph g2 = g1.rotateBy(120);
        RadialGraphSymmetries graphSymmetries = new RadialGraphSymmetries();
        System.out.println(graphSymmetries.areSymmetric(g1, g2));
        List<RadialGraph> symmetries = graphSymmetries.symmetriesOf(g1);
        for (RadialGraph g : symmetries) System.out.println(g );
        
    }

}



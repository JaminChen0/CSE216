package geometry;
import java.util.*;


public class SquareSymmetries implements Symmetries<Square> {

    @Override
    public boolean areSymmetric(Square shape, Square shape2) {
        SquareSymmetries Symmetries = new SquareSymmetries();
        List<Square> l = Symmetries.symmetriesOf(shape);

        //compare
        for(int i=0; i<l.size(); i++){
            if(l.get(i).toString().equals( shape2.toString() )){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Square> symmetriesOf(Square shape) {
        List<Square> l = new ArrayList<>();

        for(int i=0; i<4; i++) {
            l.add(shape.rotateBy(90*i) );
        }

        Point temp = new Point(shape.list.get(3).name, shape.list.get(1).x, shape.list.get(1).y);
        Point temp2 = new Point(shape.list.get(1).name, shape.list.get(3).x, shape.list.get(3).y);
        Square shape2 = shape;
        shape2.list.set(1,temp);
        shape2.list.set(3,temp2);

        for(int k=0; k<4; k++) {
            l.add(shape2.rotateBy(90*k));
        }
        return l;
    }
}

package arithmetic;
import core.Group;

public class FiniteGroupOfOrderTwo implements Group<PlusOrMinusOne> {
    @Override
    public PlusOrMinusOne binaryOperation(PlusOrMinusOne one, PlusOrMinusOne other) {
        if( (one == PlusOrMinusOne.PlusOne && other == PlusOrMinusOne.PlusOne )
                || (one == PlusOrMinusOne.MinusOne && other == PlusOrMinusOne.MinusOne) ){
            return PlusOrMinusOne.PlusOne;
        }
        else{
            return PlusOrMinusOne.MinusOne;
        }

        /*return (one.getValue() * other.getValue() == 1) ? PlusOrMinusOne.PlusOne : PlusOrMinusOne.MinusOne;*/
    }

    @Override
    public PlusOrMinusOne identity() {
        //return 1
        return PlusOrMinusOne.PlusOne;
    }

    @Override
    public PlusOrMinusOne inverseOf(PlusOrMinusOne e){
        return e;
    }

    @Override
    public PlusOrMinusOne exponent(PlusOrMinusOne x, int k) {
        return (k % 2 == 0) ? PlusOrMinusOne.PlusOne : x;
    }
}

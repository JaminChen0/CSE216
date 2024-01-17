package arithmetic;

public enum PlusOrMinusOne {

    PlusOne(1),
    MinusOne(-1);
    private final int value;
    PlusOrMinusOne(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }


}

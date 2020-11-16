package hw2;

public class MyArrayDataException extends NumberFormatException {
    private int numberX;
    private int numberY;

    public MyArrayDataException(int numberX, int numberY) {
        this.numberX = numberX;
        this.numberY = numberY;
    }

    public MyArrayDataException(String s, int numberX, int numberY) {
        super(s);
        this.numberX = numberX;
        this.numberY = numberY;
    }


}

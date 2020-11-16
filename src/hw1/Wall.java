package hw1;

public class Wall implements Barrier {
    private int y;

    public Wall(int y) {
        this.y = y;
    }

    @Override
    public boolean huppen(int val) {
        if(val >= y) {
            return true;
        }
        return false;
    }
}

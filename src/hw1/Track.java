package hw1;

public class Track implements Barrier {
    private int x;

    public Track(int x) {
        this.x = x;
    }

    @Override
    public boolean huppen(int val){
        if(val >= x){
            return true;
        }
        return false;
    }
}

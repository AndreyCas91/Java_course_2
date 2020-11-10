package hw1;

public class Human implements Jumpaning, Runing, Teams {
    private String name;
    private int x;
    private int y;

    public Human(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public void jump() {
        System.out.println("Человек " + name + " прыгнул.");
    }

    @Override
    public void run() {
        System.out.println("Человек " + name + " пробежал.");
    }

    @Override
    public void runing(Track track){
        if(track.huppen(x)){
            run();
        } else {
            System.out.println("Человек " + name + " не пробежал.");
        }
    }

    @Override
    public void jumping(Wall wall){
        if(wall.huppen(y)){
            jump();
        } else {
            System.out.println("Человек " + name + " не перепрыгнул.");
        }
    }

}

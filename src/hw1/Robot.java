package hw1;

public class Robot implements Jumpaning, Runing, Teams {
    private String name;
    private int x;
    private int y;

    public Robot(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public void jump() {
        System.out.println("Робот " + name + " прыгнул.");
    }

    @Override
    public void run() {
        System.out.println("Робот " + name + " пробежал.");
    }

    @Override
    public void runing(Track track){
        if(track.huppen(x)){
            run();
        } else {
            System.out.println("Робот " + name + " не пробежал.");
        }
    }


    public void jumping(Wall wall){
        if(wall.huppen(y)){
            jump();
        } else {
            System.out.println("Робот " + name + " не перепрыгнул.");
        }
    }

}
